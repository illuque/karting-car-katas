package tddmicroexercises.turnticketdispenser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TicketDispenserTest {

    @Test
    public void whenFirstRequest_thenTicketZero() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        assertEquals(0, ticketDispenser.getTurnTicket().getTurnNumber());
    }

    @Test
    public void whenTwoRequests_thenConsecutiveTickets() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        TurnTicket turnTicket1 = ticketDispenser.getTurnTicket();
        TurnTicket turnTicket2 = ticketDispenser.getTurnTicket();

        assertThat(turnTicket2.getTurnNumber(), is(turnTicket1.getTurnNumber() + 1));
    }

    @Test
    public void whenTwoDispensersAndTwoRequests_thenConsecutiveTickets() {
        TicketDispenser ticketDispenser1 = new TicketDispenser();
        TicketDispenser ticketDispenser2 = new TicketDispenser();

        TurnTicket turnTicket1 = ticketDispenser1.getTurnTicket();
        TurnTicket turnTicket2 = ticketDispenser2.getTurnTicket();

        assertThat(turnTicket2.getTurnNumber(), is(turnTicket1.getTurnNumber() + 1));

    }

}