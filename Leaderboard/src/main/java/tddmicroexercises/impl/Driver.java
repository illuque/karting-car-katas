package tddmicroexercises.impl;

import tddmicroexercises.leaderboard.Participant;

public class Driver implements Participant {

    private final String name;
    private final String country;

    public Driver(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPresentationName() {
        return getName();
    }

    public String getCountry() {
        return country;
    }

}
