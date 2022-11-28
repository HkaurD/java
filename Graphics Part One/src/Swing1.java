import java.awt.event.*;
import javax.swing.*; // Lightweight - Built in Java
                //  extends: inherits from, Actionlistener is an interface
                                  // implementing an interface is like
                                  // agreeing to a contract
                                  // You agree to add the methods that are in the interface
                                  // java agrees to call the methods at the right time
public class Swing1 extends JFrame implements ActionListener{
    JButton load = new JButton("Load");
    JButton save = new JButton("Save");
    JButton exit = new JButton("Exit");

    public Swing1(){
        super("Fun with Buttons!");
        setSize(800, 600); // includes the drawing frame AND title bar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        load.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);

        JPanel pane = new JPanel();
        pane.add(load);
        pane.add(save);
        pane.add(exit);
        add(pane);

        setVisible(true); // sets the frame to be visible; it is initially hidden since if you have a lot of resources,
                         // you want to download them first and then show the frame
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        Object source = evt.getSource();
        if(source == load){
            System.out.println("load that stuff");
        }
        if(source == save){
            System.out.println("don't want to lose that stuff");
        }
        if(source == exit){
            System.out.println("I gotta bounce.");
        }
    }

    public static void main(String[] args){
        Swing1 eg1 = new Swing1();
    }
}