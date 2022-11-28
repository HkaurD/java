import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game2 extends JFrame implements ActionListener{
    GamePanel game = new GamePanel();
    JButton left = new JButton("<==");
    JButton right = new JButton("==>");

    public Game2(){
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(left, BorderLayout.WEST);
        left.addActionListener(this);
        add(right, BorderLayout.EAST);
        right.addActionListener(this);

        add(game);
        pack(); // set the size of my Frame exactly big enough to hold the contents
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object btn = e.getSource();
        if(btn == left){
            game.move(-10, 0);
        }
        if(btn == right){
            game.move(10, 0);
        }
        game.repaint(); // an indirect call to paint; this repaints everything, in this case the panel
    }
    public static void main(String[] args){
        Game2 frame = new Game2();
    }
}

class GamePanel extends JPanel{
    private int boxx, boxy;
    public GamePanel(){
        boxx = 400;
        boxy = 300;
        setPreferredSize(new Dimension(800, 600));
    }

    public void move(int dx, int dy){
        boxx += dx;
        boxy += dy;
    }
    @Override
    public void paint(Graphics g){
        g.setColor(new Color(111, 222, 111));
        g.fillRect(0, 0, getWidth(), getHeight()); // getWidth() and getHeight() are from JPanel; GamePanel is a JPanel
        g.setColor(new Color(255, 111, 111));
        g.fillRect(boxx, boxy, 40, 40);
    }
}
