package programManagers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HandlerUpdatePwButton extends JButton implements ActionListener {

    public HandlerUpdatePwButton() {
        super("Update a password");
        this.addActionListener(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Update password button clicked");
    }
}
