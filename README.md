Karting Car Katas
=================

This is a Kata about SOLID principles.

What is the reason for the name **Karting Car Katas**? This Kata is based on the [Racing Car Katas](https://github.com/emilybache/Racing-Car-Kata) by Emily
Bache. However, I have made some changes in a couple of exercises to make more clear the SOLID violations and, consequently, the Kata is faster. So it is no
longer **Racing Car Katas** but **Karting Car Katas**... :p (TBH, I don't know why the original one is called **Racing Car Katas**, it has only one exercise
related with Racing... ¯\\\_(ツ)_/¯

A quick (very summarized) introduction to SOLID patterns can be found
[in this presentation](https://docs.google.com/presentation/d/1XDM_vfddSpw7OC0gzJV0jiFSw2Ho9RWRu58-WZjP_cg/edit?usp=sharing)

In this repository you'll find starting code for five distinct problems. They could be code you inherited from a legacy code-base. Now you want to write unit
tests for them. All the code snippets fail to follow one or more of the **SOLID** principles.

For each exercise, you should identify which **SOLID** principles are not being followed by the code. There is only one class you are interested in writing
tests for right now. As a first step, try to get some kind of test in place before you change the class at all. If the tests are hard to write, is that because
of the problems with **SOLID** principles?

(NOTE: Depending on the time we have to do this Kata, thinking about the missing tests and how to implement them could be enough for the purpose of this Kata,
but I recommend you to take the "full experience" on your own if not possible during the Kata.)

When you have some kind of test to lean on, refactor the code and make it testable. Take care when refactoring not to alter the functionality, or change
interfaces which other client code may rely on (imagine there is client code in another repository that you can't see right now).

Apply the unit testing style and framework you are most comfortable with. You can choose to use stubs or mocks or none at all. If you do, you are free to use
the mocking tool that you prefer.

1. **TirePressureMonitoringSystem exercise**:  write the unit tests for the **Alarm** class. The **Alarm** class is designed to monitor tire pressure and set
   an alarm if the pressure falls outside of the expected range. The **Sensor** class provided for the exercise fakes the behaviour of a real tire sensor,
   providing random but realistic values.

2. **TextConverter exercise**: write the unit tests for the **HtmlTextConverter** class. The **HtmlTextConverter** class is designed to reformat a plain text
   file for display in a browser.

3. **TicketDispenser exercise**: write the unit tests for the **TicketDispenser**. The **TicketDispenser** class is designed to be used to manage a queuing
   system in a shop. There may be more than one ticket dispenser but the same ticket should not be issued to two different customers.

4. **TelemetrySystem exercise**: (***) write the unit tests for the **TelemetryDiagnosticControls** class. We had **SleepTelemetryClient** as library
   dependency. Then we needed another client, **AwakeTelemetryClient**. Both clients will coexist and more will come in the future.

5. **Leaderboard exercise**: (***) in this exercise you should focus on **Race** and **Leaderboard** classes logic. Write the missing unit tests for the
   **Leaderboard** class, including races with self driving cars. The **Leaderboard** calculates driver points and rankings based on results from a number of
   **Race**s.

As I've mentioned at the beginning of this README, this is a modified version of this [Racing Car Katas](https://github.com/emilybache/Racing-Car-Kata). If you
feel like it, you can try doing the exercises 4) and 5) (the ones I have modified) from the original Kata and we can share the results: I wasn't able to spot
some of the failing SOLID principles here (no spoilers :p ) so maybe I can learn from you ;)

Master branch is only intended to present the exercise. I have created one branch per exercise with my opinionated spotted SOLID violations and
changes: each commit on each of these branches represent a small step on the refactor to SOLID.

(***) Note, this is a modified version of the original exercise