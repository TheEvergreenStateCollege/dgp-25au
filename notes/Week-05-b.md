# Week 05b
2025-10-29 Wednesday

## First Half

* `week04b` player with spiral movement
* Pair debugging to set up a development environment; not all progress is
* As a team, consider thinking of one person being stuck as the whole team being stuck

### Quiz 05

Review of inheritance and subclasses to share common behavior and make promises about supported.

## Break

## Second Half

### Decomposing Strategy

"Tactics is doing what needs to be done. Strategy is knowing when nothing is to be done."

An example strategy we created together last time.

Why state a strategy in English?

Pros

* Helps us think and reason about *what would be useful*,  than *what will it look like in code*
* It can take as much, or more, time as tactics
* We can learn to state in English at a technical-enough level to make writing code easier (pseudocode)
* We can divide up strategy into "sub-strategies" and decide on an interface. For example:
  * one part is bots searching for enemy paint
  * one part is bots moving towards a single tile of enemy paint and unpainting it
* We could move between these states based on what we sense, and our own internal state

What are some cons?

* We may become stuck in "analysis paralysis" without being able to test our ideas
* It may not be fun
* We don't encounter surprises as we incrementally code and run our player

Let's work on transferring some ideas from `teacher05b` player to `week05b`
