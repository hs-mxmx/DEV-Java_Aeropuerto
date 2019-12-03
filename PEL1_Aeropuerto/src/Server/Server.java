package Server;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;


public class Server{
    /* Variables */
    private Console console;
    private Socket socket;
    private ServerSocket serverSocket;
    private DataOutputStream outputStream = null;
    private ArrayList<String> suitCases = new ArrayList<>();
     
    /**
     * Method to enable and establish connection with Client
     * @param port int
     * @param jButton1 JButton 
     */
    public void logOn(int port, JButton jButton1){
        try{
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            String sessionMessage = ("Establishing connection with the client " + socket.getInetAddress().getCanonicalHostName() + "\n");
            jButton1.setText(sessionMessage);
            System.out.println(sessionMessage);
        }catch(Exception e){
            System.out.println("Couldn't establish connection..." + e.getMessage());
            System.exit(0);
        }
    }
    
    /**
     * Method to open flows from client after logging, to enable input and output data
     */
    public void openFlows(){
        try{
            outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.flush();
        }catch(IOException e){
            System.out.println("Flows could not be opened correctly...");
        }
    }
    
    /**
     * Method to send data to Client (Belt status)
     */
    public void sendBelt(){
        try{
                suitCases = console.belt.serverCases();
                outputStream.writeUTF(String.valueOf(suitCases));
                outputStream.flush();
                suitCases = null;
        }catch(IOException e){
            System.out.println("Error en durante el envio... " + e.getMessage());
        }
    }
    
    /**
     * Method to send data to Client (Airplane status)
     */
    public void sendAirplane(){
        try{
            suitCases = console.airport.getCasesServer();
            outputStream.writeUTF(String.valueOf(suitCases));
            outputStream.flush();
            suitCases = null;
        }catch(IOException e){
            System.out.println("Error while sending data... " + e.getMessage());
        }   
    }

    /**
     * Method to execute, wait and maintain Connection with Client
     * @param port int
     * @param launchClient JButton 
     */
    public void executeConnection(int port, JButton launchClient){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                logOn(port, launchClient);
                openFlows();
                try {
                    Console cons = new Console();
                    console = cons;
                    console.setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(true){
                        sendBelt();
                        sendAirplane();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        thread.start();
    }
}
