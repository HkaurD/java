import javax.swing.*;

public class PaintMain extends JFrame{ // this class calls PaintPanel; the driver class
    PaintPanel canvas = new PaintPanel();

    public PaintMain(){
        super("Paint by Kaur"); // title of the program (top of window)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(canvas);
        pack(); // sets a default size for the Frame based on the contents from PaintPanel
        setVisible(true);
    }

    public static void main(String[] args){
        PaintMain frame = new PaintMain();
    }
}
