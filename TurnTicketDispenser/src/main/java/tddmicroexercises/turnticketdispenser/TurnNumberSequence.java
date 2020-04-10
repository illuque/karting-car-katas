package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence {

    private static int turnNumber = 0;

    public int getNextTurnNumber() {
        return incrementTurn();
    }

    private static int incrementTurn() {
        return turnNumber++;
    }

}
