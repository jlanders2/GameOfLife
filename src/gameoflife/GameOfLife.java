package gameoflife;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;

public class GameOfLife extends Application{
    private static Cell[][] cells;
    private static boolean pause;
    @Override
    public void start(Stage primaryStage) throws Exception {
    	pause = true;
        cells = new Cell[64][64];
        Button button = new Button("Resume/Pause");
        button.setOnAction(event->{
        	pause = !pause;
        });
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j] = new Cell((double)10,(double)10, i, j);
                root.add(cells[i][j], i, j);
            }
        }
        root.add(button, cells.length, cells[cells.length-1].length);
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer(){
            @Override
            public void handle(long currentNanoTime){
            	if(!pause) {
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
	                try {Thread.sleep(50);}
	                catch(Exception e) {}
            	}
            }
        }.start();
    }
    
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

    public static void main(String[] args){
        launch(args);
    }
}