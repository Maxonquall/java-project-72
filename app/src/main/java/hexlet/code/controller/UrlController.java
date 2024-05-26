package hexlet.code.controller;


import hexlet.code.dto.urls.UrlPage;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;



import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;


import static hexlet.code.repository.UrlRepository.urlCheck;
import static io.javalin.rendering.template.TemplateUtil.model;

public class UrlController {
    public static void index(Context ctx) throws SQLException {
      // ctx.render("urls/index.jte");
        var urls = UrlRepository.getEntities();
        var checks = UrlCheckRepository.getLastCheck();
        var page = new UrlsPage(urls, checks);
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        page.setFlashType(ctx.consumeSessionAttribute("flash-type"));
        ctx.render("urls/index.jte", model("page", page));
    }

    public static void create(Context ctx) throws SQLException {
        var userEnteredUrl = ctx.formParamAsClass("url", String.class).get().trim().toLowerCase();
        String parsedUrl;
        try {
            var url = new URI(userEnteredUrl).toURL();
            var protocol = url.getProtocol();
            var host = url.getHost();
            var port = url.getPort();
            parsedUrl = port != -1 ? protocol + "://" + host + ":" + port
                    : protocol + "://" + host;
        } catch (IllegalArgumentException | URISyntaxException | MalformedURLException e) {
            ctx.sessionAttribute("flash", "Некорректный URL");
            ctx.sessionAttribute("flash-type", "warning");
            ctx.redirect(NamedRoutes.rootPath());
            return;
        }

        if (urlCheck(parsedUrl) != null) {
            ctx.sessionAttribute("flash", "Данный URL уже существует");
            ctx.sessionAttribute("flash-type", "info");
            ctx.redirect(NamedRoutes.urlsPath());
        } else {
            var url = new Url(parsedUrl);
            UrlRepository.save(url);
            ctx.sessionAttribute("flash", "URL успешно добавлен");
            ctx.sessionAttribute("flash-type", "success");
            ctx.redirect(NamedRoutes.urlsPath());
        }
    }

    public static void show(Context ctx) throws SQLException {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var urlChecks = UrlCheckRepository.getEntitiesByUrlId(id);
        var page = new UrlPage(id, url.getName(), url.getCreatedAt(), urlChecks);
        ctx.render("urls/show.jte", model("page", page));
    }

}


