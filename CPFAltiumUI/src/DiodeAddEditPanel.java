import javax.swing.*;

public class DiodeAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput voltage = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltage(V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput numcircuits = new BaseAddEditPanel.LabelAndInput(new JLabel("Number Circuits*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("Package:"), new JTextArea(1, 15));

    public DiodeAddEditPanel(boolean isadd){
        super("Diode");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(voltage);
        addLabelAndInput(numcircuits);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        DiodeDao diodeDao = new DaoManager().getDiodeDao();
        return diodeDao.insert(new Diode(this));
    }
}
