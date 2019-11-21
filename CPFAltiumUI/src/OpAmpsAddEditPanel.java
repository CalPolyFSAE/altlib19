import javax.swing.*;

public class OpAmpsAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput type  = new BaseAddEditPanel.LabelAndInput(new JLabel("Type*:"), new JTextArea(1, 30));
    protected BaseAddEditPanel.LabelAndInput num_circuits = new BaseAddEditPanel.LabelAndInput(new JLabel("Num_Circuits*:"), new JTextArea(1, 3));
    protected BaseAddEditPanel.LabelAndInput voltage = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltage(V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput slewrate = new BaseAddEditPanel.LabelAndInput(new JLabel("Slewrate*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput gbw = new BaseAddEditPanel.LabelAndInput(new JLabel("Gbw*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput currentoutput = new BaseAddEditPanel.LabelAndInput(new JLabel("CurrentOutput*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput voltagelow = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltagelow(V)*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput voltagehigh = new BaseAddEditPanel.LabelAndInput(new JLabel("Voltagehigh(V)*:"), new JTextArea(1, 15));

    public OpAmpsAddEditPanel(boolean isadd){
        super("OpAmps");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(type);
        addLabelAndInput(num_circuits);
        addLabelAndInput(voltage);
        addLabelAndInput(slewrate);
        addLabelAndInput(gbw);
        addLabelAndInput(currentoutput);
        addLabelAndInput(voltagelow);
        addLabelAndInput(voltagehigh);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        OpAmpsDao opampsDao = new DaoManager().getOpAmpsDao();
        return opampsDao.insert(new OpAmps(this));
    }
}

