package de.claudioaltamura.java.rsclient.mockwebserver;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {

  private Logger logger = LoggerFactory.getLogger(Service.class);

  private String host = "example.com";
  
  private int port = 80;
 
  public int doThings() {
    WebTarget webTarget = ClientBuilder.newClient().target("http://" + host + ":" + port);
    Response response = webTarget.request(MediaType.TEXT_PLAIN).get();
    logger.info("request {}", host);
    return response.getStatus();
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
  
}
