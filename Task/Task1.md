#  Задача 1 | Рекламный баннер – получение данных

[⬅️ назад](../README.md)

## ТЗ

Необходимо реализовать логику получения данных для отображения рекламного баннера.

### Запрос

Метод: `BannersApi.getBanner()`

Результат запроса должен представляться моделью `BannerItem`, создаваемой в `DefaultBannersApi` из JSON, получаемого из `jsonProvider.bannerInfoJson`

## Ожидаемое решение

* Необходимо реализовать `BannerRemoteDataSourceImpl`, который производит запрос на получение данных из сети (`DefaultBannersApi`)
* Необходимо реализовать `DefaultBannersApi`, который получает JSON `jsonProvider.bannerInfoJson` и преобразует его в объект типа `BannerItem`.
* `DefaultBannersApi` должен реализовывать интерфейс `BannersApi`.
* `BannerRemoteDataSourceImpl` должен реализовывать интерфейс `BannerRemoteDataSource`