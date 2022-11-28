import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaintPanel extends JPanel implements KeyListener, ActionListener, MouseListener, MouseMotionListener {
    Timer timer; // used to control the speed of the application
    private final boolean[] keys;
    private int lastKey = -1; // this is used to store the last key as true until a new key is pressed
    private final Point mouse = new Point(); // stores the x and y-coordinates of the mouse; used for hovering over buttons

    public PaintPanel(){
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        requestFocus();

        timer = new Timer(10, this);
        timer.start();
        keys = new boolean[KeyEvent.KEY_LAST + 1]; // all keys to record the one being pressed

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e){

    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void mouseClicked(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e){

    }

    @Override
    public void mousePressed(MouseEvent e){

    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){
        mouse.x = e.getX();
        mouse.y = e.getY();
    }

    @Override
    public void paint(Graphics g){
        g.setColor(new Color(81, 83, 111));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
