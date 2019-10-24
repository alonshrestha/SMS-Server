package np.com.alon.DaoImpl;

import np.com.alon.dao.MessageSentStatusDao;
import np.com.alon.dbconnection.DBConnection;
import np.com.alon.model.MessageSentStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageSentStatusDaoImpl implements MessageSentStatusDao {
    DBConnection dbConnection = new DBConnection();
    public boolean add(MessageSentStatus messageSentStatus) {

        try {
            dbConnection.open();
            String query = "insert into message_sent_status (phone_number,message_body) values(?,?)";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            preparedStatement.setString(1,messageSentStatus.getPhoneNumber());
            preparedStatement.setString(2,messageSentStatus.getMessageBody());

            int i = preparedStatement.executeUpdate();
            if(i > 0) return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int count() {

        try {
            dbConnection.open();
            String query = "select count(*) from message_sent_status";
            PreparedStatement preparedStatement = dbConnection.getPreparedStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()){
                count = resultSet.getInt("count(*)");
            }
            return count;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
