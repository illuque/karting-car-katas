# Alarm.java 

## What are the problems with this class?
- The test fails randomly depending on the **Sensor** result
- We cannot Unit Test this class: we have to run the **Sensor** logic
- We cannot test all possible scenarios: we are running the **Sensor** logic, we don't know what it is returning each time (pay attention to the Random logic
in **Sensor** class)
- **Sensor** is a concrete class, so we are coupling to an implementation: If we want to change the sensor type to i.e. another one which is faster,
we will have to modify this class
    
## My changes
- First step:
    - Inject **Sensor** instead of instantiating it in **Alarm**
    - Now we can unit test this class by mocking the **Sensor**
    - Now we can test all possible scenarios with different mock results
- Second step:
    - Created PsiChecker interface implemented in PsiCheckerImpl that wraps the external low level dependency **Sensor**
    - Inject the PsiChecker instead of low level **Sensor**
    - Now we no longer depend on low level details: if we change the **Sensor** implementation **Alarm** is not changed at all

## What principle does this class violate? Why?  

### DIP
- It is instantiating the **Sensor** dependency
- **Alarm** class would have to change if we change the lower level dependency **Sensor** to one that has different methods than _check_ or _isAlarmOk_ for example