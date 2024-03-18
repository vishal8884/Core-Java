package concorrency.performanceOptimization.ThroughPut;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WordFinder {


    public static void main(String[] args) {

    }

    public static void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000),0);
        server.createContext("/search");
    }
}
