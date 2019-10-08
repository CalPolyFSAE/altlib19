import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InductorListPanel extends BaseListPanel {
    public InductorListPanel(){
        super("Inductor");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new InductorAddEditPanel(true);
                addEditFrame = new AddEditFrame("Inductor", addEditPanel);
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
