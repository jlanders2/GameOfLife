package gameoflife;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;

public class GameOfLife extends Application{
    private Cell[][] cells;
    @Override
    public void start(Stage primaryStage) throws Exception {
        cells = new Cell[64][64];
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                cells[i][j] = new Cell((double)10,(double)10, i, j);
                root.add(cells[i][j], i, j);
            }
        }
        
        AnimationTimer animate = new AnimationTimer(){
            @Override
            public void handle(long currentNanoTime){
                for(int i = 0; i< cells.length; i++){
                    for(int j = 0; j < cells[i].length; j++){
                        GameOfLifeRules.checkRules(cells, i, j);
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
        };
        
        Button stop = new Button("Stop");
        stop.setOnAction(event->{
        	animate.stop();
        	});
        
        Button start = new Button("Start");
        start.setOnAction(event->{
        	animate.start();
        	});
        
        root.add(start, cells.length, cells[cells.length-1].length);
        root.add(stop, cells.length, cells[cells.length-1].length+1);
        root.setStyle("-fx-background-color: white");
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Conway's Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}