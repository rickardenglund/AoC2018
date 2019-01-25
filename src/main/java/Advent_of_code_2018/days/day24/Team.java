package Advent_of_code_2018.days.day24;

import java.util.*;
import java.util.stream.Collectors;

public class Team {
    private final String teamName;
    private List<Group> groups = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public static Team createTeam(String teamName, List<String> groups) {
        Team team = new Team(teamName);

        int i = 1;
        for( var group : groups) {
            team.groups.add(Group.createGroup("" + i++, group));
        }
        return team;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        groups.forEach(group -> {
            sb.append(group);
            sb.append("\n");
        });
        return "Team{" +
                "teamName='" + teamName + "'\n" +
                sb.toString();

    }

    public Map<Group, Optional<Group>> selectTargets(Team otherTeam) {
        Map<Group, Optional<Group>> targets = new HashMap<>();
        List<Group> selectedGroups = new ArrayList<>();
        List<Group> selectorsSorted = groups.stream()
                .sorted(Comparator.comparingInt(Group::getInitiative).reversed())
                .sorted(Comparator.comparingInt(Group::getEffectivePower).reversed())
                .collect(Collectors.toList());

        for (var group: selectorsSorted) {
            Optional<Group> target = otherTeam.groups.stream()
                    .filter(it -> !selectedGroups.contains(it))
                    .sorted(Comparator.comparingInt(Group::getInitiative).reversed())
                    .sorted(Comparator.comparingInt(Group::getEffectivePower).reversed())
                    .sorted(Comparator.comparingInt(group::potentialDamage).reversed())
                    .findFirst();

            target.ifPresent(selectedGroups::add);
            targets.put(group, target);
        }
        return targets;


    }

    public void clearDead() {
        groups = groups.stream().filter(group -> group.getUnits() > 0).collect(Collectors.toList());
    }

    public boolean isAlive() {
        return !groups.isEmpty();
    }

    public int getArmySize() {
        return groups.stream().mapToInt(Group::getUnits).sum();
    }

    public void applyBoost(int boost) {
        groups.forEach(group -> group.increaseAp(boost));
    }
}
