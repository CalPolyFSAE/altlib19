import javax.swing.*;


public class Crystal extends BasePart{

    private float frequency;
    private String packages;

    public float getFrequency() {
        return frequency;
    }

    public String getPackages() {return packages; }




    public Crystal(CrystalAddEditPanel panel){
        super(panel);


        this.frequency = Float.parseFloat(((JTextArea)panel.frequency.getInput()).getText());
        this.packages = ((JTextArea)panel.packages.getInput()).getText();
    }


}

