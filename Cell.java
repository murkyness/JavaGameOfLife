import java.awt.*;
import java.util.ArrayList;

public class Cell extends GameObject {

    protected State state = State.Dead;
    
    private boolean firstrun = true;

    public void setIndex(int xIndex, int yIndex)
    {
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public int xIndex()
    {
        return this.xIndex;
    }

    public int yIndex()
    {
        return this.yIndex;
    }


    public void setState(State state)
    {
        this.state = state;
    }

    public State getState()
    {
        return this.state;
    }

    public int NumberOfNeighbors()
    {
        int numNeighbors = 0;

        State NW = State.Dead;
        State N = State.Dead;
        State NE = State.Dead;
        
        State W = State.Dead;
        State E = State.Dead;
        
        State SW = State.Dead;
        State S = State.Dead;
        State SE = State.Dead;

        try {NW = GameHandler.prevList.get(xIndex-1).get(yIndex-1).getState();}catch (Exception e){};
        try {N = GameHandler.prevList.get(xIndex).get(yIndex-1).getState();}catch (Exception e){};
        try {NE = GameHandler.prevList.get(xIndex+1).get(yIndex - 1).getState();}catch (Exception e){};
        
        try {W = GameHandler.prevList.get(xIndex-1).get(yIndex).getState();}catch (Exception e){};
        try {E = GameHandler.prevList.get(xIndex+1).get(yIndex).getState();}catch (Exception e){};
        
        try {SW = GameHandler.prevList.get(xIndex-1).get(yIndex+1).getState();}catch (Exception e){};
        try {S = GameHandler.prevList.get(xIndex).get(yIndex+1).getState();}catch (Exception e){};
        try {SE = GameHandler.prevList.get(xIndex+1).get(yIndex+1).getState();}catch (Exception e){};
        
        if(NW == State.Alive){ numNeighbors++;}
        if(N == State.Alive){ numNeighbors++;}
        if(NE == State.Alive){ numNeighbors++;}
        
        if(W == State.Alive){ numNeighbors++;}
        if(E == State.Alive){ numNeighbors++;}
        
        if(SW == State.Alive){ numNeighbors++;}
        if(S == State.Alive){ numNeighbors++;}
        if(SE == State.Alive){ numNeighbors++;}
        
        return numNeighbors;

    }

    @Override
    public State tick()
    {
        
	        if(NumberOfNeighbors() < 2 || NumberOfNeighbors() > 3){
	        	if(this.state == State.Alive) {
	        		System.out.println("Cell " + xIndex + ", " + yIndex + " has died");
	        	}
	        	setState(State.Dead);
	        }
	
	        if(NumberOfNeighbors() == 3){
	        	if(this.state == State.Dead) {
	        		System.out.println("Cell " + xIndex + ", " + yIndex + " was born");
	        	}
	        	setState(State.Alive); 
	        }
        
	        
	    return this.state;
    }

    @Override
    public void render(Graphics g)
    {
        if(state == State.Alive)
        {
            g.setColor(Color.green);
            g.fillRect(x, y, Game.CELLSIZE, Game.CELLSIZE);
        }
        else if(state == State.Dead)
        {
            g.setColor(Color.gray);
            g.drawRect(x, y, Game.CELLSIZE, Game.CELLSIZE);
        }

        g.setColor(Color.red);
        g.drawString(String.valueOf(NumberOfNeighbors()), x+10, y+10);
        g.drawString(xIndex + ", " + yIndex, x+20, y+20);

    }

    public Cell(int x, int y)
    {
        super(x, y, ID.Cell);
    }

}
