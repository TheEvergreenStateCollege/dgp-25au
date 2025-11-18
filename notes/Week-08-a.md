# Week 08a
2025-11-17 Monday

## First Half

* Review
  * spawning more splashers
  * breaking symmetry by robots randomly blocking each other
  * radio communication and requirements for it
  * ways of dividing sub-strategies
    * different unit types do different strategies (`takeAction()`)
    * the same unit acts in different modes (pilot vs. gunner)

### Questions

1. What does 'rc' mean?
2. What does the switch function do?
3. How would you implement a splasher?

### Dividing up Strategy Activity

Like our Week 01 introduction activity, we are again going to choose a game and describe a strategy for it. 


### Radio Messages

* Sign extension.

* Our substrategy for splashers is to spawn multiple of them
  * and assign to each one a different destination
 
* Tower
  * loops over all possible map locations (at a certain interval) as mission locations
  * initialize first mission to `0,0`
  * each time it spawns a splasher
    * wait for splasher to ask for a mission
    * respond with the next mission location
    * increment x,y for next mission location

## Break

## Second Half

* Find a new random map where we don't currently beat reference player
  * will some kind of radio communication strategy with splashers help?
  * define a new strategy issue 

Pair programming in a breakout room to add radio communication to your strategy.
