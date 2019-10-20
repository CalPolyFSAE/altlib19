import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CapacitorListPanel extends BaseListPanel {
    public CapacitorListPanel(){
        super("Capacitor");



        CapacitorDao capDao = new DaoManager().getCapacitorDao();
        Capacitor[] capList = capDao.getCapacitors();
        String[][] stringList = Capacitor.toStringList(capList);
        // Column Names
        String[] columnNames = { "Name", "Roll Number" };

        // Initializing the JTable
        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };

        JTable t = new JTable(stringList, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        t.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(t);
        this.add(sp);
        t.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = t.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if(!cellSelectionModel.)
                    System.out.println(t.getValueAt(t.getSelectedRow(), 0).toString());
            }
        });


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

}
