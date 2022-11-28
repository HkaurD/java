import java.awt.event.*;
import javax.swing.*;

public class Convert extends JFrame implements ActionListener {
    JTextField inchTxt;
    JLabel cmAns;
    JButton con;

    public Convert() {
        super("The Convertzor!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        JLabel inchLbl = new JLabel("Inches: ");
        pane.add(inchLbl);
        inchTxt = new JTextField(5);
        pane.add(inchTxt);

        JLabel cmLbl = new JLabel("cm: ");
        pane.add(cmLbl);
        cmAns = new JLabel("     ");
        pane.add(cmAns);

        con = new JButton("Convert");
        con.addActionListener(this);
        pane.add(con);

        add(pane);
        pack(); // set the size of the window according to the content
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        double in = Double.parseDouble(inchTxt.getText());
        cmAns.setText("" + in*2.54);

    }
    public static void main(String[] args){
        new Convert();
    }
}
