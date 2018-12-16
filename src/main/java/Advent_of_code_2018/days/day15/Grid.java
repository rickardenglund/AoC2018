package Advent_of_code_2018.days.day15;

import Advent_of_code_2018.util.Pos;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Grid {
    private Entity[][] grid;
    private int deadElves = 0;

    private Grid(Entity[][] grid) {
        this.grid = grid;
    }

    public static Grid createGrid(String input) {
        String[] lines = input.split("\n");

        Entity[][] grid = new Entity[lines[0].length()][lines.length];

        for (int y = 0; y < lines.length; y++) {
            for (int x = 0; x < lines[y].length(); x++) {
                grid[x][y] = createEntity(lines[lines.length - y - 1].charAt(x));
            }
        }
        return new Grid(grid);
    }


    void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = getHeight() - 1; y >= 0; y--) {
            List<Warrior> list = new ArrayList<>();
            for (int x = 0; x < getWidth(); x++) {
                if (get(new Pos(x, y)) instanceof Warrior) {
                    Warrior warrior = (Warrior) get(new Pos(x, y));
                    list.add(warrior);
                }
                sb.append(grid[x][y].toString());
            }
            sb.append("   ");
            list.forEach(w -> sb.append(w + "(" + w.getHealth() + "), "));
            if (!list.isEmpty()) sb.delete(sb.length() - 2, sb.length() - 1);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toStringNoStats() {
        StringBuilder sb = new StringBuilder();
        for (int y = getHeight() - 1; y >= 0; y--) {
            List<Warrior> list = new ArrayList<>();
            for (int x = 0; x < getWidth(); x++) {
                if (get(new Pos(x, y)) instanceof Warrior) {
                    Warrior warrior = (Warrior) get(new Pos(x, y));
                    list.add(warrior);
                }
                sb.append(grid[x][y].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private static Entity createEntity(char charAt) {
        switch (charAt) {
            case '#':
                return new Wall();
            case 'E':
                return new Elf();
            case 'G':
                return new Goblin();
            case '.':
                return new Space();
        }
        throw new RuntimeException("Unknown Entity");
    }

    int tick = 0;

    public void walk() {
        for (int y = getHeight() - 1; y > -1; y--) {
            for (int x = 0; x < getWidth(); x++) {
                Pos current = new Pos(x, y);
                walk(x, y, current);
            }
        }
        tick++;
    }

    private void walk(int x, int y, Pos current) {
        if (get(current) instanceof Warrior) {
            Warrior warrior = (Warrior) get(current);
            if (warrior.getlastModified() < tick) {
                warrior.setUpdate(tick);
                List<Pos> pathToEnemy = getPathToEnemy(current);
                Pos nextPos = current;
                if (!pathToEnemy.isEmpty()) {
                    nextPos = pathToEnemy.get(0);
                    grid[x][y] = new Space();
                    grid[nextPos.getX()][nextPos.getY()] = warrior;
                }

                attack(nextPos.getX(), nextPos.getY());
            }
        }
    }

    private void attack(int x, int y) {
        Pos current = new Pos(x, y);
        if (get(current) instanceof Warrior) {
            Warrior warrior = (Warrior) get(current);
            warrior.setUpdate(tick);
            Optional<Pos> enemyPos = getAdjacent(current, getOppositeClass(warrior));
            if (enemyPos.isPresent()) {
                Warrior enemy = (Warrior) get(enemyPos.get());
                enemy.takeDamage(warrior.getAttackPower());
                if (!enemy.isAlive()) {
                    grid[enemyPos.get().getX()][enemyPos.get().getY()] = new Space();
                    if (enemy instanceof Elf) {
                        deadElves++;
                    }
                }
            }
        }
    }

    private int getHeight() {
        return grid[0].length;
    }

    private int getWidth() {
        return grid.length;
    }

    public int healthAt(Pos pos) {
        Entity entity = get(pos);
        if (entity instanceof Warrior) {
            Warrior warrior = (Warrior) entity;
            return warrior.getHealth();
        }
        return -1;

    }

    public boolean moreFighting() {
        AtomicInteger nElves = new AtomicInteger();
        AtomicInteger nGoblins = new AtomicInteger();
        Arrays.stream(grid).flatMap(Arrays::stream)
                .forEach(e -> {
                    if (e instanceof Elf) {
                        nElves.getAndIncrement();
                    } else if (e instanceof Goblin) {
                        nGoblins.getAndIncrement();
                    }
                });

        return nElves.get() > 0 && nGoblins.get() > 0;
    }

    public int totalHp() {
        return Arrays.stream(grid).flatMap(Arrays::stream)
                .filter(e -> e instanceof Warrior)
                .mapToInt(w -> ((Warrior) w).getHealth())
                .sum();
    }

    public int getTick() {
        return tick;
    }

    public int getDeadElves() {
        return deadElves;
    }

    class Node {

        Pos pos;
        private final Node parent;

        public Node(Pos pos, Node parent) {
            this.pos = pos;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return pos.equals(node.pos);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pos);
        }

        @Override
        public String toString() {
            return pos.toString();
        }

    }

    List<Pos> getPathToEnemy(Pos pos) {
        Entity e = get(pos);
        if (e instanceof Warrior) {
            Class enemyClass = getOppositeClass((Warrior) e);
            return findPath(pos, enemyClass);
        }
        throw new IllegalStateException("Bad doing");
    }

    private Class getOppositeClass(Warrior e) {
        return (e instanceof Goblin) ? Elf.class : Goblin.class;
    }

    List<Pos> findPath(Pos pos, Class clazz) {
        Deque<Node> toVisit = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        Node current = new Node(pos, null);
        visited.add(current);
        toVisit.add(current);


        while ((current = toVisit.pollFirst()) != null) {
            if (getClosePos(current.pos, clazz).isPresent()) {
                return getPath(current);
            }

            // Find available neighbors
            List<Pos> neighbours = getNeighborPositions(current.pos).stream()
                    .filter(p -> get(p) instanceof Space)
                    .filter(p -> !visited.contains(new Node(p, null)))
                    .collect(Collectors.toList());

            for (var neighbour : neighbours) {
                var newNode = new Node(neighbour, current);
                visited.add(newNode);
                toVisit.add(newNode);
            }
        }
        return Collections.emptyList();
    }

    private List<Pos> getPath(Node current) {
        ArrayList<Pos> list = new ArrayList<>();

        //skip the src node
        while (current.parent != null) {
            list.add(current.pos);
            current = current.parent;
        }
        Collections.reverse(list);
        return list;
    }

    private Optional<Pos> getClosePos(Pos pos, Class clazz) {
        List<Pos> neighbours = getNeighborPositions(pos);
        Optional<Pos> enemy = neighbours.stream().filter(p -> clazz.isInstance(get(p))).findFirst();
        return enemy;
    }

    private Optional<Pos> getAdjacent(Pos pos, Class clazz) {
        List<Pos> neighbours = getNeighborPositions(pos);
        List<Pos> enemies = neighbours.stream()
                .filter(p -> clazz.isInstance(get(p)))
                .collect(Collectors.toList());

        int i = selectAtackee(enemies);
        return i != -1 ? Optional.of(enemies.get(i)) : Optional.empty();
    }

    private int selectAtackee(List<Pos> enemies) {
        int attackee = -1;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < enemies.size(); i++) {
            Warrior warrior = (Warrior) get(enemies.get(i));
            if (warrior.getHealth() < max) {
                attackee = i;
                max = warrior.getHealth();
            }
        }
        return attackee;
    }

    List<Pos> getNeighborPositions(Pos pos) {
        List<Pos> list = new ArrayList<>();
        if (pos.getY() < getHeight() - 2)
            list.add(new Pos(pos.getX(), pos.getY() + 1)); // UP
        if (pos.getX() > 0)
            list.add(new Pos(pos.getX() - 1, pos.getY())); // LEFT
        if (pos.getX() < getWidth() - 2)
            list.add(new Pos(pos.getX() + 1, pos.getY())); //RIGHT
        if (pos.getY() > 0)
            list.add(new Pos(pos.getX(), pos.getY() - 1)); // DOWN
        return list;
    }

    private Entity get(Pos pos) {
        return grid[pos.getX()][pos.getY()];
    }
}
