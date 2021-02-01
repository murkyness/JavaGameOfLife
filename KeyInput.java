import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput extends KeyAdapter implements KeyListener {

    boolean paused;

    public KeyInput(boolean paused){

        this.paused = paused;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if(key == KeyEvent.VK_SPACE)
        {
            paused = !paused;
        }
    }

    public void keyReleased(KeyEvent e) {


    }
}
