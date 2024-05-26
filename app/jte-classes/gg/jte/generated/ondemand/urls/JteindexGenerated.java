package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.util.NamedRoutes;
import java.time.format.DateTimeFormatter;
public final class JteindexGenerated {
	public static final String JTE_NAME = "urls/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,5,5,5,7,9,9,10,10,12,12,12,15,15,20,20,31,31,42,42,44,44,44,46,46,46,46,46,46,46,46,46,46,46,46,49,49,49,52,52,52,55,55,59,59,61,61,61,62,62,62,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlsPage page) {
		jteOutput.writeContent("\r\n");
		var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
		jteOutput.writeContent("\r\n\r\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n    ");
				if (page != null && page.getFlash() != null) {
					jteOutput.writeContent("\r\n    <div class=\"rounded-0 m-0 alert alert-dismissible fade show alert-info\" role=\"alert\">\r\n        ");
					jteOutput.setContext("div", null);
					jteOutput.writeUserContent(page.getFlash());
					jteOutput.writeContent("\r\n        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n    </div>\r\n    ");
				}
				jteOutput.writeContent("\r\n\r\n    <section>\r\n        <div class=\"container-lg mt-5\">\r\n            <h1>Сайты</h1>\r\n    ");
				if (page.getUrls().isEmpty()) {
					jteOutput.writeContent("\r\n                <table class=\"table table-bordered table-hover mt-3\">\r\n                    <thead>\r\n                    <tr>\r\n                        <th class=\"col-1\">ID</th>\r\n                        <th>Имя</th>\r\n                        <th class=\"col-2\">Последняя проверка</th>\r\n                        <th class=\"col-1\">Код ответа</th>\r\n                    </tr>\r\n                    </thead>\r\n                </table>\r\n    ");
				} else {
					jteOutput.writeContent("\r\n            <table class=\"table table-bordered table-hover mt-3\">\r\n                <thead>\r\n                <tr>\r\n                    <th class=\"col-1\">ID</th>\r\n                    <th>Имя</th>\r\n                    <th class=\"col-2\">Последняя проверка</th>\r\n                    <th class=\"col-1\">Код ответа</th>\r\n                </tr>\r\n                </thead>\r\n                <tbody>\r\n                ");
					for (var url: page.getUrls()) {
						jteOutput.writeContent("\r\n                    <tr>\r\n                        <th scope=\"row\">");
						jteOutput.setContext("th", null);
						jteOutput.writeUserContent(url.getId());
						jteOutput.writeContent("</th>\r\n                        <td>\r\n                            <a");
						var __jte_html_attribute_0 = NamedRoutes.urlPath(url.getId().toString());
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(__jte_html_attribute_0);
							jteOutput.setContext("a", null);
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(">");
						jteOutput.setContext("a", null);
						jteOutput.writeUserContent(url.getName());
						jteOutput.writeContent("</a>\r\n                        </td>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(page.getChecks().get(url.getId()) == null ? " " : page.getChecks().get(url.getId()).getCreatedAt().toLocalDateTime().format(formatter));
						jteOutput.writeContent("\r\n                        </td>\r\n                        <td>\r\n                            ");
						jteOutput.setContext("td", null);
						jteOutput.writeUserContent(page.getChecks().get(url.getId()) == null ? " " : page.getChecks().get(url.getId()).getStatusCode().toString());
						jteOutput.writeContent("\r\n                        </td>\r\n                    </tr>\r\n                ");
					}
					jteOutput.writeContent("\r\n                </tbody>\r\n            </table>\r\n        </div>\r\n        ");
				}
				jteOutput.writeContent("\r\n    </section>\r\n");
			}
		});
		jteOutput.writeContent("\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlsPage page = (UrlsPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
