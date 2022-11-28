import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game5 extends JFrame{
    GamePanel game = new GamePanel();

    public Game5(){
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(game);
        pack(); // set the size of my Frame exactly big enough to hold the contents
        setVisible(true);
    }

    public static void main(String[] args){
        Game5 frame = new Game5();
    }
}

class GamePanel extends JPanel implements KeyListener, ActionListener, MouseListener{
    private int boxx, boxy;
    private int ballx = -1, bally = 1;
    public static final int INTRO = 0, GAME = 1, END = 2;
    private int screen = INTRO;

    private boolean[] keys;
    Timer timer;
    Image back;

    public GamePanel(){
        back = new ImageIcon("OuterSpace.jpeg").getImage();
        keys = new boolean [KeyEvent.KEY_LAST + 1]; // normally the last key ascii value is 256, but some keyboards have more keys
        boxx = 400;
        boxy = 300;
        setPreferredSize(new Dimension(640, 480));
        timer = new Timer(10, this);
        timer.start();

        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        addMouseListener(this);
    }

    public void move(){
        if(screen == INTRO){

        }
        else if(screen == GAME) {
            if (keys[KeyEvent.VK_LEFT]) {
                boxx -= 5;
            } else if (keys[KeyEvent.VK_RIGHT]) {
                boxx += 5;
            } else if (keys[KeyEvent.VK_UP]) {
                boxy -= 5;
            } else if (keys[KeyEvent.VK_DOWN]) {
                boxy += 5;
            }
        }
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
        if(screen == INTRO){
            if(e.getX() > 360 && e.getX() < 460 && e.getY() > 200 && e.getY() < 230){
                screen = GAME;
            }
        }
        else if(screen == GAME) {
            ballx = e.getX();
            bally = e.getY();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e){

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
        if(screen == INTRO){
            g.setColor(new Color(137, 196, 234));
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.RED);
            g.fillRect(360, 200, 100, 30);
        }
        else if(screen == GAME) {
            g.drawImage(back, 0, 0, this);

            g.setColor(new Color(255, 111, 111));
            g.fillRect(boxx, boxy, 40, 40);

            g.setColor(Color.YELLOW);
            g.fillOval(ballx, bally, 40, 40);
        }
    }
}