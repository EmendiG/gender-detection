import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import mat.handler.GenderHandler;
import mat.handler.TokensHandler;

import java.net.InetSocketAddress;

public class Main {

    private static final String HOSTNAME = "localhost";
    private static final int PORT = 8000;
    private static final int BACKLOG = 10;

    public static void main(String[] args) throws Exception {

        HttpHandler genderHandler = new GenderHandler();
        HttpHandler tokensHandler = new TokensHandler();

        HttpServer server = HttpServer.create(new InetSocketAddress(HOSTNAME, PORT), BACKLOG);
        server.createContext("/gender", genderHandler);
        server.createContext("/tokens", tokensHandler);
        server.setExecutor(null);
        server.start();
    }
}
