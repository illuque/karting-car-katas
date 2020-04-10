package tddmicroexercises.turnticketdispenser;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TicketDispenserTest {

    @Mock
    private TurnNumberSequence turnNumberSequence;

    @Before
    public void setUp() {
        when(turnNumberSequence.getNextTurnNumber()).thenReturn(0).thenReturn(1).thenReturn(2).thenReturn(3);
    }

    @Test
    public void whenFirstRequest_thenTicketZero() {
        TicketDispenser ticketDispenser = new TicketDispenser(turnNumberSequence);

        assertEquals(0, ticketDispenser.getTurnTicket().getTurnNumber());
    }

    @Test
    public void whenTwoRequests_thenConsecutiveTickets() {
        TicketDispenser ticketDispenser = new TicketDispenser(turnNumberSequence);

        TurnTicket turnTicket1 = ticketDispenser.getTurnTicket();
        TurnTicket turnTicket2 = ticketDispenser.getTurnTicket();

        assertThat(turnTicket2.getTurnNumber(), is(turnTicket1.getTurnNumber() + 1));
    }

    @Test
    public void whenTwoDispensersAndTwoRequests_thenConsecutiveTickets() {
        TicketDispenser ticketDispenser1 = new TicketDispenser(turnNumberSequence);
        TicketDispenser ticketDispenser2 = new TicketDispenser(turnNumberSequence);

        TurnTicket turnTicket1 = ticketDispenser1.getTurnTicket();
        TurnTicket turnTicket2 = ticketDispenser2.getTurnTicket();

        assertThat(turnTicket2.getTurnNumber(), is(turnTicket1.getTurnNumber() + 1));
    }

    @Test
    public void whenNewDispenserAndTicketsAlreadyDispensed_thenConsecutiveTickets() {
        TicketDispenser ticketDispenser1 = new TicketDispenser(turnNumberSequence);
        TurnTicket turnTicket1 = ticketDispenser1.getTurnTicket();

        TicketDispenser ticketDispenser2 = new TicketDispenser(turnNumberSequence);
        TurnTicket turnTicket2 = ticketDispenser2.getTurnTicket();

        assertThat(turnTicket2.getTurnNumber(), is(turnTicket1.getTurnNumber() + 1));
    }

}