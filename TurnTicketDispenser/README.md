# TicketDispenser.java 

## What are the problems with this class?
- We cannot unit test this class: we have to run the **TurnNumberSequence** logic
- We cannot test all possible scenarios: we cannot control what **TurnNumberSequence** each time (unless sequentially called)
- If we want to change the ticket generator to a new type (non sequential for instance) we will have to modify **TicketDispenser** class

## My changes
- First step:
    - Inject **TurnNumberSequence** instead of instantiating it in **TicketDispenser**
    - Now we can unit test this class by mocking the **TurnNumberSequence**
    - Now we can test all possible scenarios with different mock results
- Second step:
    - Created **TurnNumberGenerator** interface implemented by **TurnNumberSequence** so we now depend on an interface
    - Inject the **TurnNumberGenerator** instead of low level **TurnNumberSequence**
    - Now we no longer depend on low level details: if we change the **TurnNumberSequence** implementation **TicketDispenser** is not changed at all

## What principle does this class violate? Why?

### DIP
- It is instantiating the **TurnNumberSequence** dependency
- We depend on low level details (concrete classes)
- If we want to change the ticket generator to a new type (non sequential for instance) we will have to modify **TicketDispenser** class