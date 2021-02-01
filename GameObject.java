

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class GameObject {

    protected int x, y; //accessible only to inheritors
    protected ID id;
    protected int xIndex, yIndex;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract State tick();

    public abstract void render(Graphics g);

    public void setState(State state){

    }

    public State getState(){
        return null;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setID(ID id) {
        this.id = id;
    }

    public ID getID() {
        return id;
    }
}