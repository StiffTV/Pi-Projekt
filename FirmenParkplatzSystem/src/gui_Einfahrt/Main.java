package gui_Einfahrt;

import protokoll.Einfahrt;

import java.io.*;
import java.net.Socket;


public class Main {

    private Socket clientSocket;

    private DataInputStream dIN;
    private DataOutputStream dOUT;


    public Main() {
        try {
            clientSocket = new Socket("127.0.0.1", 6666);

            dIN = new DataInputStream(clientSocket.getInputStream());
            dOUT = new DataOutputStream(clientSocket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendeNeuesFahrzeug() {
        try {
            dOUT.writeUTF(String.valueOf(Einfahrt.NEUESFAHRZEUG.getIn()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}