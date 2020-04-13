# TelemetryDiagnosticControls.java 

## What are the problems with this class?
- **TelemetryDiagnosticControls** will, most probably, change when adding a new _TelemetryClient_ to add a new _telemetryClient instanceof XXX_

## My changes
- Created an smaller interface **TelemetryClientConnector** with _disconnect_ and _connect_ methods
- **AwakeTelemetryClient** now extends **TelemetryClientConnector**, so there is no need to implement _disconnect_ and _connect_.
- Created **SleepTelemetryClientWrapper** extending **TelemetryClientConnector** and wrapping **SleepTelemetryClient**. _disconnect_ and _connect_ are called 
internally by _send_ method.

## What principle does this class violate? Why?

### ISP
- **TelemetryDiagnosticControls** was depending on more methods than the required ones from the interface (_disconnect_ or _connect_) for one of the scenarios.
As explained in the _Single Responsibility Principle_, you should avoid classes and interfaces with multiple responsibilities because they change often and make 
your software hard to maintain.
### OCP
- If a new **TelemetryClient** is added **TelemetryDiagnosticControls** would have to change, so it is not open for extension and closed to modification.
### LSP
- We cannot use the **AwakeTelemetryClient** subclass as if it was the superclass or an exception could be thrown if calling _disconnect_ or _connect_.
The LSP indicates an overridden method of a subclass needs to accept the same input parameter values as the method of the superclass.