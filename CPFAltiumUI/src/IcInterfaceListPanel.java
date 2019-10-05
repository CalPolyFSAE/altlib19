import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IcInterfaceListPanel extends BaseListPanel {
    public IcInterfaceListPanel(){
        super("IC-Interface");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new IcInterfaceAddEditPanel(true);
                addEditFrame = new AddEditFrame("IC-Interface", addEditPanel);
                closeAddEditFrameListener();
            }
        });
    }

    protected String[] getColumns(){
        String [] columns={"name","age"};
        return columns;
    }

    protected String[][] getData(){
        String[][] data = {{"akash","20"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};
        return data;
    }

}
