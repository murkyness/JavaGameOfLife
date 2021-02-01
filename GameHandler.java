

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.Graphics;

public class GameHandler {

    public static ArrayList<ArrayList<GameObject>> objectList = new ArrayList<ArrayList<GameObject>>();

    public static ArrayList<ArrayList<GameObject>> prevList = new ArrayList<ArrayList<GameObject>>();

    public void tick() {
    	
    	prevList = objectList;
    	
    	for(int x = 0; x < prevList.size(); x++)
        {
            for(int y = 0; y < prevList.get(x).size(); y++)
            {
                //objectList.get(x).get(y).setState(objectList.get(x).get(y).tick());
            	
            	objectList.get(x).get(y).tick();
            }
        }
    }

    public void render(Graphics g) {

        for(int x = 0; x < objectList.size(); x++)
        {
            for(int y = 0; y < objectList.get(x).size(); y++)
            {
                objectList.get(x).get(y).render(g);
            }
        }
    }

    public void initBoard(int CellNum, int CellSize)
    {
        for(int x = 0; x < CellNum; x++)
        {
            ArrayList<GameObject> column = new ArrayList<GameObject>();

            for(int y = 0; y < CellNum; y++)
            {
                Cell cell = new Cell(x*CellSize, y*CellSize);
                cell.setIndex(x,y);
                column.add(cell);
            }

            objectList.add(column);
        }
        objectList.get(4).get(3).setState(State.Alive);
        objectList.get(5).get(4).setState(State.Alive);
        objectList.get(5).get(5).setState(State.Alive);
        objectList.get(4).get(5).setState(State.Alive);
        objectList.get(3).get(5).setState(State.Alive);
        
        prevList=objectList;
        
        
    }

    public void addObject(int x, int y, GameObject object)
    {
        ArrayList<GameObject> column = this.objectList.get(x);
        column.set(y, object); //Is this enough?


        //objectList.set(x, column);
    }

    public void removeObject(GameObject object)
    {
        this.objectList.remove(object);
    }

    public void setObjectState(int x, int y, State state)
    {
        this.objectList.get(x).get(y).setState(state);
    }
}
