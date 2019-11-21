import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OpAmps extends BasePart{
    private String type ;
    private int num_circuits;
    private float voltage;
    private float slewrate;
    private float gbw;
    private float currentoutput;
    private float voltagelow;
    private float voltagehigh;


    public String getType() {
        return type;
    }

    public int getNum_circuits() { return num_circuits;}

    public float getVoltage() {
        return voltage;
    }

    public float getSlewrate() {
        return slewrate;
    }

    public float getGbw() {
        return gbw;
    }

    public float getCurrentoutput() {
        return currentoutput;
    }

    public float getVoltagelow() {
        return voltagelow;
    }

    public float getVoltagehigh() {
        return voltagehigh;
    }


    public OpAmps(OpAmpsAddEditPanel panel){
        super(panel);

        this.type = ((JTextArea)panel.type.getInput()).getText();
        this.num_circuits = Integer.parseInt(((JTextArea)panel.num_circuits.getInput()).getText());
        this.voltage = Float.parseFloat(((JTextArea)panel.voltage.getInput()).getText());
        this.slewrate = Float.parseFloat(((JTextArea)panel.slewrate.getInput()).getText());
        this.gbw = Float.parseFloat(((JTextArea)panel.gbw.getInput()).getText());
        this.currentoutput = Float.parseFloat(((JTextArea)panel.currentoutput.getInput()).getText());
        this.voltagelow = Float.parseFloat(((JTextArea)panel.voltagelow.getInput()).getText());
        this.voltagehigh = Float.parseFloat(((JTextArea)panel.voltagehigh.getInput()).getText());

    }

    public OpAmps(ResultSet rs){
        super(rs);
        try {
            this.type = rs.getString("type");
            this.num_circuits = rs.getInt("num_circuits");
            this.voltage = rs.getFloat("voltage");
            this.slewrate = rs.getFloat("slewrate");
            this.gbw = rs.getFloat("gbw");
            this.currentoutput = rs.getFloat("currentoutput");
            this.voltagelow = rs.getFloat("voltagelow");
            this.voltagehigh = rs.getFloat("voltagehigh");

        }
        catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
