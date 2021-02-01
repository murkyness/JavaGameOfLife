
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running = false;

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH;
    public static final int CELLNUM = 10;
    public static final int CELLSIZE = WIDTH/CELLNUM;

    private static final int TARGET_FPS = 60;
    private static final double OPTIMAL_TIME = 1000000000 / ((double)TARGET_FPS);

    public GameHandler handler = new GameHandler();

    public Game(){

        new Window(WIDTH, HEIGHT, "MyGame1", this);

        handler.initBoard(CELLNUM, CELLSIZE);

        render();

    }

    public void run(){

        int loopcount = 0;

        render(); 
        render(); //for some reason these are necessary here to make the first tick() display

        while(running){

        	loopcount++;
        	System.out.println("Update number " + loopcount);

            render();
            tick();
            
            //try{Thread.sleep(5000);}catch(Exception e){}
            
        
        }

        stop();
    }

    private void tick(){
    	
    	handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Game();
    }


}
