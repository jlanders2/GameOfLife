import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Cell extends Rectangle{
    public enum Status{
        ALIVE, DEAD
    }
    private Status status;
    private boolean aliveNextCycle, deadNextCycle;
    private int xLocation, yLocation;
    public Cell(Double width, Double height, int x, int y){
        setWidth(width);
        setHeight(height);
        setStroke(Color.LIGHTGRAY);
        setStatus(Status.DEAD);
        aliveNextCycle = false;
        deadNextCycle = false;
        xLocation = x;
        yLocation = y;
        setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
            	if(getStatus() == Status.DEAD) {
            		setStatus(Status.ALIVE);
            	}
            	else {
            		setStatus(Status.DEAD);
            	}
            }
        });
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        if(status == Status.ALIVE){
            setFill(Color.BLACK);
        }
        else{
            setFill(Color.WHITE);
        }
        this.status = status;
    }

    public void updateStatus(){
        if(isAliveNextCycle()){
            setStatus(Status.ALIVE);
            makeAliveNextCycle(false);
        }
        else if(isDeadNextCycle()){
            setStatus(Status.DEAD);
            makeDeadNextCycle(false);
        }
        else{return;}
    }

    public boolean isAliveNextCycle(){
        return aliveNextCycle;
    }

    public boolean isDeadNextCycle(){
        return deadNextCycle;
    }

    public void makeAliveNextCycle(boolean aliveNextCycle){
        this.aliveNextCycle = aliveNextCycle;
    }

    public void makeDeadNextCycle(boolean deadNextCycle){
        this.deadNextCycle = deadNextCycle;
    }
    
    public int getXLocation() {
    	return xLocation;
    }
    
    public int getYLocation() {
    	return yLocation;
    }
}
