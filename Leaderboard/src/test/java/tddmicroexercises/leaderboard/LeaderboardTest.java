package tddmicroexercises.leaderboard;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tddmicroexercises.leaderboard.TestData.driver1;
import static tddmicroexercises.leaderboard.TestData.driver2;
import static tddmicroexercises.leaderboard.TestData.driver3;

public class LeaderboardTest {

    @Test
    public void driverResults_shouldSumAllRacesPointsForDriver() {
        // setup

        // act
        Map<String, Integer> results = TestData.sampleLeaderboard1.driverResults();

        // verify
        assertTrue("results " + results, results.containsKey("Lewis Hamilton"));
        assertEquals(18 + 18 + 25, (int) results.get("Lewis Hamilton"));
    }

    @Test
    public void driverResults_whenSelfDrivingCarInRanking_shouldSumAllRacesPointsForDriver() {
        // setup

        // act
        Map<String, Integer> results = TestData.sampleLeaderboard2.driverResults();

        // verify
        assertTrue("results " + results, results.containsKey("Self Driving Car - Acme - 1.3"));
        assertEquals(15 + 25 + 15, (int) results.get("Self Driving Car - Acme - 1.3"));
    }

    @Test
    public void driverRankings_shouldSortDriversByPoints() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard1.driverRankings();

        // verify
        assertEquals("Lewis Hamilton", result.get(0));
        assertEquals("Nico Rosberg", result.get(1));
        assertEquals("Sebastian Vettel", result.get(2));
    }

    @Test
    public void driverRankings_whenSelfDrivingCarInRanking_shouldSortDriversByPoints() {
        // setup

        // act
        List<String> result = TestData.sampleLeaderboard2.driverRankings();

        // verify
        assertEquals("Lewis Hamilton", result.get(0));
        assertEquals("Nico Rosberg", result.get(1));
        assertEquals("Self Driving Car - Acme - 1.3", result.get(2));
    }

    @Test
    public void driverRankings_whenDriversWithSamePoints_thenBothShouldBeKept() {
        // setup
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        List<String> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Arrays.asList(driver1.getName(), driver2.getName(), driver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}