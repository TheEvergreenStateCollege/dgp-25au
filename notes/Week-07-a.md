# Week 07
2025-11-10 Monday

## First Half

* Review, a winning strategy is in sight
  * `teacher05b` vs. `refplayer`

* Questions
  * Question 1. What kind of loop is try{} and catch{}?
  * Question 2. Can the directional array be even more delineated (more directions added) without breaking the game?
  * Question 3. How would you add more piece types?

* Dividing up strategy
  * between multiple kinds of units
  * between "pilot" and "gunner" of the same kind of unit
  * between "sensing" and "marking"

 <img width="262" height="193" alt="image" src="https://github.com/user-attachments/assets/f15310b3-d62b-44c3-bbae-5b20789ed245" />

https://www.youtube.com/watch?v=LvuChgh4fGg

* Update to syllabus: you must beat refplayer on three maps chosen at random

## New Ideas

* Mopper strategy
  * moppers moving towards enemy paint
  * pilot vs. gunner way of dividing up a strategy
 
* Splasher strategy
  * spawning a new splasher
  * detecting painted squares and moving in a random direction until we find fresh squares

## Introduction Activity

Returning to our introduction activity, you can choose a new game or reuse your previously chosen game.

We will divide up the strategy you gave for your chosen game in three different ways:
* Are there different units in your chosen game?
  * Can you divide up a master strategy so that each kind of unit gets a different sub-strategy to help the overall team win?
* Is there a unit which must move within the game universe to a given location, and then take action there?
  * can you re-state your previous strategy in terms of a sub-strategy for a "pilot" and a sub-strategy for a "gunner"

## Review Issues and Commits

* `WrenW01` [refplayer soldier strategy](https://github.com/TheEvergreenStateCollege/dgp-25au/issues/9)
* `dE02` [splasher move/paint interval and spam](https://github.com/TheEvergreenStateCollege/dgp-25au/issues/10)
* `WrenW01` [create more splashers](https://github.com/TheEvergreenStateCollege/dgp-25au/commit/59937e9ddab7124a67ea88f5237ded0f94ca7657)

## Break

## Second Half
