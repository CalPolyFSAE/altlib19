import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class DiodeDao {
    private Connection connection;

    public DiodeDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Diode diode){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO `cpf_altium`.`diodes` (`id`, `name`, `vr`, `numcircuits`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW())");
            ps.setString(1, diode.getName());
            ps.setFloat(2, diode.getVoltage());
            ps.setInt(3, diode.getNumcircuits());
            ps.setString(4, diode.getPackageString());
            ps.setInt(5, diode.getQuantity());
            ps.setString(6, diode.getDescription());
            ps.setString(7, diode.getLibraryRef());
            ps.setString(8, diode.getLibraryPath());
            ps.setString(9, diode.getFootprintRef());
            ps.setString(10, diode.getFootprintPath());
            ps.setString(11, DefaultData.name);
            ps.setString(12, DefaultData.name);

            ret = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
