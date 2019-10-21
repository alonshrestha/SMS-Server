package np.com.alon.DaoImpl;

import np.com.alon.dao.ConnectionPortDao;
import np.com.alon.dbconnection.DBConnection;
import np.com.alon.model.ConnectionPort;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionPortDaoImpl implements ConnectionPortDao {
    DBConnection dbConnection = new DBConnection();
    public boolean update(ConnectionPort connectionPort) {
        try {
            dbConnection.open();
            String query = "update connection_port set port_number = ? , port_limit = ? where id = ?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,connectionPort.getPortNumber());
            preparedStatement.setString(2,connectionPort.getByteLimit());
            preparedStatement.setInt(3,connectionPort.getId());
            int i = preparedStatement.executeUpdate();
            if(i> 0) return  true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean add(ConnectionPort connectionPort) {

        try {
            dbConnection.open();
            String query = "insert into connection_port (port_number, port_limit) values (?,?) ";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,connectionPort.getPortNumber());
            preparedStatement.setString(2,connectionPort.getByteLimit());
            int i = preparedStatement.executeUpdate();
            if(i> 0) return  true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ConnectionPort findById(int id) {
        try {
            dbConnection.open();
            String query = "select * from connection_port where id = ?";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ConnectionPort connectionPort = new ConnectionPort();
            while (resultSet.next()){
                connectionPort.setId(resultSet.getInt("id"));
                connectionPort.setPortNumber(resultSet.getString("port_number"));
                connectionPort.setByteLimit(resultSet.getString("port_limit"));
            }
            return connectionPort;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
