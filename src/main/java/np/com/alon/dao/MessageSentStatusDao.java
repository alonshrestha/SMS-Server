package np.com.alon.dao;

import np.com.alon.model.MessageSentStatus;

public interface MessageSentStatusDao {

    boolean add(MessageSentStatus messageSentStatus);
    int count();
}
