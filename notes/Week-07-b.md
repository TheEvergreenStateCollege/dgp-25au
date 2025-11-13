# Week 07b
2025-11-12 Wednesday

## First Half

* Review 

### Questions

* Questions
  * Question 1. What kind of loop is try{} and catch{}?
  * Question 2. Can the directional array be even more delineated (more directions added) without breaking the game?
  * Question 3. How would you add more piece types?

### Radio Communication

* So far, robots can only coordinate through
  * what's baked into their code (constants, random strategies)
  * what they can sense from the map (wall locations, markers, paint) 
* Must be on paint
* Are sent in a particular *round*, and last for 5 rounds after that.
* To and from towers only
* 4 bytes
  * `| type |   y |   x |   sender |`
  * `|   8  |   8 |   8 |   8      |`
  * `| <<24 | <<16| <<8 |          |`

### Introduction Activity

Returning to our introduction activity, you can choose a new game or reuse your previously chosen game.

We will divide up the strategy you gave for your chosen game in three different ways:
* Are there different units in your chosen game?
  * Can you divide up a master strategy so that each kind of unit gets a different sub-strategy to help the overall team win?
* Is there a unit which must move within the game universe to a given location, and then take action there?
  * can you re-state your previous strategy in terms of a sub-strategy for a "pilot" and a sub-strategy for a "gunner"

### New Strategy

[Our current strategy](https://github.com/TheEvergreenStateCollege/dgp-25au/issues/13) is successful on some maps at defeating the reference player.

Let's come up with a new strategy that uses radio communication and marking to augment our original strategy.

That is, we will have a new master strategy.

## Break

## Second Half

Divide up our new strategy into parts that we can work on, and test, independently.

Mob programming in a breakout room.

* Review Homework 06 and 07.
