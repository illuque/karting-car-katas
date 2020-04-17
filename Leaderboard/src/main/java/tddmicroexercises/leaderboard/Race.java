package tddmicroexercises.leaderboard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {

    private static final Integer[] POINTS = new Integer[] { 25, 18, 15 };

    private final String name;
    private final List<Participant> results;
    private final Map<Participant, String> participantNames;

    public Race(String name, Participant... participants) {
        this.name = name;
        this.results = Arrays.asList(participants);
        this.participantNames = new HashMap<>();
        for (Participant participant : results) {
            String participantName = participant.getName();
            this.participantNames.put(participant, participantName);
        }
    }

    public int position(Participant participant) {
        return this.results.indexOf(participant);
    }

    public int getPoints(Participant participant) {
        return Race.POINTS[position(participant)];
    }

    public List<Participant> getResults() {
        return results;
    }

    public String getDriverName(Participant participant) {
        return this.participantNames.get(participant);
    }

    @Override
    public String toString() {
        return name;
    }
}