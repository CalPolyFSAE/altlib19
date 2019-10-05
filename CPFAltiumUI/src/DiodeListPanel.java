import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiodeListPanel extends BaseListPanel {
    public DiodeListPanel(){
        super("Diode");
    }

    protected void setupAddButtonListener(){
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEditPanel = new DiodeAddEditPanel(true);
                addEditFrame = new AddEditFrame("Diode", addEditPanel);
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
