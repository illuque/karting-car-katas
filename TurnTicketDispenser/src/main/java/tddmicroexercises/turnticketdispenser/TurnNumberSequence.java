package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence implements TurnNumberGenerator {

    private static int turnNumber = 0;

    @Override public int getNextTurnNumber() {
        return incrementTurn();
    }

    private static int incrementTurn() {
        return turnNumber++;
    }

}
