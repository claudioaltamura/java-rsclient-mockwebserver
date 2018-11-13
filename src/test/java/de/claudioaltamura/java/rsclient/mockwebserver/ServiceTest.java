package de.claudioaltamura.java.rsclient.mockwebserver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

class ServiceTest {

  private Service service;
  
  @Rule
  public MockWebServer mockWebServer = new MockWebServer();
  
  @BeforeEach
  public void setUp() throws IOException {
    HttpUrl mockWebServerUrl = mockWebServer.url("/helloworld/");
    service = new Service();
    service.setHost(mockWebServerUrl.host());
    service.setPort(mockWebServerUrl.port());
  }

  @Test
  public void test() throws InterruptedException {
    mockWebServer.enqueue(
        new MockResponse().setBody("{\"text\":\"hello world!\"}")
    );
    //given
    int result = service.doThings();

    //then
    final RecordedRequest request = mockWebServer.takeRequest(10, TimeUnit.SECONDS);

    String body = request.getBody().toString();
    assertNotNull(request);
    assertEquals(200, result);
    assertEquals(request.getRequestLine(), "GET /1.1");
  }

}
