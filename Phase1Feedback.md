### Phase 1 Feedback

#### General Comments
- you've certainly made a reasonable start on this but it looks like you have
a fair bit of work still to do in your `model` package.

- please be sure to talk with a TA or instructor if you feel you need to trim back
on your initial proposal

#### Checkstyle
- fails - please be sure to run checkstyle regularly - you can't get a
grade from AutoTest if your code fails the checkstyle test 

#### Code coverage
- 36% - you still have a lot of work to do to finish testing your model 
classes


#### Tests
- one of your tests fails - please be sure to look into this before you 
start work on Phase 2


#### Documentation
- you have a lot of work to do in this area.  Some of your classes have 
no documentation at all.  Even if there is only a constructor at this point,
you should add class-level documentation to describe the information in your
domain that is modelled by the class. 


#### Implementation
- you seem to have got off to a good start representing the entities and
resources in the game, but the game logic appears to be largely missing
at this point

- note that you have some unused fields in your `Game` class - be sure to 
tidy these up before submitting the next phase

- the `Registry` class appears to be duplicating most of the behaviours of
`ArrayList` and not changing the names of any of the methods - why not use
`ArrayList` in place of `Registry`?


               