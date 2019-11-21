import javax.swing.*;

public class IcMicrocontrollersAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput Vcc  = new BaseAddEditPanel.LabelAndInput(new JLabel("Vcc*:"), new JTextArea(1, 45));
    protected BaseAddEditPanel.LabelAndInput packages  = new BaseAddEditPanel.LabelAndInput(new JLabel("packages*:"), new JTextArea(1, 45));

    public IcMicrocontrollersAddEditPanel(boolean isadd){
        super("IcMicrocontrollers");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(Vcc);
        addLabelAndInput(packages);

        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        IcMicrocontrollersDao icmicrocontrollersDao = new DaoManager().getIcMicrocontrollersDao();
        return icmicrocontrollersDao.insert(new IcMicrocontrollers(this));
    }
}

