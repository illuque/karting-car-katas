package tddmicroexercises.turnticketdispenser;

public class TicketDispenser {

    private TurnNumberSequence turnNumberSequence;

    public TicketDispenser(TurnNumberSequence turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket() {
        int newTurnNumber = turnNumberSequence.getNextTurnNumber();
        return new TurnTicket(newTurnNumber);
    }

}
