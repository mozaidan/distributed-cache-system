package server;
public class Server {
    public static void main(String[] args) {
        System.out.println("🚀 Server er i gang!");

        // loop to handle
        while (true) {
            try {
                Thread.sleep(5000); // Waiting 5 seconds
                System.out.println("📦 Server jobber med forespørsler...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
