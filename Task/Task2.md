#  Задача 2 | Виджет пользователя – получение данных

[⬅️ назад](../README.md)

## ТЗ

Необходимо реализовать логику получения данных для отображения виджета с информацией о пользователе.

### Запрос 1

Метод 1: `OperationsApi.getOperations(userId = <ID пользователя>)`

Результат запроса должен представляться списком объектов типа `OperationInfo` и получаться из JSON `jsonProvider.operationsListJson`.

Список операций лежит в поле `operations`.

Значения валюты: special_point, rub
Значения для поля `direction`:
* `withdrawal` – уход
* `receipt` – приход

Полученные данные сохраняются в кеше. До совершения сетевого запроса проверяется наличие кеша (если список операций непустой, то сразу возвращаются данные)

### Запрос 2

Метод 2: `UsersApi.getUser(userId = <ID пользователя>)`

Результат запроса должен представляться моделью `UserInfo` и получаться из JSON `jsonProvider.userJson`

Полученные данные сохраняются в кеше. До совершения сетевого запроса нужно проверять наличие кеша (если есть данные, то они сразу возвращаются)

## Ожидаемое решение

**Операции:**
* Необходимо реализовать `OperationsLocalDataSourceImpl`, который сохраняет во внутреннюю переменную данные, переданные в метод `cacheOperations` и возвращает их при вызове `getOperations()`
* При отсутствии закешированных данных метод `OperationsLocalDataSourceImpl.getOperations()` возвращает пустой список.
* `OperationsLocalDataSourceImpl` должен реализовывать интерфейс `OperationsLocalDataSource`
* Необходимо реализовать `DefaultOperationsApi`, который получает JSON из `jsonProvider` и парсит его в список объектов типа `OperationInfo`.
* Необходимо реализовать `OperationsRemoteDataSourceImpl`, который вызывает `OperationsApi` и получает от него объект.

**Информация о пользователе:**
* Необходимо реализовать `UserInfoLocalDataSourceImpl`, который сохраняет во внутреннюю переменную данные, переданные в метод `cacheUserInfo` и возвращает их при вызове `getUserInfo()`
* При отсутствии закешированных данных метод `UserInfoLocalDataSource.getUserInfo()` возвращает `null`.
* `UserInfoLocalDataSourceImpl` должен реализовывать интерфейс `UserInfoLocalDataSource`
* Необходимо реализовать `DefaultUsersApi`, который получает JSON из `jsonProvider` и парсит его в объект типа `UserInfo`.
* Необходимо реализовать `UserInfoRemoteDataSourceImpl`, который вызывает `UsersApi` и получает от него объект.
* `UserInfoRemoteDataSourceImpl` должен реализовывать интерфейс `UserInfoRemoteDataSource`
