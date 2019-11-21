import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IcMicrocontrollers extends BasePart{
    private String Vcc ;
    private String packages;

    public String getVcc() {
        return Vcc;
    }


    public String getPackages() {
        return packages;
    }



    public IcMicrocontrollers(IcMicrocontrollersAddEditPanel panel){
        super(panel);

        this.Vcc = ((JTextArea)panel.Vcc.getInput()).getText();
        this.packages = ((JTextArea)panel.packages.getInput()).getText().toString();
    }

    public IcMicrocontrollers(ResultSet rs){
        super(rs);
        try {
            this.Vcc = rs.getString("Vcc");
            this.packages = rs.getString("packages");

        }
        catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
