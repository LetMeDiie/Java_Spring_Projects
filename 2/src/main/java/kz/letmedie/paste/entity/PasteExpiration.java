package kz.letmedie.paste.entity;

import java.time.Duration;

public enum PasteExpiration {
    ONE_MINUTE(Duration.ofMinutes(1)),
    ONE_HOUR(Duration.ofHours(1)),
    ONE_DAY(Duration.ofDays(1)),
    ONE_WEEK(Duration.ofDays(7)),
    ONE_MONTH(Duration.ofDays(30)),
    INFINITE(null);
    private final Duration duration;

    PasteExpiration(Duration duration) {
        this.duration = duration;
    }

    public Duration getDuration() {
        return this.duration;
    }
}

