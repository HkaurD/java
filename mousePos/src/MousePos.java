import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MousePos extends JFrame{
    GamePanel game= new GamePanel();

    public MousePos() {
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(game);
        pack();  // set the size of my Frame exactly big enough to hold the contents
        setVisible(true);
    }

    public static void main(String[] arguments) {
        MousePos frame = new MousePos();
    }
}

class GamePanel extends JPanel implements KeyListener, ActionListener{
    private int boxx, boxy;
    private boolean []keys;
    Timer timer;

    public GamePanel(){
        keys = new boolean[KeyEvent.KEY_LAST+1];
        boxx = 400;
        boxy = 300;
        setPreferredSize(new Dimension(800, 600));
        timer = new Timer(10, this);
        timer.start();
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    public void move(){
        if(keys[KeyEvent.VK_LEFT]){
            boxx -= 5;
        }
        if(keys[KeyEvent.VK_RIGHT]){
            boxx += 5;
        }
        if(keys[KeyEvent.VK_UP]){
            boxy -= 5;
        }
        if(keys[KeyEvent.VK_DOWN]){
            boxy += 5;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        move();
        repaint();
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        Point offset = getLocationOnScreen();
        System.out.println("("+(mouse.x-offset.x)+", "+(mouse.y-offset.y)+")");
    }

    @Override
    public void keyReleased(KeyEvent ke){
        int key = ke.getKeyCode();
        keys[key] = false;
    }

    @Override
    public void keyPressed(KeyEvent ke){
        int key = ke.getKeyCode();
        keys[key] = true;
    }

    @Override
    public void keyTyped(KeyEvent ke){

    }

    @Override
    public void paint(Graphics g){
        g.setColor(new Color(111,222,111));
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.RED);
        g.fillRect(boxx,boxy,40,40);
    }
}