import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BasePart {
    protected int id;
    protected String name;

    protected int quantity;
    protected String description;
    protected String libraryRef;
    protected String libraryPath;
    protected String footprintRef;
    protected String footprintPath;
    protected String createdBy;
    protected Date createdDate;
    protected String updatedby;
    protected Date UpdatedDate;
    protected String link;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getLibraryRef() {
        return libraryRef;
    }

    public String getLibraryPath() {
        return libraryPath;
    }

    public String getFootprintRef() {
        return footprintRef;
    }

    public String getFootprintPath() {
        return footprintPath;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public String getLink() {
        return link;
    }



    public BasePart(BaseAddEditPanel panel)
    {
        this.name = ((JTextArea)panel.name.getInput()).getText();

        this.quantity = Integer.parseInt(((JTextArea)panel.quantity.getInput()).getText());
        this.description = ((JTextArea)panel.description.getInput()).getText();
        this.libraryRef = ((JTextArea)panel.libraryRef.getInput()).getText();

        this.libraryPath = ((JFileChooser)panel.libraryPath.getInput()).getSelectedFile().getAbsolutePath().contains("\\") ?
                ((JFileChooser)panel.libraryPath.getInput()).getSelectedFile().getAbsolutePath().split("altlib19\\\\")[1].replace("\\","/") :
                ((JFileChooser)panel.libraryPath.getInput()).getSelectedFile().getAbsolutePath().split("altlib19/")[1];

        this.footprintRef = ((JTextArea)panel.footprintRef.getInput()).getText();

        this.footprintPath = ((JFileChooser)panel.footprintPath.getInput()).getSelectedFile().getAbsolutePath().contains("\\") ?
                ((JFileChooser)panel.footprintPath.getInput()).getSelectedFile().getAbsolutePath().split("altlib19\\\\")[1].replace("\\","/") :
                ((JFileChooser)panel.footprintPath.getInput()).getSelectedFile().getAbsolutePath().split("altlib19/")[1];
        this.link = ((JTextArea)panel.link.getInput()).getText();
    }

    public BasePart(ResultSet rs)
    {   try {
            this.name = rs.getString("name");
            this.quantity = rs.getInt("quantity");
            this.description = rs.getString("Description");
            this.libraryRef = rs.getString("Library Ref");
            this.libraryPath = rs.getString("Library Path");
            this.footprintRef = rs.getString("Footprint Ref");
            this.footprintPath = rs.getString("Footprint Path");
            this.link = rs.getString("link");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
