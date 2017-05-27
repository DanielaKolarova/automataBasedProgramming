
FSM Design Techniques

1. Switch/Case statement 

A switch statement provides one of the easiest to implement and most common version of a state machine. 
For simple FSMs it is both elegant and efficient. All the states and events are visible on one or two pages of code. However, in a FSM with dozens of states and events, the code evolves into a complex block of switch/case constructs which makes it hard to maintain and error-prone. There might also be no separation between the logic of the FSM and the code that implements the actions. Another problem with the switch/case statement is the controlling of valid state transitions. There is no way to enforce the state transition rules.

??? The first problem revolves around controlling what state transitions are valid and which ones are invalid. There is no way to enforce the state transition rules. Any transition is allowed at any time, which is not particularly desirable. For most designs, only a few transition patterns are valid. Ideally the software design should enforce these predefined state sequences and prevent the unwanted transitions. Another problem arises when trying to send data to a specific state. Since the entire state machine is located within a single function, sending additional data to any given state proves difficult. And lastly these designs are rarely suitable for use in a multithreaded system. The designer must ensure the state machine is called from a single thread of control.???


2. State transition tables

A very common technique for implementing FSMs is to create a data table that describes the transitions. This table is interpreted by an engine that handles the events. The engine looks up the the transition that matches the event, invokes the appropriate action, and changes the state.

3. State pattern

A very popular technique for implementing finite state machines is STATE pattern. The pattern combines the efficiency of the nested switch/case statement with the flexibility of interpreting a transition table.

