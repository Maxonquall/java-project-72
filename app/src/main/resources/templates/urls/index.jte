@import hexlet.code.dto.urls.UrlsPage
@import hexlet.code.util.NamedRoutes
@param UrlsPage page


@template.layout.page(
page = page,
content = @`

    <section>
        <div class="container-lg mt-5">
            <h1>Сайты</h1>
    @if (page.getUrls().isEmpty())
        <p> sffdsf </p>
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
                            <a>${url.getName()}</a>
                        </td>
                        <td>

                        </td>
                        <td>

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
