import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuseListPanel extends BaseListPanel {
    public FuseListPanel(){
        super("Fuse");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new FuseAddEditPanel(true);
                addEditFrame = new AddEditFrame("Fuse", addEditPanel);
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
