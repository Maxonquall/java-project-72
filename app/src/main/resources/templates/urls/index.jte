@import hexlet.code.dto.urls.UrlsPage
@import hexlet.code.util.NamedRoutes
@import java.time.format.DateTimeFormatter
@param UrlsPage page

!{var formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");}

@template.layout.page(
content = @`
    @if(page != null && page.getFlash() != null)
    <div class="rounded-0 m-0 alert alert-dismissible fade show alert-info" role="alert">
        ${page.getFlash()}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    @endif

    <section>
        <div class="container-lg mt-5">
            <h1>Сайты</h1>
    @if (page.getUrls().isEmpty())
                <table class="table table-bordered table-hover mt-3">
                    <thead>
                    <tr>
                        <th class="col-1">ID</th>
                        <th>Имя</th>
                        <th class="col-2">Последняя проверка</th>
                        <th class="col-1">Код ответа</th>
                    </tr>
                    </thead>
                </table>
    @else
            <table class="table table-bordered table-hover mt-3">
                <thead>
                <tr>
                    <th class="col-1">ID</th>
                    <th>Имя</th>
                    <th class="col-2">Последняя проверка</th>
                    <th class="col-1">Код ответа</th>
                </tr>
                </thead>
                <tbody>
                @for(var url: page.getUrls())
                    <tr>
                        <th scope="row">${url.getId()}</th>
                        <td>
                            <a href="${NamedRoutes.urlPath(url.getId().toString())}">${url.getName()}</a>
                        </td>
                        <td>
                            ${page.getChecks().get(url.getId()) == null ? " " : page.getChecks().get(url.getId()).getCreatedAt().toLocalDateTime().format(formatter)}
                        </td>
                        <td>
                            ${page.getChecks().get(url.getId()) == null ? " " : page.getChecks().get(url.getId()).getStatusCode().toString()}
                        </td>
                    </tr>
                @endfor
                </tbody>
            </table>
        </div>
        @endif
    </section>
`
)
