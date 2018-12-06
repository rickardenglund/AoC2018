package Advent_of_code_2018.days.day4;

import java.time.LocalDateTime;
import java.util.Optional;

public class Event implements Comparable<Event> {
    private final LocalDateTime time;
    private final EventType type;
    private final Optional<Long> guardId;

    public Event(LocalDateTime time, EventType type, Long guardId) {
        this.time = time;
        this.type = type;
        this.guardId = Optional.of(guardId);
    }

    public Event(LocalDateTime time, EventType type) {
        this.time = time;
        this.type = type;
        this.guardId = Optional.empty();
    }

    @Override
    public int compareTo(Event o) {
        return time.compareTo(o.getTime());
    }

    public LocalDateTime getTime() {
        return time;
    }

    public EventType getType() {
        return type;
    }

    public Optional<Long> getGuardId() {
        return guardId;
    }

    @Override
    public String toString() {
        return "Event{" +
                time +
                ", " + type +
                ", " + guardId +
                '}';
    }
}
