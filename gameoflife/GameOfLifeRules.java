public class GameOfLifeRules {
	public static void checkRules(Cell[][] cells, int x, int y) {
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
}
