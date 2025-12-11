/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


 // ClienteFlotilla
 
public class ClienteFlotilla {

    private String host;
    private int puerto;

    public ClienteFlotilla() {
        // Servidor en la misma máquina (localhost)
        this.host = "localhost";
        this.puerto = 5000;
    }

    public ClienteFlotilla(String host, int puerto) {
        this.host = host;
        this.puerto = puerto;
    }

    

     
    public String solicitarReporte() throws IOException {
        try (Socket socket = new Socket(host, puerto);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))
        ) {
            // Enviamos el comando al servidor
            out.println("REPORTE");

           
            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = in.readLine()) != null) {
                if ("FIN".equals(linea)) {
                  
                    break;
                }
                sb.append(linea).append("\n");
            }

            return sb.toString();
        }
    }
}
