package Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;


public class Client{
    /* Variables */
    private Socket socket;
    private Client_Console console;
    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;
    
    
    /**
     * Method to enable and establish connection with Server
     * @param ip String
     * @param port int
     * @param logOn JButton 
     */
    public void logOn(String ip, int port, JButton logOn){
        try{
            socket = (new Socket(ip,port));
            String sessionMessage = ("Establishing connection with the server " + ip + " on port " + port); 
            logOn.setText(sessionMessage);
        }catch(Exception e){
            String sessionMessageError = ("Couldn't establish connection with " + ip + " error: " + e.getMessage());
            logOn.setText(sessionMessageError);
            System.exit(0);
        }
    }
    
    /**
     * Method to open flows from client after logging, to enable input and output data
     */
    public void openFlows(){
        try{
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.flush();
        }catch(IOException e){
            System.out.println("Flows could not be opened correctly... " + e.getMessage());
            if(e.getMessage().contains("Socket closed")) System.exit(0);
        }
    }
    
    /**
     * Method to receive data from Server (Belt and Airplane status)
     * @throws ClassNotFoundException 
     */
    public void receiveData() throws ClassNotFoundException{
        try{
                String beltData = inputStream.readUTF();
                console.belt(beltData);
                String airportData = inputStream.readUTF();
                console.airport(airportData);
        }catch(IOException e){
            System.out.println("Error while receiving messages... " + e.getMessage());
            if(e.getMessage().contains("Socket closed")) System.exit(0);
        }
    }
    
    /**
     * Method to execute and maintain Connection with Server
     * @param ip String
     * @param port int
     * @param logOn JButton
     */
    public void executeConnection(String ip, int port, JButton logOn){
        Thread thrad = new Thread(new Runnable(){
            @Override
            public void run(){
                logOn(ip,port, logOn);
                openFlows();
                Client_Console cons =  new Client_Console();
                console = cons;
                console.setVisible(true);
                while(true){
                try {
                    receiveData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thrad.start();
    }
}

