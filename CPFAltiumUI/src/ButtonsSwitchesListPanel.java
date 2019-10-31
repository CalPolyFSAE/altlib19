import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsSwitchesListPanel extends BaseListPanel {
    public ButtonsSwitchesListPanel(){
        super("Buttons and Switches");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new ButtonsSwitchesAddEditPanel(true);
                addEditFrame = new AddEditFrame("Buttons and Switches", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}


