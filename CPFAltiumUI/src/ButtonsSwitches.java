import sun.jvm.hotspot.types.CIntegerType;

import javax.swing.*;


public class ButtonsSwitches extends BasePart{

    private float resistance;
    private float voltage;
    private int numcontacts;
    private int numrows;
    private float pitch;
    private String packages;

    public float getResistance() {
        return resistance;
    }
    public float getVoltage() {
        return voltage;
    }
    public int getNumContacts() {
        return numcontacts;
    }
    public int getNumRows() {
        return numrows;
    }
    public float getPitch() {
        return pitch;
    }
    public String getPackages() {return packages; }




    public ButtonsSwitches(ButtonsSwitchesAddEditPanel panel){
        super(panel);


        this.resistance = Float.parseFloat(((JTextArea)panel.resistance.getInput()).getText());
        this.voltage = Float.parseFloat(((JTextArea)panel.voltage.getInput()).getText());
        this.numcontacts = Integer.parseInt(((JTextArea)panel.numcontacts.getInput()).getText());
        this.numrows = Integer.parseInt(((JTextArea)panel.numrows.getInput()).getText());
        this.pitch = Float.parseFloat(((JTextArea)panel.pitch.getInput()).getText());
        this.packages = ((JTextArea)panel.packages.getInput()).getText();
    }


}
