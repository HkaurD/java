import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game1 extends JFrame{
    GamePanel game = new GamePanel();
    public Game1(){
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        add(game);
        setVisible(true);
    }
    public static void main(String[] args){
        Game1 frame = new Game1();
    }
}

class GamePanel extends JPanel{
    int boxx, boxy;
    public GamePanel(){
        boxx = 100;
        boxy = 100;
    }

    @Override
    public void paint(Graphics g){
        g.setColor(new Color(111, 222, 111));
        g.fillRect(0, 0, 500, 500);
    }
}
