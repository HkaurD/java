import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game3 extends JFrame{
    GamePanel game = new GamePanel();

    public Game3(){
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(game);
        pack(); // set the size of my Frame exactly big enough to hold the contents
        setVisible(true);
    }

    public static void main(String[] args){
        Game3 frame = new Game3();
    }
}

class GamePanel extends JPanel implements KeyListener{
    private int boxx, boxy;
    public GamePanel(){
        boxx = 400;
        boxy = 300;
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        requestFocus();
        addKeyListener(this);
    }

    public void move(int dx, int dy){
        boxx += dx;
        boxy += dy;
    }

    @Override
    public void keyReleased(KeyEvent ke){

    }
    @Override
    public void keyPressed(KeyEvent ke){
        int key = ke.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            boxx -= 10;
        }
        else if(key == KeyEvent.VK_RIGHT){
            boxx += 10;
        }
        else if(key == KeyEvent.VK_UP){
            boxy -= 10;
        }
        else if(key == KeyEvent.VK_DOWN){
            boxy += 10;
        }
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent ke){

    }

    @Override
    public void paint(Graphics g){
        g.setColor(new Color(111, 222, 111));
        g.fillRect(0, 0, getWidth(), getHeight()); // getWidth() and getHeight() are from JPanel; GamePanel is a JPanel
        g.setColor(new Color(255, 111, 111));
        g.fillRect(boxx, boxy, 40, 40);
    }
}