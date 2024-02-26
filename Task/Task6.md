#  Задача 6 | Список спецпредложений – логика избранного

[⬅️ назад](../README.md)

## ТЗ

Необходимо реализовать логику добавления/удаления и хранения элементов избранного.

Запросы на добавление и удаление из избранного проходят через объект класса `FavoritesRepositoryImpl`, содержащий следующие методы в соответствии с интерфейсом `FavoritesRepository`:
* `getFavoriteOffers(): List<OfferInfo>` – возвращает список спецпредложений, отмеченных как избранное
* `markOfferAsFavourite(offerId: String)` – добавляет спецпредложение с идентификатором `offerId` в избранное
* `checkOfferIsFavorite(offerId: String): Boolean` – `true`, если спецпредложение с идентификатором `offerId` добавлен в избранное, иначе `false`
* `removeOfferFromFavourites(offerId: String)` – удаляет спецпредложение с идентификатором `offerId` из избранного
Спецпредложения по `offerId` можно получить с помощью `OffersRemoteDataSource`.
Избранное реализуется посредством добавления и удаления элементов с помощью `FavoritesLocalDataSourceImpl`.

## Ожидаемое решение

* Необходимо реализовать `FavoritesLocalDataSourceImpl`, который управляет работой избранного.
* Необходимо реализовать `FavoritesRepositoryImpl`, который читает, добавляет и удаляет элементы в `FavoritesLocalDataSourceImpl`, а также получает спецпредложения из `OffersRemoteDataSource`. 
* `FavoritesLocalDataSourceImpl` должен реализовывать интерфейс `FavoritesLocalDataSource`.
* FavoritesRepositoryImpl` должен реализовывать интерфейс `FavoritesRepository`.
