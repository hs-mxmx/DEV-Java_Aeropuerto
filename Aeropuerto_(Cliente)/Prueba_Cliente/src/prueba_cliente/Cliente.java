/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba_cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Daniel
 */
public class Cliente{
   
    private Socket socket;
    private Consola consola;
    private DataInputStream bufferEntrada = null;
    private DataOutputStream bufferSalida = null;
    Scanner teclado = new Scanner(System.in);
    private int total_maletas;
    final String terminar = "salir()";
    
    public void iniciarSesion(String ip, int port, JButton jButton4){
        try{
            socket = (new Socket(ip,port));
            String inicio = ("Estableciendo conexion con el servidor " + ip + " en el puerto " + port); 
            jButton4.setText(inicio);
        }catch(Exception e){
            String inicio =("No se pudo establecer conexion con " + ip + " error: " + e.getMessage());
            jButton4.setText(inicio);
            System.exit(0);
        }
    }
    
    public void abrirFlujos(){
        try{
        bufferEntrada = new DataInputStream(socket.getInputStream());
        bufferSalida = new DataOutputStream(socket.getOutputStream());
        bufferSalida.flush();
        }catch(IOException e){
            System.out.println("No se pudieron abrir los flujos correctamente... " + e.getMessage());
            if(e.getMessage().contains("Socket closed")) System.exit(0);
        }
    }
    
    public void enviar(String dato){
        try{
            bufferSalida.writeUTF(dato);
            bufferSalida.flush();
        }catch(IOException e){
            System.out.println("Error durante el envio del mensaje... " + e.getMessage());
            if(e.getMessage().contains("Socket closed")) System.exit(0);
        }
    }
    
    public void recibirDatos() throws ClassNotFoundException{
        try{
                String cinta = bufferEntrada.readUTF();
                //System.out.println("[CINTA]: " + cinta);
                consola.cinta(cinta);
                String avion = bufferEntrada.readUTF();
                //System.out.println("[AVION]: " + avion);
                consola.avion(avion);
        }catch(IOException e){
            System.out.println("Error durante el recibo de mensaje... " + e.getMessage());
            if(e.getMessage().contains("Socket closed")) System.exit(0);
        }
    }
    
    public void escribirDato(){
        String dato = "";
        while(true){
            System.out.print("[Cliente]: ");
            dato = teclado.nextLine();
            if(dato.length() > 0)
                enviar(dato);
        }
    }
    
    public void cerrarSesion(){
        try{
            bufferSalida.close();
            bufferEntrada.close();
            socket.close();
            System.out.println("Conexion finalizada");
            System.exit(0);
        }catch(IOException e){
            System.out.println("Error de IOException durante el cierre de sesion... " + e.getMessage());
            if(e.getMessage().contains("Socket closed")) System.exit(0);
        }
    }
    
    public void ejecutarConexion(String ip, int port, JButton jButton4){
        Thread hilo = new Thread(new Runnable(){
            @Override
            public void run(){
                iniciarSesion(ip,port, jButton4);
                abrirFlujos();
                Consola cons =  new Consola();
                consola = cons;
                consola.setVisible(true);
                while(true){
                try {
                    recibirDatos();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        hilo.start();
    }

}

