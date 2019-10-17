import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrystalListPanel extends BaseListPanel {
    public CrystalListPanel(){
        super("Crystals");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new CrystalAddEditPanel(true);
                addEditFrame = new AddEditFrame("Crystal", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }
}









