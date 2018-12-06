package Advent_of_code_2018.days.day4;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shift {

    private final Long guardId;
    private final List<Event> events;
    private final LocalDateTime startTime;

    public Shift(Event guard, List<Event> events) {
        this.guardId = guard.getGuardId().get();
        this.startTime = guard.getTime();
        this.events = events;
    }

    LocalDate getDate() {
        if (startTime.getMinute() == 23) {
            return startTime.toLocalDate().plusDays(1);
        } else {
            return startTime.toLocalDate();
        }
    }

    List<Integer> getSleepingMinutes() {
        if (events.isEmpty()) return Collections.emptyList();
        int min = 0;
        List<Integer> sleeps = new ArrayList<>();
        for (var e : events) {
            if (e.getType().equals(EventType.SLEEP)) {
                while (min < e.getTime().getMinute()) {
                    min++;
                }
            } else {
                while (min < e.getTime().getMinute()) {
                    sleeps.add(min++);
                }
            }
        }

        while (min < 60) {
            if (events.get(events.size()-1).getType().equals(EventType.SLEEP)) {
                sleeps.add(min);
            }
            min++;
        }
        return sleeps;
    }

    public Long getGuardId() {
        return guardId;
    }
}
