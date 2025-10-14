# Week 03a
2025-10-13 Monday

## First Half

* Syllabus update - a request for your cameras to be on during Zoom class
  * main way to be present for each other and build a community
  * sometimes it is due to personal circumstances or lack of a dedicated space, we can help find solutions to address your concerns
  * if you have a reason you feel strongly about for not having cameras on, let's find a time to talk about it outside of class

### Code Sharing In-Class Activity (Git)
* We each have code that is not "in" Git. What does that mean?
  * each of you, zip up your code and email the attachment (or send by Discord DM)
  * unzip, and try to identify changes that you don't have, and integrate it into your codebase

Question:

* what are some problems you notice with this approach?
* Come up with at least three, and submit them in Canvas.
* Use the actual code you sent and received in ZIP files as examples.

### Git Statuses

* Tracks changes in a top-level directory called a *repository*, or a repo.
* When you clone a repository locally, it's called a *working directory* and can have files in three different *statuses*
  * clean, committed (unmodified)
  * modified, staged
  * modified, unstaged
 
You can think of file statuses as being able to move forwards in stages towards a new "committed" status.

```mermaid
graph LR;
  A["old commit, clean"] --"edit in text editor"--> B["modified, unstaged"];
  A --"create a new file or dir"--> D["untracked"];
  B --"`git add`"--> C["modified, staged"];
  C --"`git commit`"--> E["new commit, clean"];
  D --"`git add`"--> C["modified, staged"];
```

You can think of your "goal" in software development with Git is to eventually move all files into
the "clean, new commit" status at the end, which means if your computer were to lose power at
the moment, or your cat were to jump on your keyboard, you could reliably recover the state of
each file back to the last commit (after you restore power, or put your cat in another room).

In your local working directory, where you cloned `dgp-25au`, run the following command

```
git status
```

You can run this command any number of times and it doesn't change the repo.
It's called a *read-only* command.

You can also think of the development cycle of using Git as a circle, where the last and first
committed states are the same. We repeatedly move files through cycles like this if we changed and
develop code in them, or they stay the same if we don't edit code in them.

```mermaid
graph LR;
  A["committed, clean"] --"edit in text editor"--> B["modified, unstaged"];
  A --"create a new file or dir"--> D["untracked"];
  B --"`git add`"--> C["modified, staged"];
  D --"`git add`"--> C["modified, staged"];
  C --"`git commit`"--> A;
  
```

For *all* files in a repo, you can think about which of these three statuses each file is in,
and how you might move that file in between the statuses.

For example, when I run `git status` in my own repo I get

```
% git status
On branch main
Your branch is up to date with 'origin/main'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   gradle.properties
        modified:   src/refplayer/RobotPlayer.java
        modified:   src/week01a/RobotPlayer.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        ../.vscode/
        ../activities/BottleSong.class
        ../activities/BottleSong.java
        src/teacher02b/

no changes added to commit (use "git add" and/or "git commit -a")
```

What statuses is each file above in, and why?

## Break

## Second Half (Battlecode)

Painting.
