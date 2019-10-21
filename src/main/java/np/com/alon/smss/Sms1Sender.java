package np.com.alon.smss;
import np.com.alon.DaoImpl.ConnectionPortDaoImpl;
import np.com.alon.dao.ConnectionPortDao;
import np.com.alon.model.ConnectionPort;
import org.smslib.*;
import org.smslib.modem.SerialModemGateway;

import java.io.IOException;
import java.util.List;

public class Sms1Sender {



    public void openPort() throws SMSLibException, InterruptedException, IOException {
        ConnectionPort connectionPort = connectionPortDao.findById(1);
        System.out.println("connectionPort open");
        OutboundNotification outboundNotification = new OutboundNotification();

        SerialModemGateway gateway = new SerialModemGateway("modem.com1", connectionPort.getPortNumber(), Integer.parseInt(connectionPort.getByteLimit()), "Samsung", "J7Prime");
        gateway.setInbound(true);
        gateway.setOutbound(true);
        gateway.setSimPin("0000");
        gateway.setSmscNumber("+9779818373839");
        Service.getInstance().setOutboundMessageNotification(outboundNotification);
        Service.getInstance().addGateway(gateway);
        Service.getInstance().startService();
        System.out.println();
        System.out.println("Modem Information:");
    }

    ConnectionPortDao connectionPortDao = new ConnectionPortDaoImpl();

    public void doIt(String phoneNo, String message) throws Exception
    {

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

        System.out.println("Example: Send message from a serial gsm modem.");
        System.out.println(Library.getLibraryDescription());
        System.out.println("Version: " + Library.getLibraryVersion());


//		System.out.println("  Manufacturer: " + gateway.getManufacturer());
//		System.out.println("  Model: " + gateway.getModel());
//		System.out.println("  Serial No: " + gateway.getSerialNo());
//		System.out.println("  SIM IMSI: " + gateway.getImsi());
//		System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
//		System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
        System.out.println();

        OutboundMessage msg = new OutboundMessage(phoneNo, message);
        Service.getInstance().sendMessage(msg);
        System.out.println(msg);
        // Or, send out a WAP SI message.f
        //OutboundWapSIMessage wapMsg = new OutboundWapSIMessage("306974000000",  new URL("http://www.smslib.org/"), "Visit SMSLib now!");
        //Service.getInstance().sendMessage(wapMsg);
        //System.out.println(wapMsg);
        // You can also queue some asynchronous messages to see how the callbacks
        // are called...
        //msg = new OutboundMessage("309999999999", "Wrong number!");
        //srv.queueMessage(msg, gateway.getGatewayId());
        //msg = new OutboundMessage("308888888888", "Wrong number!");
        //srv.queueMessage(msg, gateway.getGatewayId());
        System.out.println("Now Sleeping - Hit <enter> to terminate.");
        System.in.read();
        Service.getInstance().stopService();
    }



    public void sendMultipleMessage(List<String> phoneNo, String message) throws Exception
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
        for(String s: phoneNo){
            OutboundMessage msg = new OutboundMessage(s, message);
            Service.getInstance().sendMessage(msg);
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
