package Advent_of_code_2018.days.day24;

import Advent_of_code_2018.days.Day;

import java.util.*;
import java.util.stream.Collectors;

public class Day24 implements Day {
    private int boost = 0;

    @Override
    public Object getResultP1(String input) {
        List<Team> teams = ParseSystem(input);
        Team team1 = teams.get(0);
        team1.applyBoost(boost);
        Team team2 = teams.get(1);

        fight(team1, team2);

        return teams.stream().mapToInt(team -> team.getArmySize()).sum();
    }

    private void fight(Team team1, Team team2) {

        while (team1.isAlive() && team2.isAlive()) {
            int previousSizeTeam1 = team1.getArmySize();
            int previousSizeTeam2 = team2.getArmySize();
            // Selection phase
            Map<Group, Optional<Group>> team1Targets = team1.selectTargets(team2);
            Map<Group, Optional<Group>> team2Targets = team2.selectTargets(team1);
            Map<Group, Optional<Group>> attackTargets = new HashMap<>();
            attackTargets.putAll(team1Targets);
            attackTargets.putAll(team2Targets);

            // fight
            List<Group> attackers = attackTargets.keySet().stream()
                    .sorted(Comparator.comparingInt(Group::getInitiative).reversed())
                    .collect(Collectors.toList());

            for (var attacker : attackers) {
                Optional<Group> target = attackTargets.get(attacker);
                target.ifPresent(t -> t.takeDamage(attacker.potentialDamage(t)));
            }
            team1.clearDead();
            team2.clearDead();

            if (team1.getArmySize() == previousSizeTeam1 && team2.getArmySize() == previousSizeTeam2) {
                break;
            }
        }
    }

    private List<Team> ParseSystem(String input) {
        List<String> lines = input.lines().collect(Collectors.toList());
        int emptyRow = -1;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) {
                emptyRow = i;
                break;
            }
        }
        List<String> team1strings = lines.subList(1, emptyRow);
        List<String> team2strings = lines.subList(emptyRow + 2, lines.size());

        Team team1 = Team.createTeam(lines.get(0), team1strings);
        Team team2 = Team.createTeam(lines.get(emptyRow + 1), team2strings);
        return List.of(team1, team2);
    }


    @Override
    public Object getResultP2(String input) {
        int boost = 0;
        Team team1;
        Team team2;
        do {
            boost += 1;
//            if (boost % 1000 == 0)
//            System.out.println(boost);
            List<Team> teams = ParseSystem(input);
            team1 = teams.get(0);
            team1.applyBoost(boost);
            team2 = teams.get(1);

            fight(team1, team2);
        } while ((team2.isAlive()));

        System.out.println("t1: " + team1.getArmySize());
        System.out.println("t2: " + team2.getArmySize());
        return team1.getArmySize() + team2.getArmySize();
    }

    @Override
    public int getDay() {
        return 24;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }
}
