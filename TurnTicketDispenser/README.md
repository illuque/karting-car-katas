# TicketDispenser.java 

## What are the problems with this class?
- We cannot Unit Test this class: we have to run the TurnNumberSequence logic
- We cannot test all possible scenarios: we are running the Sensor logic, we don't know what it is returning each time
- Other issues:
    - It also breaks OCP: If we want to change the sensor type to, for example, another more-precise implementation, we will have to modify this class
    - Sensor is a concrete class, so we are coupling to an implementation
    
## My changes
- First step:
    - Inject Sensor instead of instantiating it in Alarm
    - Now we can unit test this class by mocking the sensor
    - Now we can test all possible scenarios with different mock results
- Second step:
    - Created PsiChecker interface implemented in PsiCheckerImpl that wraps the external low level dependency Sensor
    - Inject the PsiChecker instead of low level Sensor
    - Now we no longer depend on low level details: if we change the Sensor implementation Alarm is not changed at all

## Dependency Inversion Principle
- Description:
    - Do not depend on low level details
    - Depend on high level abstractions instead
    - Business rules (high level) should not change when implementation details (low level) change
- Goals:
    - Ease implementation and dependencies substitution
    - Decouple higher-level components from their dependency upon lower-level components
- How to achieve it:
    - Inject dependencies
    - Depend upon interfaces of these dependencies
    - LSP as premise        

## Why does this class break DIP?
- It is instantiating the Sensor dependency
- Alarm class would have to change if we change the lower level dependency Sensor to one that has different methods than _check_ or _isAlarmOk_ for example