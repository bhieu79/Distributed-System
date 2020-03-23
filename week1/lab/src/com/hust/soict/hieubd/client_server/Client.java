package com.hust.soict.hieubd.client_server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("127.0.0.1", 8989);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message=" ";
            Scanner scanner = new Scanner(System.in);
            System.out.println("Server: " + in.readLine());

            while (message != null) {
                message = scanner.nextLine();
                System.out.println("Client: " + message);
                out.println(message);
                System.out.println("Server: " + in.readLine());
            }

            socket.close();
            scanner.close();
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch(IOException i) {
            System.out.println(i);
        }
    }
}
