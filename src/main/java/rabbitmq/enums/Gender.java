package rabbitmq.enums;

import java.util.Random;

public enum Gender {
    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHERS("OTHERS");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public Gender pick() {
        return Gender.values()[new Random().nextInt(Gender.values().length)];
    }
}
