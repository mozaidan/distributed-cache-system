import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        System.out.println("🚀 Server running on port 5000");

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            Cache cache = new Cache(); // New cache instance

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String input = in.readLine();
                    if (input == null) {
                        System.out.println("Client closed the connection.");
                        continue; // Go back to waiting for next client
                    }

                    System.out.println("📩 Received: " + input);

                    String response;
                    if (cache.contains(input)) {
                        response = "From cache 🧠: " + cache.get(input);
                    } else {
                        response = "New data 🔄: " + input.toUpperCase();
                        cache.put(input, response);
                    }

                    out.println("Server response: " + response);

                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }
}
