package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UrlCheck {
    private Long id;
    private Integer statusCode;
    private String title;
    private String description;
    private String h1;
    private Long urlId;
    private Timestamp createdAt;

    public UrlCheck(Integer statusCode, String title, String description, String h1, Long urlId) {
        this.statusCode = statusCode;
        this.title = title;
        this.description = description;
        this.h1 = h1;
        this.urlId = urlId;
    }


}
