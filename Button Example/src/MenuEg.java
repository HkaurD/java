/* MenuEg
 *
 * This is the standard frame setup for the menuExample.
 *
 **/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuEg extends JFrame {
    GamePanel game;

    public MenuEg() {
        super("Move the Box");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new GamePanel(this);
        add(game);
        pack();
        setVisible(true);
    }

    public static void main(String[] arguments) {
        MenuEg frame = new MenuEg();
    }
}