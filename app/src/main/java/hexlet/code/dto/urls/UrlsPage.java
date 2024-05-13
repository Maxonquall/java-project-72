package hexlet.code.dto.urls;

import hexlet.code.dto.BasePage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import hexlet.code.model.Url;

import java.util.List;


@Getter
public class UrlsPage extends BasePage {
    private List<Url> urls;

    public UrlsPage(List<Url> urls) {
        this.urls = urls;
    }

}