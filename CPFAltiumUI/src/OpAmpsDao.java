import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class OpAmpsDao {
    private Connection connection;

    public OpAmpsDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(OpAmps opamps){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO opamps (`id`,`name`, `type`, `num_circuits`, `voltage`, `slewrate`, `gbw`, `currentoutput`, `voltagelow`, `voltagehigh`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, `link`,  `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, opamps.getName());
            ps.setString(2, opamps.getType());
            ps.setInt(3, opamps.getNum_circuits());
            ps.setFloat(4, opamps.getVoltage());
            ps.setFloat(5, opamps.getSlewrate());
            ps.setFloat(6, opamps.getGbw());
            ps.setFloat(7, opamps.getCurrentoutput());
            ps.setFloat(8, opamps.getVoltagelow());
            ps.setFloat(9, opamps.getVoltagehigh());
            ps.setInt(10, opamps.getQuantity());
            ps.setString(11, opamps.getDescription());
            ps.setString(12, opamps.getLibraryRef());
            ps.setString(13, opamps.getLibraryPath());
            ps.setString(14, opamps.getFootprintRef());
            ps.setString(15, opamps.getFootprintPath());
            ps.setString(16, opamps.getLink());
            ps.setString(17, DefaultData.name);
            ps.setString(18, DefaultData.name);

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
            ps = this.connection.prepareStatement("SHOW COLUMNS FROM opamps");
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
