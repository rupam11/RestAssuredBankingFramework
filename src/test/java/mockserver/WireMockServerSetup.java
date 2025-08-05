package mockserver;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WireMockServerSetup {

    private static WireMockServer wireMockServer;

   /* public static void startMockServer() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080)); // or .dynamicPort()
        wireMockServer.start();
    }
    
 // Start WireMock server
    public static void startMockServer() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(options().port(8080));
            wireMockServer.start();
        }*/
    
    
 // Start WireMock server
    public static void startMockServer() {
        if (wireMockServer == null || !wireMockServer.isRunning()) 
        {
            wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080));
            wireMockServer.start();
        }
    }    


    // Stop WireMock server
    public static void stopMockServer() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
            wireMockServer = null;
        }
    }
}