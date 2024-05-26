package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringJoiner;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.mockwebserver.MockResponse;

public class AppTest {
    Javalin app;

    @BeforeAll
    public static void beforeAllTests() throws IOException {
        MockWebServer server = new MockWebServer();
        String url = server.url("/").toString();
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/templates/index.jte"));
        String lineOfFile = reader.readLine();
        var result = new StringJoiner("\n");

        while (lineOfFile != null) {
            result.add(lineOfFile);
            lineOfFile = reader.readLine();
        }
        var mockResponse = new MockResponse().setBody(result.toString());
        server.enqueue(mockResponse);
    }

    @AfterAll
    public static void afterAllTests() throws IOException {
        MockWebServer server = new MockWebServer();
        server.shutdown();
    }

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }

    @Test
    public void testMainPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.rootPath());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("SEO");
            //  assertThat(response.body().string()).contains("Анализатор страниц");
        });
    }

    @Test
    public void testUlsPage() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlsPath());
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("ID");
        });
    }

    @Test
    public void testCreateUrl() {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "url=https://dzen.ru/pogoda/saint-petersburg";
            var response = client.post(NamedRoutes.urlsPath(), requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("dzen");
        });
    }

    @Test
    public void testUrlInfo() throws SQLException {
        var url = new Url("url=https://dzen.ru/pogoda/saint-petersburg");
        UrlRepository.save(url);
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlPath(String.valueOf(url.getId())));
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains("description");
        });
    }

    @Test
    public void testNoFoundedUrl() {
        JavalinTest.test(app, (server, client) -> {
            var response = client.get(NamedRoutes.urlPath(String.valueOf(3233423)));
            assertThat(response.code()).isEqualTo(404);
        });
    }

}
