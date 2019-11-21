import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class IcMicrocontrollersDao {
    private Connection connection;

    public IcMicrocontrollersDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(IcMicrocontrollers icmicrocontrollers){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO icmicrocontrollers (`id`,`name`, `Vcc`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`,  `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, icmicrocontrollers.getName());
            ps.setString(2, icmicrocontrollers.getVcc());
            ps.setString(3, icmicrocontrollers.getPackages());
            ps.setInt(4, icmicrocontrollers.getQuantity());
            ps.setString(5, icmicrocontrollers.getDescription());
            ps.setString(6, icmicrocontrollers.getLibraryRef());
            ps.setString(7, icmicrocontrollers.getLibraryPath());
            ps.setString(8, icmicrocontrollers.getFootprintRef());
            ps.setString(9, icmicrocontrollers.getFootprintPath());
            ps.setString(10, icmicrocontrollers.getLink());
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

    public String[] getColumns() {
        String[] rooms = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = this.connection.prepareStatement("SHOW COLUMNS FROM icmicrocontrollers");
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
