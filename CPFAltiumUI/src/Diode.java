import javax.swing.*;

public class Diode extends BasePart{
    private float voltage;
    private int numcircuits;
    private String packageString;


    public float getVoltage() {
        return voltage;
    }


    public int getNumcircuits() {
        return numcircuits;
    }

    public String getPackageString() {
        return packageString;
    }

    public Diode(DiodeAddEditPanel panel){
            super(panel);

            this.voltage = Float.parseFloat(((JTextArea)panel.voltage.getInput()).getText());
            this.numcircuits = Integer.parseInt(((JTextArea)panel.numcircuits.getInput()).getText());
            this.packageString = ((JTextArea)panel.packages.getInput()).getText();
        }
}
