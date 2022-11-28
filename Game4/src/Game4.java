import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game4 extends JFrame{
    GamePanel game = new GamePanel();

    public Game4(){
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(game);
        pack(); // set the size of my Frame exactly big enough to hold the contents
        setVisible(true);
    }

    public static void main(String[] args){
        Game4 frame = new Game4();
    }
}

class GamePanel extends JPanel implements KeyListener, ActionListener{
    private int boxx, boxy;
    private boolean[] keys;
    Timer timer;

    public GamePanel(){
        keys = new boolean [KeyEvent.KEY_LAST + 1]; // normally the last key ascii value is 256, but some keyboards have more keys
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
        else if(keys[KeyEvent.VK_RIGHT]){
            boxx += 5;
        }
        else if(keys[KeyEvent.VK_UP]){
            boxy -= 5;
        }
        else if(keys[KeyEvent.VK_DOWN]){
            boxy += 5;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        move();
        repaint();
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
        int key = ke.getKeyCode();
    }

    @Override
    public void paint(Graphics g){
        g.setColor(new Color(111, 222, 111));
        g.fillRect(0, 0, getWidth(), getHeight()); // getWidth() and getHeight() are from JPanel; GamePanel is a JPanel
        g.setColor(new Color(255, 111, 111));
        g.fillRect(boxx, boxy, 40, 40);
    }
}