package tddmicroexercises.leaderboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        Map<Participant, Integer> results = new HashMap<>();
        for (Race race : this.races) {
            for (Participant participant : race.getResults()) {
                int points = race.getPoints(participant);
                if (results.containsKey(participant)) {
                    results.put(participant, results.get(participant) + points);
                } else {
                    results.put(participant, points);
                }
            }
        }
        return results.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey().getPresentationName(),
                        Map.Entry::getValue)
                );
    }

    public List<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        List<String> resultsList = new ArrayList<>(results.keySet());
        resultsList.sort(new DriverByPointsDescendingComparator(results));
        return resultsList;
    }

    private static final class DriverByPointsDescendingComparator implements Comparator<String> {
        private final Map<String, Integer> results;

        private DriverByPointsDescendingComparator(Map<String, Integer> results) {
            this.results = results;
        }

        @Override
        public int compare(String driverName1, String driverName2) {
            Integer driver1Results = results.get(driverName1);
            Integer driver2Results = results.get(driverName2);
            return driver2Results.compareTo(driver1Results);
        }
    }

}