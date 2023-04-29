import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("192.168.0.10", 8000);
                BufferedWriter writer =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));
        ) {
            System.out.println("Connected to server");

            String request = in.nextLine();
            System.out.println("Request: " + request);

            writer.write(request);
            writer.newLine();
            writer.flush();

            String response = reader.readLine();
            System.out.println("Response:" + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}