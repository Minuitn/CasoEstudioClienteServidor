/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;


// IMPORTA AQUÍ TUS DAO Y TUS CLASES DE MODELO
// Ajusta los paquetes según los nombres reales que tengan en tu proyecto:
import servidor.dao.VehiculoDAO;
import servidor.dao.MantenimientoDAO;
import servidor.dao.CombustibleDAO;
// por ejemplo, si tus clases Vehiculo, Mantenimiento, Combustible
// están en el paquete CasoEstudioFlotilla, ajusta el import:
import CasoEstudioFlotilla.Vehiculo;
import CasoEstudioFlotilla.Mantenimiento;
import CasoEstudioFlotilla.Combustible;

import java.util.List;

/**
 * ServidorFlotilla
 * ----------------
 * Este programa se ejecuta en el "lado servidor".
 * Escucha peticiones TCP y, cuando un cliente pide "REPORTE",
 * usa los DAO para leer la base de datos y envía el resultado.
 */
public class ServidorFlotilla {

    // Puerto en el que escuchará el servidor
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        System.out.println("Servidor Flotilla iniciado en el puerto " + PUERTO);

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {

            while (true) {
                // Espera a que un cliente se conecte
                Socket socketCliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + socketCliente.getInetAddress());

                // Atiende al cliente en un hilo aparte
                Thread hilo = new Thread(new ManejadorCliente(socketCliente));
                hilo.start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
     //Clase interna que maneja a CADA cliente que se conecta.
    private static class ManejadorCliente implements Runnable {

        private Socket socket;

        public ManejadorCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {

                // Leer el comando que manda el cliente
                String comando = in.readLine();
                System.out.println("Comando recibido: " + comando);

                if ("REPORTE".equalsIgnoreCase(comando)) {
                    enviarReporteDesdeBD(out);
                } else {
                    out.println("COMANDO_DESCONOCIDO");
                    out.println("FIN");
                }

            } catch (Exception e) {
                System.out.println("Error atendiendo cliente: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    
                    
                    
                }
            }
        }

        
        private void enviarReporteDesdeBD(PrintWriter out) {


    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    MantenimientoDAO mantDAO = new MantenimientoDAO();
    CombustibleDAO combDAO = new CombustibleDAO();

    try {
        
        List<Vehiculo> vehiculos = vehiculoDAO.listarVehiculos();
        List<Mantenimiento> mantenimientos = mantDAO.listarMantenimientos();
        List<Combustible> combustibles = combDAO.listarCombustible();

        out.println("=== REPORTES DESDE EL SERVIDOR (BD) ===");

        out.println("--- VEHÍCULOS ---");
        for (Vehiculo v : vehiculos) {
            out.println(v.toString());
        }

        out.println("--- MANTENIMIENTOS ---");
        for (Mantenimiento m : mantenimientos) {
            out.println(m.toString());
        }

        out.println("--- COMBUSTIBLE ---");
        for (Combustible c : combustibles) {
            out.println(c.toString());
        }

        
        out.println("FIN");

    } catch (SQLException e) {
        
        out.println("ERROR_BD");
        out.println("Mensaje: " + e.getMessage());
        out.println("FIN");
        e.printStackTrace();
    }
}

    }
}
