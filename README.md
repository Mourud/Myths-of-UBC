# Web port is actively being developed: 
~~https://mourud.github.io/village-insurgency/~~
# Strategy Game

This is a 2 player turn based strategy game. Gather gold and food and create an army to defeat your oponent. Kill all your opponent's villagers and soldiers to win. REMEMBER resources are limited.

---
## How to run game:

You must use IntelliJ to run the game.
1. Download code
2. Open project inside IntelliJ
3. go to src/main/ca/ubc/cs/cpsc210/ui/TheMythsOfUbc.java
4. Right click the file and selcet Run TheMythsOfUbc.main()
---


## Rules of the Game:
1. Deafeating all enemy villagers and soilders makes you win
2. Blue starts the game
3. The number of turns you have is equal to the population
4. The turn limit is updated at the beginning of every turn
5. A turn will be consumed in creating a villager/ soldier
6. A turn will be consumed in selecting and moving a vollager/ soldier
7. You can move the same villager/soldier twice
8. Villagers do very little damage
9. Soldiers can't gather resources
10. To gather resources, select a villager and then click on the gold mine or farm
11. To hit opponent select villager/ soldier and click on opponent's villager/ soldier 

---
## Menu guide:
<img width="1440" alt="Screen Shot 2022-02-07 at 5 14 13 PM" src="https://user-images.githubusercontent.com/34059527/152899403-22ddc90c-bc84-496e-a105-e68a650c1f5c.png">
Start New Game: Start a new game<br/>  
Load Game: Load Previously saved game (only one game can be saved)<br/>
Exit: Exit the game<br/>
<img width="1440" alt="Screen Shot 2022-02-07 at 5 21 53 PM" src="https://user-images.githubusercontent.com/34059527/152899988-bc0faa9d-a332-4713-b429-f35e151800b1.png">
Easy: Both players start of with 20 food and gold with 5 villagers<br/>
Medium: Both players start of with 10 food and gold with 3 villagers<br/>
Hard: Both players start of with no food and gold with 2 villagers<br/>
Load Game: Load Game
Main Menu: Return to main menu

---
## Game UI Guide:
<img width="1112" alt="Screen Shot 2022-02-07 at 5 37 58 PM" src="https://user-images.githubusercontent.com/34059527/152902122-aa29d69c-a256-415b-b67d-4a0baf24501c.png">
The Game HUD provides the following information:
1. Who's turn it is
2. How many turn the player has left
3. How much Resources the player has
4. The population
The Game Control buttons:

- Villager: Make new villager (costs 10 food)
- Soldier: Make new soldier (costs 10 food + 10 gold)
- Save: Save game in the current state (only one save state allowed)
- Load: Load previously saved state
- Main Menu: Return to main menu

<img width="336" alt="Screen Shot 2022-02-07 at 6 01 04 PM" src="https://user-images.githubusercontent.com/34059527/152904333-d252c9c3-e9f3-47b9-b169-4730d6dc3874.png">

---
## Known limitations and bugs:
1. Villagers and Soilders can sapwn behind Game HUD
2. Villagers and Solders can spawn/ be placed on top of one another
3. Turn ends are difficult to understand
4. No audio
5. Player can't end turn even if there's nothing to do
6. Sprites have not been added to the game
