package tddmicroexercises.impl;

import tddmicroexercises.leaderboard.Participant;

public class SelfDrivingCar implements Participant {

    private String algorithmVersion;
    private String company;

    public SelfDrivingCar(String algorithmVersion, String company) {
        this.algorithmVersion = algorithmVersion;
        this.company = company;
    }

    @Override
    public String getName() {
        return "Self Driving Car" + " - " + company;
    }

    @Override
    public String getPresentationName() {
        return getName() + " - " + algorithmVersion;
    }

    public String getAlgorithmVersion() {
        return algorithmVersion;
    }

    public void setAlgorithmVersion(String algorithmVersion) {
        this.algorithmVersion = algorithmVersion;
    }

}
