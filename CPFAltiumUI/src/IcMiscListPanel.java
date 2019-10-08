import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IcMiscListPanel extends BaseListPanel {
    public IcMiscListPanel(){
        super("IC-Misc");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new IcMiscAddEditPanel(true);
                addEditFrame = new AddEditFrame("IC-Misc", addEditPanel);
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
