
import javax.swing.*;

public class CrystalAddEditPanel extends BaseAddEditPanel{
    protected BaseAddEditPanel.LabelAndInput frequency = new BaseAddEditPanel.LabelAndInput(new JLabel("frequency*:"), new JTextArea(1, 15));
    protected BaseAddEditPanel.LabelAndInput packages = new BaseAddEditPanel.LabelAndInput(new JLabel("package*:"), new JTextArea(1, 10));



    public CrystalAddEditPanel(boolean isadd){
        super("Crystal");
        setupLabelsAndInputs();
    }

    public void setupLabelsAndInputs()
    {
        addBasicInput();

        addLabelAndInput(frequency);
        addLabelAndInput(packages);


        addLibraryFootprintInput();
    }

    @Override
    protected int addPartToDatabase() {
        CrystalDao crystalDao = new DaoManager().getCrystalDao();
        return crystalDao.insert(new Crystal(this));
    }
}
