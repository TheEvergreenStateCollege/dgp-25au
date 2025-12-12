Alexis Baker


Distributed Game Playing


Homework 2


11/07/2025

### Original Submission, 11/07/2025


**Question 1:**
What does 'rc' mean?

**Question 2:**
What does the switch function do?

**Question 3:** How would you implement a splasher?


**Feedback from Prof. Pham, 11/17/25:**


Part 1: Readings and exercises


Where is this part? Because Canvas does not let you attach images to a text entry assignment, please submit these in [this other assignment.](https://canvas.evergreen.edu/courses/7771/assignments/144709)


Part 2: 


Good questions, we will go over them in class today, and as part of Homework 8 you will attempt an answer to all three of them.


Part 3:


Where are your pseudocode statements for this part?


**Response from Alexis Baker, 11/17/25:**

Submitted the screenshots to the designated place about five minutes ago. Completely blanked on the pseudocode statements, will get those in before class.


### Additional Submission: Pseudocode


**Painting**
```
if tile color of current location != team color:
    if can paint:
        paint the current location
```


**Sensing and Saving the Home Tower**
```
if (home tower location is not yet saved):
    home tower location = sense closest friendly tower()
```


```
if (remaining paint <= distance to home tower):
    move toward home tower location)
```
