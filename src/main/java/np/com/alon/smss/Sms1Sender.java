package np.com.alon.smss;
import np.com.alon.DaoImpl.ConnectionPortDaoImpl;
import np.com.alon.DaoImpl.MessageSentStatusDaoImpl;
import np.com.alon.dao.ConnectionPortDao;
import np.com.alon.dao.MessageSentStatusDao;
import np.com.alon.model.ConnectionPort;
import np.com.alon.model.MessageSentStatus;
import np.com.alon.model.Student;
import org.smslib.*;
import org.smslib.modem.SerialModemGateway;

import java.io.IOException;
import java.util.List;

public class Sms1Sender {




    ConnectionPortDao connectionPortDao = new ConnectionPortDaoImpl();
    MessageSentStatusDao messageSentStatusDao = new MessageSentStatusDaoImpl();


    public void doIt(String phoneNo, String message) throws Exception
    {


        ConnectionPort connectionPort = connectionPortDao.findById(1);

//		OutboundMessage msg;
//		OutboundNotification outboundNotification = new OutboundNotification();
//		SerialModemGateway gateway = new SerialModemGateway("", "COM3", 115200, "SAMSUNG", "A50");
//                gateway.setInbound(true);
//                gateway.setOutbound(true);
//                Service.getInstance().setOutboundMessageNotification(outboundNotification);
//                Service.getInstance().addGateway(gateway);
//                Service.getInstance().startService();
//                OutboundMessage message = new OutboundMessage("+9779862073776", "Test");
//                Service.getInstance().sendMessage(message);

        OutboundNotification outboundNotification = new OutboundNotification();
        System.out.println("Example: Send message from a serial gsm modem.");
        System.out.println(Library.getLibraryDescription());
        System.out.println("Version: " + Library.getLibraryVersion());
        SerialModemGateway gateway = new SerialModemGateway("modem.com1", connectionPort.getPortNumber(), Integer.parseInt(connectionPort.getByteLimit()), "Samsung", "J7Prime");
        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSimPin("0000");
        // Explicit SMSC address set is required for some modems.
        // Below is for VODAFONE GREECE - be sure to set your own!
        gateway.setSmscNumber("+9779818373839");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        System.out.println();
        System.out.println("Modem Information:");
        System.out.println();
        System.out.println("Now Sleeping - Hit <enter> to terminate.");
        OutboundMessage msg = new OutboundMessage(phoneNo, message);
        Service.getInstance().sendMessage(msg);
        MessageSentStatus messageSentStatus = new MessageSentStatus();
        messageSentStatus.setPhoneNumber(phoneNo);
        messageSentStatus.setMessageBody(message);
        messageSentStatusDao.add(messageSentStatus);
        System.out.println(msg);
        System.in.read();
        Service.getInstance().stopService();
    }



    public void sendMultipleMessage(List<Student> studentList, String message) throws Exception
    {
        ConnectionPort connectionPort = connectionPortDao.findById(1);

//		OutboundMessage msg;
//		OutboundNotification outboundNotification = new OutboundNotification();
//		SerialModemGateway gateway = new SerialModemGateway("", "COM3", 115200, "SAMSUNG", "A50");
//                gateway.setInbound(true);
//                gateway.setOutbound(true);
//                Service.getInstance().setOutboundMessageNotification(outboundNotification);
//                Service.getInstance().addGateway(gateway);
//                Service.getInstance().startService();
//                OutboundMessage message = new OutboundMessage("+9779862073776", "Test");
//                Service.getInstance().sendMessage(message);

        OutboundNotification outboundNotification = new OutboundNotification();
        System.out.println("Example: Send message from a serial gsm modem.");
        System.out.println(Library.getLibraryDescription());
        System.out.println("Version: " + Library.getLibraryVersion());
        SerialModemGateway gateway = new SerialModemGateway("modem.com1", connectionPort.getPortNumber(), Integer.parseInt(connectionPort.getByteLimit()), "Samsung", "J7Prime");
        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSimPin("0000");
        // Explicit SMSC address set is required for some modems.
        // Below is for VODAFONE GREECE - be sure to set your own!
        gateway.setSmscNumber("+9779818373839");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        System.out.println();
        System.out.println("Modem Information:");
        System.out.println();
        for(Student s: studentList){
            System.out.println("s.getParentName() = " + s.getParentName());
            String newmessage = "Dear "+s.getParentName()+" Ji, \n \n \n"+message;
            System.out.println("newmessage = " + newmessage);
                    OutboundMessage msg = new OutboundMessage(s.getParentPhoneNumber(), newmessage);
            Service.getInstance().sendMessage(msg);
            MessageSentStatus messageSentStatus = new MessageSentStatus();
            messageSentStatus.setPhoneNumber(s.getParentPhoneNumber());
            messageSentStatus.setMessageBody(message);
            messageSentStatusDao.add(messageSentStatus);
            System.out.println(msg);
        }
        System.out.println("Now Sleeping - Hit <enter> to terminate.");
        System.in.read();
        Service.getInstance().stopService();
    }



    public class OutboundNotification implements IOutboundMessageNotification
    {
        public void process(AGateway gateway, OutboundMessage msg)
        {
            System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
            System.out.println(msg);
        }
    }



}
