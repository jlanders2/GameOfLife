package gameoflife;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.animation.AnimationTimer;

public class GameOfLife extends Application{
    private static Cell[][] cells;
    @Override
    public void start(Stage primaryStage) throws Exception {
        cells = new Cell[320][170];

        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j] = new Cell((double)5,(double)5, i, j);
                root.add(cells[i][j], i, j);
            }
        }
        //Gun 1
        staticLifeCreator();


       //Gosper Glider Gun
       gosperGliderGun();



        Scene scene = new Scene(root);
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer(){
            @Override
            public void handle(long currentNanoTime){
                for(int i = 0; i< cells.length; i++){
                    for(int j = 0; j < cells[i].length; j++){
                        checkRules(i,j);
                    }
                }
                for(int i = 0; i< cells.length; i++){
                    for(int j = 0; j < cells[i].length; j++){
                        cells[i][j].updateStatus();
                    }
                }
                try{Thread.sleep(75);}
                catch(Exception e){}
            }
        }.start();
    }
    //Works Correctly
    public void checkRules(int x, int y){
        int aliveNeighbors = 0;
        for(int i = y-1; i <= y + 1; i++){
            if(i >= 0 && i < cells[x].length){
                if(x-1 >= 0){
                    if(cells[x-1][i].getStatus() == Cell.Status.ALIVE){
                        aliveNeighbors++;
                    }
                }
                if(i != y){
                    if(cells[x][i].getStatus() == Cell.Status.ALIVE){
                        aliveNeighbors++;
                    }
                }
                if(x+1 < cells.length){
                    if(cells[x+1][i].getStatus() == Cell.Status.ALIVE){
                        aliveNeighbors++;
                    }
                }
            }
        }
        if((aliveNeighbors == 2 || aliveNeighbors == 3) && cells[x][y].getStatus() == Cell.Status.ALIVE){
            cells[x][y].makeAliveNextCycle(true);
        }
        else if((aliveNeighbors < 2 || aliveNeighbors > 3) && cells[x][y].getStatus() == Cell.Status.ALIVE){
            cells[x][y].makeDeadNextCycle(true);
        }
        if(aliveNeighbors == 3 && cells[x][y].getStatus() == Cell.Status.DEAD){
            cells[x][y].makeAliveNextCycle(true);
        }
    }

    public void gosperGliderGun(){
        cells[1][5+2].setStatus(Cell.Status.ALIVE);
        cells[1][6+2].setStatus(Cell.Status.ALIVE);
        cells[2][5+2].setStatus(Cell.Status.ALIVE);
        cells[2][6+2].setStatus(Cell.Status.ALIVE);
        cells[14][3+2].setStatus(Cell.Status.ALIVE);
        cells[13][3+2].setStatus(Cell.Status.ALIVE);
        cells[12][4+2].setStatus(Cell.Status.ALIVE);
        cells[11][5+2].setStatus(Cell.Status.ALIVE);
        cells[11][6+2].setStatus(Cell.Status.ALIVE);
        cells[11][7+2].setStatus(Cell.Status.ALIVE);
        cells[12][8+2].setStatus(Cell.Status.ALIVE);
        cells[13][9+2].setStatus(Cell.Status.ALIVE);
        cells[14][9+2].setStatus(Cell.Status.ALIVE);
        cells[15][6+2].setStatus(Cell.Status.ALIVE);
        cells[16][4+2].setStatus(Cell.Status.ALIVE);
        cells[17][5+2].setStatus(Cell.Status.ALIVE);
        cells[17][6+2].setStatus(Cell.Status.ALIVE);
        cells[18][6+2].setStatus(Cell.Status.ALIVE);
        cells[17][7+2].setStatus(Cell.Status.ALIVE);
        cells[16][8+2].setStatus(Cell.Status.ALIVE);
        cells[21][3+2].setStatus(Cell.Status.ALIVE);
        cells[21][4+2].setStatus(Cell.Status.ALIVE);
        cells[21][5+2].setStatus(Cell.Status.ALIVE);
        cells[22][3+2].setStatus(Cell.Status.ALIVE);
        cells[22][4+2].setStatus(Cell.Status.ALIVE);
        cells[22][5+2].setStatus(Cell.Status.ALIVE);
        cells[23][2+2].setStatus(Cell.Status.ALIVE);
        cells[23][6+2].setStatus(Cell.Status.ALIVE);
        cells[25][1+2].setStatus(Cell.Status.ALIVE);
        cells[25][2+2].setStatus(Cell.Status.ALIVE);
        cells[25][6+2].setStatus(Cell.Status.ALIVE);
        cells[25][7+2].setStatus(Cell.Status.ALIVE);
        cells[35][3+2].setStatus(Cell.Status.ALIVE);
        cells[35][4+2].setStatus(Cell.Status.ALIVE);
        cells[36][3+2].setStatus(Cell.Status.ALIVE);
        cells[36][4+2].setStatus(Cell.Status.ALIVE);
    }

    public void staticLifeCreator(){
        for(int i = 0; i < 64; i++){
            if(i>= 17 && i <= 24){
                cells[i][64].setStatus(Cell.Status.ALIVE);
            }
            if(i>= 26 && i <= 30){
                cells[i][64].setStatus(Cell.Status.ALIVE);
            }
            if(i>= 34 && i <= 36){
                cells[i][64].setStatus(Cell.Status.ALIVE);
            }
            if(i>= 43 && i <= 49){
                cells[i][64].setStatus(Cell.Status.ALIVE);
            }
            if(i>= 51 && i <= 55){
                cells[i][64].setStatus(Cell.Status.ALIVE);
            }
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}