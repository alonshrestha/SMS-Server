package np.com.alon.dao;

import np.com.alon.model.ConnectionPort;
import org.jsmpp.session.connection.Connection;

public interface ConnectionPortDao {

    boolean update(ConnectionPort connectionPort);
    boolean add(ConnectionPort connectionPort);
    ConnectionPort findById(int id);

}
