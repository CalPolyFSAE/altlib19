
import javax.swing.*;

public class ButtonsSwitchesAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput resistance = new BaseAddEditPanel.LabelAndInput(new JLabel("resistance*:"), new JTextArea(1, 25));
    protected BaseAddEditPanel.LabelAndInput voltage = new BaseAddEditPanel.LabelAndInput(new JLabel("voltage*:"), new JTextArea(1, 25));
    protected BaseAddEditPanel.LabelAndInput numcontacts = new BaseAddEditPanel.LabelAndInput(new JLabel("numcontacts*:"), new JTextArea(1, 4));
    protected BaseAddEditPanel.LabelAndInput numrows = new BaseAddEditPanel.LabelAndInput(new JLabel("numrows*:"), new JTextArea(1, 4));
    protected BaseAddEditPanel.LabelAndInput pitch = new BaseAddEditPanel.LabelAndInput(new JLabel("pitch*:"), new JTextArea(1, 25));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("package*:"), new JTextArea(1, 20));



    public ButtonsSwitchesAddEditPanel(boolean isadd){
        super("ButtonsSwitches");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(resistance);
        addLabelAndInput(voltage);
        addLabelAndInput(numcontacts);
        addLabelAndInput(numrows);
        addLabelAndInput(pitch);
        addLabelAndInput(packages);


        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        ButtonsSwitchesDao buttonsSwitchesDao = new DaoManager().getButtonsSwitchesDao();
        return buttonsSwitchesDao.insert(new ButtonsSwitches(this));
    }
}
