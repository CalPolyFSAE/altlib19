import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class CapacitorDao {
    private Connection connection;

    public CapacitorDao(Connection connection){
        this.connection = connection;
    }



    public Set<Bjt> getAll(){
        return null;
    }

    public int insert(Capacitor capacitor){;
        int ret = -1;
        PreparedStatement ps = null;
        try {
            ps = this.connection.prepareStatement(
                    "INSERT INTO capacitors (`id`,`name`, `capacitance`, `voltage`, `dielectric`, `percent tolerance`, `ESR`, `package`, `quantity`, `Description`, `Library Ref`, `Library Path`, `Footprint Ref`, `Footprint Path`, link, `createdby`, `createddate`, `updatedby`, `updateddate`)"+
                            " VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), ?, NOW());");
            ps.setString(1, capacitor.getName());
            ps.setString(2, capacitor.getCapacitance());
            ps.setFloat(3, capacitor.getVoltage());
            ps.setString(4, capacitor.getDielectric());
            ps.setFloat(5, capacitor.getPercentTolerance());
            ps.setString(6, capacitor.getEsr());
            ps.setString(7, capacitor.getPackageString());
            ps.setInt(8, capacitor.getQuantity());
            ps.setString(9, capacitor.getDescription());
            ps.setString(10, capacitor.getLibraryRef());
            ps.setString(11, capacitor.getLibraryPath());
            ps.setString(12, capacitor.getFootprintRef());
            ps.setString(13, capacitor.getFootprintPath());
            ps.setString(14, capacitor.getLink());
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
            ps = this.connection.prepareStatement("SHOW COLUMNS FROM capacitors");
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

    /*public Capacitor[] getCapacitors() {
        String[][] capacitors = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            ps = this.connection.prepareStatement("Select * FROM capacitors");
            resultSet = ps.executeQuery();
            //capacitors = unpackColumns(resultSet);
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
        //return capacitors;
    }*/

    private Capacitor[] unpackCapacitors(ResultSet rs) throws SQLException{
        ArrayList<Capacitor> capacitors = new ArrayList<Capacitor>();
        while(rs.next()) {
            Capacitor capacitor = new Capacitor(rs){};
        }
        return capacitors.toArray(new Capacitor[capacitors.size()]);
    }

}
