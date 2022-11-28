import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoadSave extends JFrame{
    //

    public LoadSave() {
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel game= new GamePanel();
        add(game);
        pack();
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                game.saveScores();
            }
        });
    }

    public static void main(String[] arguments) {
        LoadSave frame = new LoadSave();
	/*	ArrayList<Score>high = new ArrayList<Score>();
		high.add(new Score("Joe", 44));
		high.add(new Score("Sue", 144));
		high.add(new Score("Bob", 424));
		Collections.sort(high);
		System.out.println(high);*/
    }
}

class GamePanel extends JPanel implements KeyListener, ActionListener, MouseListener{
    private int boxx, boxy;
    private int ballx=-1, bally=-1;
    public static final int INTRO=0, GAME=1, END=2;
    private int screen = INTRO;
    ArrayList<Score>high;
    private boolean []keys;
    Timer timer;
    Image back;

    public GamePanel(){

        high = loadScores();
        keys = new boolean[KeyEvent.KEY_LAST+1];
        setPreferredSize(new Dimension(800, 600));

        setFocusable(true);
        requestFocus();
        addKeyListener(this);
        addMouseListener(this);
        timer = new Timer(20, this);
        timer.start();
    }

    public void saveScores(){
        try{
            PrintWriter out = new PrintWriter(new File("scores.txt"));
            for(Score sc:high){
                out.println(sc.twoLine());
            }
            out.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public ArrayList<Score>loadScores(){
        ArrayList<Score>tmp=new ArrayList<Score>();
        try{
            Scanner input = new Scanner(new File("scores.txt"));
            for(int i=0; i<10; i++){
                String name = input.nextLine();
                int points = Integer.parseInt(input.nextLine());
                tmp.add(new Score(name, points));
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return tmp;
    }

    @Override
    public void actionPerformed(ActionEvent e){
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
    public void keyTyped(KeyEvent ke){}
    @Override
    public void	mouseClicked(MouseEvent e){}

    @Override
    public void	mouseEntered(MouseEvent e){}

    @Override
    public void	mouseExited(MouseEvent e){}

    @Override
    public void	mousePressed(MouseEvent e){
        String name = JOptionPane.showInputDialog("Name:");
        int points = Integer.parseInt(JOptionPane.showInputDialog("Score:"));
        if(points > high.get(9).getScore()){
            high.set(9,new Score(name, points));
            Collections.sort(high);
        }
    }

    @Override
    public void	mouseReleased(MouseEvent e){}

    @Override
    public void paint(Graphics g){
        Font fnt = new Font ("Arial", Font.BOLD, 20);
        g.setFont (fnt);
        g.setColor(new Color(137,196,234));
        g.fillRect(0,0,getWidth(), getHeight());
        g.setColor(Color.RED);
        int y=0;
        if(high!= null){
            for(Score s : high){
                g.drawString(""+s, 100, y* 50 + 50);
                y++;
            }
        }
    }
}

class Score implements Comparable<Score>{
    String name;
    int score;

    public Score(String n, int s){
        name = n;
        score = s;
    }
    public int getScore(){return score;}


    @Override
    public int compareTo(Score s2){
        if(score==s2.score){
            return -name.compareTo(s2.name);
        }
        else{
            return  s2.score-score;
        }
    }

    public String twoLine(){
        return String.format("%s\n%d", name, score);
    }

    @Override
    public String toString(){
        return String.format("%-20s%5d", name, score);
    }
}