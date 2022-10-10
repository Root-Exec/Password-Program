package programManagers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlerDeletePwButton extends JButton implements ActionListener {

    public HandlerDeletePwButton() {
        super("Delete a password");
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Delete password button clicked");
    }
}
