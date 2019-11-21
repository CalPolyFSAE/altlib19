import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IcMicrocontrollersListPanel extends BaseListPanel {
    public IcMicrocontrollersListPanel(){
        super("IcMicrocontrollers");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new IcMicrocontrollersAddEditPanel(true);
                addEditFrame = new AddEditFrame("IcMicrocontrollers", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }

}
