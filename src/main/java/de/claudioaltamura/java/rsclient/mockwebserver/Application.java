package de.claudioaltamura.java.rsclient.mockwebserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

  private static Logger logger = LoggerFactory.getLogger(Application.class);
  
  public static void main(String[] args) {
    Service service = new Service();
    int result = service.doThings();
    logger.info("result is {}" , result);
  }

}
