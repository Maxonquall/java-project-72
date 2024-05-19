package gg.jte.generated.ondemand.urls;
import hexlet.code.util.NamedRoutes;
import hexlet.code.dto.urls.UrlPage;
import java.time.format.DateTimeFormatter;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,5,7,9,9,12,12,12,18,18,18,22,22,22,26,26,26,29,29,31,31,31,32,32,32,33,33,33,34,34,34,35,35,35,36,36,36,38,38,63,63,63,63,63,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\r\n");
		var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    <div class=\"container-lg mt-3\">\r\n        <div class=\"row justify-content-center\">\r\n            <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</h1>\r\n            <table class=\"table table-bordered table-hover mt-3\">\r\n                <thead>\r\n                <tbody>\r\n                <tr>\r\n                    <td>ID</td>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getId());
				jteOutput.writeContent("</td>\r\n                </tr>\r\n                <tr>\r\n                    <td>Имя</td>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getName());
				jteOutput.writeContent("</td>\r\n                </tr>\r\n                <tr>\r\n                    <td>Дата добавления</td>\r\n                    <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getCreatedAt().toLocalDateTime().format(formatter));
				jteOutput.writeContent("</td>\r\n                </tr>\r\n                </tbody>\r\n                ");
				for (var urlCheck: page.getUrlChecks()) {
					jteOutput.writeContent("\r\n                    <tr>\r\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getId());
					jteOutput.writeContent("</td>\r\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getStatusCode());
					jteOutput.writeContent("</td>\r\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getTitle());
					jteOutput.writeContent("</td>\r\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getH1());
					jteOutput.writeContent("</td>\r\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getDescription());
					jteOutput.writeContent("</td>\r\n                        <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(urlCheck.getCreatedAt().toLocalDateTime().format(formatter));
					jteOutput.writeContent("</td>\r\n                    </tr>\r\n                ");
				}
				jteOutput.writeContent("\r\n                </thead>\r\n            </table>\r\n            <h4 class=\"display-5 mt-5\">Проверки:</h4>\r\n\r\n            <form method=\"post\">\r\n                <div class=\"justify-content-md-end mt-3\">\r\n                    <button type=\"submit\" class=\"btn btn-primary\">Запустить проверку</button>\r\n                </div>\r\n            </form>\r\n\r\n            <table class=\"table table-bordered table-hover mt-4\">\r\n                <thead>\r\n                <tr>\r\n                    <th scope=\"col\">ID</th>\r\n                    <th scope=\"col\">Код ответа</th>\r\n                    <th scope=\"col\">title</th>\r\n                    <th scope=\"col\">h1</th>\r\n                    <th scope=\"col\">description</th>\r\n                    <th scope=\"col\">Дата проверки</th>\r\n                </tr>\r\n                </thead>\r\n            </table>\r\n        </div>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
