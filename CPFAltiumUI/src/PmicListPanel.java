import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PmicListPanel extends BaseListPanel {
    public PmicListPanel(){
        super("PMIC");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new PmicAddEditPanel(true);
                addEditFrame = new AddEditFrame("PMIC", addEditPanel);
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
