# Leaderboard.java 

## What are the problems with this class?
- Let's add tests for the **SelfDrivingCar**... can you spot the issue? The name is mutable now, so we cannot use the
base class as if it was the **Driver**
- More _if statement_ will be raised if new Driver types appear and this class would have to change

## My changes
- Added **Participant** interface with _getName()_ and _getPresentationName()_ methods
- **Driver** and **SelfDrivingCar** implement this **Participant** interface
- Moved **Driver** and **SelfDrivingCar** to impl folder
- Updated **Leaderboard** and **Race** to use **Participant**: This interface methods are the only relevant for **Leaderboard** and **Race**.
_getPresentationName()_ is used as **Leaderboard** output and _getName()_ is used internally for the calculations (for both **Leaderboard** and **Race**) 

## What principle does this class violate? Why?

### LSP
- We cannot replace **Driver** instance by its subclasses transparently in **Leaderboard**, the failing tests prove it

### ISP
- **Leaderboard** and **Race** do not need all methods from **Driver** but still they have access to them

### OCP
- It is probable that a new type of driver would cause another _if statement_ in **Leaderboard**