/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;



public class Servidor{
    private int total = 0;
    private Consola consola;
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream bufferEntrada = null;
    private DataOutputStream bufferSalida = null;
    private String inicio;
    private ArrayList<String> maletas = new ArrayList<>();
     
    /* Iniciar Sesion */
    public void iniciarSesion(int port, JButton jButton1){
        try{
            serverSocket = new ServerSocket(port);
            //System.out.println("Esperando conexion en el puerto " + String.valueOf(port));
            socket = serverSocket.accept();
            inicio = ("Conexion establecida con " + socket.getInetAddress().getCanonicalHostName() + "\n");
            jButton1.setText(inicio);
            System.out.println(inicio);
        }catch(Exception e){
            inicio = ("Error iniciando conexion..." + e.getMessage());
            System.out.println("Error iniciando conexion..." + e.getMessage());
            System.exit(0);
        }
    }
    
    /* Abrir Flujos del Servidor */
    public void abrirFlujos(){
        try{
            bufferEntrada = new DataInputStream(socket.getInputStream());
            bufferSalida = new DataOutputStream(socket.getOutputStream());
            bufferSalida.flush();
        }catch(IOException e){
            System.out.println("Error durante la apertura de los flujos...");
        }
    }
    
    /* Enviar datos de la cinta al cliente */
    public void enviarCinta(){
        try{
                maletas = consola.cinta.maletasServidor();
                bufferSalida.writeUTF(String.valueOf(maletas));
                bufferSalida.flush();
                //System.out.println("CINTA: " + maletas);  
                maletas = null;
        }catch(IOException e){
            System.out.println("Error en durante el envio... " + e.getMessage());
        }
    }
    
    /* Enviar datos del avión al cliente */
    public void enviarAvion(){
        try{
            maletas = consola.avion.getMaletasServidor();
            bufferSalida.writeUTF(String.valueOf(maletas));
            bufferSalida.flush();
            //System.out.println("AVION: " + maletas);
            maletas = null;
        }catch(IOException e){
            System.out.println("Error en durante el envio... " + e.getMessage());
        }   
    }

    /* Espera, Establece y Mantiene conexión */ 
    public void ejecutarConexion(int port, JButton jButton1){
        Thread hilo = new Thread(new Runnable(){
            @Override
            public void run(){
                iniciarSesion(port, jButton1);
                abrirFlujos();
                try {
                    Consola cons = new Consola();
                    consola = cons;
                    consola.setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                while(true){
                        enviarCinta();
                        enviarAvion();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        hilo.start();
    }
    
    /* Dar la bienvenida al cliente */
    /*
    public void clienteSesion(){
        try{
            bufferSalida.writeUTF("Bienvenido!");
            //System.out.println("[Servidor]: Bienvenido!");
            bufferSalida.flush();
            //System.out.print("[Servidor]: ");
        }catch(IOException e){
            System.out.println("Error durante la sesion del cliente... " + e.getMessage());
        }
    }
    */
    
    /* Cerrar Sesión */
    /*
    public void cerrarSesion(){
        try{
            bufferEntrada.close();
            bufferSalida.close();
            socket.close();
        }catch(IOException e){
            System.out.println("Error durante el cierre de sesion... " + e.getMessage());
        }finally{
            System.out.println("Conexion finalizada...");
        }
    }
    */
}
