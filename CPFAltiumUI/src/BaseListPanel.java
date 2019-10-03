import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import org.omg.CORBA.WStringSeqHelper;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public abstract class BaseListPanel extends JPanel{
    protected EventListenerList bjtListenerList = new EventListenerList();
    protected JButton addBtn;
    protected AddEditFrame addEditFrame;
    protected BaseAddEditPanel addEditPanel;

    public BaseListPanel(String componentName){
        setupBasics(componentName);
        addBtn = new JButton("Add " +componentName );
        this.add(addBtn);
        setupAddButtonListener();
        setupJTableBasic();
    }

    protected void setupBasics(String componentName){
        this.setVisible(true);
        setBorder(BorderFactory.createTitledBorder(componentName+" List Page"));
    }

    protected void closeAddEditFrameListener(){
        addEditPanel.addAddEditPanelListener(new BasicListener() {
            @Override
            public void basicEventOccured() {
                addEditFrame.setVisible(false); //making the frame visible
                addEditFrame.dispose();
            }
        });
    }

    protected void setupJTableBasic(){
        String[] columns = getColumns();
        String[][] data = getData();

        DefaultTableModel model = new DefaultTableModel(data,columns) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //Only the third column
                return false;
            }
        };

        JTable table = new JTable(model);

        table.setPreferredScrollableViewportSize(new Dimension(1300,300));
        table.setFillsViewportHeight(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //table.setPreferredScrollableViewportSize(Toolkit.getDefaultToolkit().getScreenSize());

        JScrollPane js=new JScrollPane(table);
        js.setVisible(true);
        add(js);
/*
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    StringBuffer sb = new StringBuffer();
                    String lineSeparator = System.getProperty("line.separator");
                    sb.append(tabledata[row][0] + lineSeparator);
                    sb.append(tabledata[row][1] + lineSeparator);
                    sb.append(tabledata[row][2] + lineSeparator);
                    TextFrame textFrame = new TextFrame(sb.toString());
                    textFrame.setVisible(true);
                }
            }
        });*/
    }

    protected abstract void setupAddButtonListener();
    protected abstract String[] getColumns();
    protected abstract String[][] getData();
}
