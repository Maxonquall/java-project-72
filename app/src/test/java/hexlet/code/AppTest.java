package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

public class AppTest {
    Javalin app;

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



}
