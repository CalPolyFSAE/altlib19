import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResistorListPanel  extends BaseListPanel {
    public ResistorListPanel(){
        super("Resistor");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new ResistorAddEditPanel(true);
                addEditFrame = new AddEditFrame("Resistor", addEditPanel);
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
