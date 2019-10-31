import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class ButtonsSwitchesDao {
    private Connection connection;

    public ButtonsSwitchesDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(ButtonsSwitches buttonsSwitches){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO buttons_switches (`id`,`name`, `resistance`, `voltage`, `numcontacts`, `numrows`, `pitch`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`,  `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, buttonsSwitches.getName());
            ps.setFloat(2, buttonsSwitches.getResistance());
            ps.setFloat(3, buttonsSwitches.getVoltage());
            ps.setInt(4, buttonsSwitches.getNumContacts());
            ps.setInt(5, buttonsSwitches.getNumRows());
            ps.setFloat(6, buttonsSwitches.getPitch());
            ps.setString(7, buttonsSwitches.getPackages());
            ps.setInt(8, buttonsSwitches.getQuantity());
            ps.setString(9, buttonsSwitches.getDescription());
            ps.setString(10, buttonsSwitches.getLibraryRef());
            ps.setString(11, buttonsSwitches.getLibraryPath());
            ps.setString(12, buttonsSwitches.getFootprintRef());
            ps.setString(13, buttonsSwitches.getFootprintPath());
            ps.setString(14, buttonsSwitches.getLink());
            ps.setString(15, DefaultData.name);
            ps.setString(16, DefaultData.name);

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

    public String[] getColumns() {
        String[] rooms = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = this.connection.prepareStatement("SHOW COLUMNS FROM buttonsSwitches");
            resultSet = ps.executeQuery();
            rooms = unpackColumns(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rooms;
    }

    private String[] unpackColumns(ResultSet rs) throws SQLException{
        ArrayList<String > columns = new ArrayList<String>();
        while(rs.next()) {
            columns.add(rs.getString("Field"));
        }
        return columns.toArray(new String[columns.size()]);
    }




}
