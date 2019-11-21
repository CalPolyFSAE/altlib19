import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpAmpsListPanel extends BaseListPanel {
    public OpAmpsListPanel(){
        super("OpAmps");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new OpAmpsAddEditPanel(true);
                addEditFrame = new AddEditFrame("OpAmps", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }

}