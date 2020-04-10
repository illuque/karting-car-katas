package tddmicroexercises.turnticketdispenser;

public class TicketDispenser {

    private TurnNumberGenerator turnNumberGenerator;

    public TicketDispenser(TurnNumberGenerator turnNumberGenerator) {
        this.turnNumberGenerator = turnNumberGenerator;
    }

    public TurnTicket getTurnTicket() {
        int newTurnNumber = turnNumberGenerator.getNextTurnNumber();
        return new TurnTicket(newTurnNumber);
    }

}
