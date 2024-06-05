package hexlet.code.controller;

import com.mashape.unirest.http.Unirest;
import hexlet.code.model.UrlCheck;
import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;
import hexlet.code.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import org.jsoup.Jsoup;

import java.sql.SQLException;

public class UrlCheckController {

    public static void check(Context ctx) throws SQLException {
        var urlId = ctx.pathParamAsClass("id", Long.class).get();
        var url = UrlRepository.find(urlId).orElseThrow(NotFoundResponse::new);

        try {
            var response = Unirest.get(url.getName()).asString();
            var statusCode = response.getStatus();
            var document = Jsoup.parse(response.getBody());
            var title = document.title();
            var h1 = document.selectFirst("h1") == null ? " " : document.selectFirst("h1").text();
            var descriptionElement = document.selectFirst("meta[name=description]");
            var description = descriptionElement == null ? " " : descriptionElement.attr("content");


            var urlCheck = new UrlCheck(statusCode, title, description, h1, urlId);
            UrlCheckRepository.save(urlCheck);

            ctx.sessionAttribute("flash", "URL проверен");
            ctx.sessionAttribute("flash-type", "success");
        } catch (Exception e) {
            ctx.sessionAttribute("flash", "Некорректный URL или проверка не удалась");
            ctx.sessionAttribute("flash-type", "warning");
            //ctx.redirect(NamedRoutes.urlsPath());
        }
        ctx.redirect(NamedRoutes.urlPath(String.valueOf(urlId)));
    }
}


