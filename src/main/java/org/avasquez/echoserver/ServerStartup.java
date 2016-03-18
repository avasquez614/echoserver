package org.avasquez.echoserver;

import org.eclipse.jetty.server.Server;

/**
 * Main class that starts up an embedded Jetty server.
 *
 * @author avasquez
 */
public class ServerStartup {

    public static final int DEFAULT_PORT = 7070;

    public static void main(String... args) throws Exception {
        int port = DEFAULT_PORT;

        if (args.length >= 1) {
            port = Integer.parseInt(args[0]);
        }

        Server server = new Server(port);
        server.setHandler(new EchoHandler());

        server.start();
        server.join();
    }

}
