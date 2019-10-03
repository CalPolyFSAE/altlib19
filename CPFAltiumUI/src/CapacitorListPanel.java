import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CapacitorListPanel extends BaseListPanel {
    public CapacitorListPanel(){
        super("Capacitor");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new CapacitorAddEditPanel(true);
                addEditFrame = new AddEditFrame("Capacitor", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }

    protected String[] getColumns(){
        CapacitorDao capacitorDao = new DaoManager().getCapacitorDao();
        return capacitorDao.getColumns();
    }

    protected String[][] getData(){
        String[][] data = {{"akash","20"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};
        return data;
    }
}
