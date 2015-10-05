package edu.upc.eetac.dsa.beeter;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.util.ResourceBundle;

/**
 * Created by kenshin on 5/10/15.
 */
public class BeeterResourceConfig extends ResourceConfig {

    public BeeterResourceConfig() {
        /**configuración del paquete donde la aplicación debe buscar las clases recurso:*/
        packages("edu.upc.eetac.dsa.beeter");
    }

    public static HttpServer startServer() {
        /***para que ahora la aplicación se configure a través de la clase BeeterResourceConfig*/
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.eetac.dsa.beeter package
        final ResourceConfig rc = new BeeterResourceConfig();

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(Main.getBaseURI()), rc);
    }
}
