# Week 04a
2025 October 20, Monday

## First Half

Review last time

### Game Design

From Tynan Sylvester, creator of Rimworld, a book about Game Design.

<img width="356" height="537" alt="image" src="https://github.com/user-attachments/assets/6df893dd-ee4f-4701-92c5-192b71744e51" />

In HW 04 assigned today, you'll read the Kindle Sample from the Amazon link above and apply
those principles to understand Battlecode, and write a player that doesn't win against the
reference player, but evokes an emotion by losing in an interesting way.

### Refresh Introduction Activity (10 minutes)

If this is your first time, introducing yourself, do the [Intro Activity](https://github.com/TheEvergreenStateCollege/dgp-25au/blob/main/activities/Introductions.md).

If this is your second time, do [Step 6](https://github.com/TheEvergreenStateCollege/dgp-25au/blob/main/activities/Introductions.md#step-6) to update your first introduction Markdown file.

## Break

## Second Half (TBD)

### AWS Outage and Ref Player

A DNS failure that led to downstream failures that depend on it.

In distributed gameplaying, our `refplayer` has a lot of code.

Let's read through it and determine what one line we could change so that it does not beat our own player.

### Preview Battlecode Pair Programming

We'll go over the painting behavior in `teacher03b` and observe how the percentage
of the map painted increases over time, as a measure of relative success.

<img width="1331" height="838" alt="image" src="https://github.com/user-attachments/assets/b48cf35f-b569-4f2a-85ea-880a48d6fe18" />

Breakout Room Activity:
* Existing students will go into a breakout room, where they will take turns driving and navigating
  * the driver will run `git pull`, create a new player directory `week04a`, copy over `RobotPlayer.java` from `week03b`
  * the navigator will read from [`teacher03b` source code](https://github.com/TheEvergreenStateCollege/dgp-25au/tree/main/java/src/teacher03b)
  * every 3 lines or so, the driver and navigator should `git add`, `git commit` and `git push` and switch.
* New students will stay in the main meeting and go over the [Software Setup](https://github.com/TheEvergreenStateCollege/dgp-25au/blob/main/notes/SoftwareSetup.md)

### Quiz-04

https://canvas.evergreen.edu/courses/7771/assignments/143608
