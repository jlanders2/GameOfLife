# GameOfLife
The program I have created is a clone I made from the ground up of the popular  
Conway's Game of Life game.  

***Not optimized yet***  
This is just a little side project to work on my optimization skills and mess  
around with different patterns in Conway's Game of Life.  

## A little bit about the game
If you have never heard of the "Game of Life", developed by John Conway in the
early 70's I suggest that you check out the wikepedia page listed here:
https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life. It is a fun little game 
that replicates cell automation. Below I will list some fun patterns to get you 
started.    

## Patterns
### Still Patterns
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Game_of_life_block_with_border.svg/66px-Game_of_life_block_with_border.svg.png)
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Game_of_life_beehive.svg/98px-Game_of_life_beehive.svg.png)
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Game_of_life_loaf.svg/98px-Game_of_life_loaf.svg.png)
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Game_of_life_boat.svg/82px-Game_of_life_boat.svg.png)
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Game_of_life_flower.svg/82px-Game_of_life_flower.svg.png)
### Oscillating Patterns
![alt text](https://upload.wikimedia.org/wikipedia/commons/9/95/Game_of_life_blinker.gif)
![alt text](https://upload.wikimedia.org/wikipedia/commons/1/12/Game_of_life_toad.gif)
![alt text](https://upload.wikimedia.org/wikipedia/commons/1/1c/Game_of_life_beacon.gif)
![alt text](https://upload.wikimedia.org/wikipedia/commons/0/07/Game_of_life_pulsar.gif)
![alt text](https://upload.wikimedia.org/wikipedia/commons/f/fb/I-Column.gif)
### Spaceship Patterns *(AKA - Patterns that move on their own)*
![alt text](https://upload.wikimedia.org/wikipedia/commons/f/f2/Game_of_life_animated_glider.gif)
![alt text](https://upload.wikimedia.org/wikipedia/commons/3/37/Game_of_life_animated_LWSS.gif)  
### *These are not all the possible patterns but a few ones that are used alot*

**To run**  
Step 1 : Download Repository  
Step 2 : Open Command Prompt and navigate to the folder you downloaded  
Step 3 : Enter the following commands:
> cd gameoflife  
> javac GameOfLife.java  
> javac Main.java  
> jar cmvf manifest.mf GameOfLife.jar ./\*.java ./\*.class  
> java -jar GameOfLife.jar  
Step 4 : *Have fun using my Conway's Game of Life Program!!!*  

***Note: Requires Java 8***