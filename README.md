# PROD | 2 этап | Mobile (Android)

## 🚀 Введение

### Контекст разработки


Вы пришли в команду, которая работает над запуском нового сервиса СуперВыгода, с помощью которого можно экономить на покупках. Основа сервиса – спецпредложения (кэшбэк с покупок или бонусы программы лоаяльности) у партнеров.

Команда новая и над проектом до вас работал спецаилист, который по непредвиденным обстоятельсвам покинул компанию. Теперь вы на страже запуска проекта 🦸‍♂️ Вам предстоит доделать недостоющий функционал и исправить имеющийся.

Первая версия приложения состоит из:

1. Главный экран – тот что встречает при старте приложения. Он состоит из:
    1. Рекламного баннера
    2. Компонента "Полная информация о пользователе", где отображаются его имя и текущий баланс бонусного счета
    3. Компонента "Избранное", где отображается счетчик понравившехся предложений
    4. Список рекомендуемых спецпредложений. Здесь показывается краткая информация о доступных бонусных программах, которые можно лайкнуть и сохранить в избранное
2. Экран деталей спецпредложений. Данный экран открывается при нажатии на элемент списка на главном экране и отображает детальные данные о выбранном спецпредложении.

### Устройство проекта

Проект представляет из себя многомодульное приложение. Предыдущий разработчик оставил свой код в библиотеке `core`. Ваша задача – используя данный модуль,реализовать недостающие сущности в своём модуле `solution`.

## 📚 Задачи

* [Задача 1 ➡️](Task/Task1.md)
* [Задача 2 ➡️](Task/Task2.md)
* [Задача 3 ➡️](Task/Task3.md)
* [Задача 4 ➡️](Task/Task4.md)
* [Задача 5 ➡️](Task/Task5.md)
* [Задача 6 ➡️](Task/Task6.md)
* [Задача 7 ➡️](Task/Task7.md)
* [Задача 8 ➡️](Task/Task8.md)
* [Задача 9 ➡️](Task/Task9.md)
* [Задача 10 ➡️](Task/Task10.md)

## 📝 Оформление

Решение задания – реализация отдельного класса. Поэтому ваше решение ожидается в методах классов, перечисленных в условиях задачи и размещённых в модуле Solution. 

Требования к оформлению отдельных задач указаны в их описании.

### Работа с изображениями

Для перевода id картинки в id ресурса, используйте метод `imageIdToResId()`.

## ❗️ Ограничения

* Язык – Kotlin
* Пользовательский интерфейс – View и XML, без использования Jetpack Compose
* [Рекомендуется] Android studio Hedgehog 2023.1.1 Patch 2
* Все изменения – только в `solution`-модуле. Модуль `app` следует оставить без изменений.

## 🔄 Проверка UI

Реализованные элементы интерфейса сравниваются тестирующей системой с помощью сравнения с эталонным скриншотом.

Версия Android на тестирующей системе – 14.0 (SDK 34).
