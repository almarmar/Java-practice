# Разработка простого приложения на основе архитектуры Модель-Вид-Контроллер

Хранится информация о домашнем животном: вид (кошка, собака, черепаха и т. п.), кличка, возраст – количество лет и месяцев, имя хозяина. В главном окне приложения отображается информация о животном в текстовом виде.

Реализуйте возможность увеличения возраста животного на один месяц при помощи кнопки в главном окне.

Для решения задачи используйте архитектуру Модель-Вид-Контроллер. Создайте отдельный класс для хранения данных о животном, в котором опишите метод увеличения возраста на один месяц с учетом того, что в году 12 месяцев и, например, при увеличении исходного возраста 2 года и 11 месяцев, текущее значение должно стать равно 3 года 0 месяцев. Для отображения данных создайте отдельный класс, в котором опишите несколько визуальных элементов для отображения данных. Свяжите этот класс-вид с объектом-моделью. В главном классе приложения создайте соответствующие объекты и организуйте взаимодействие с пользователем для увеличения возраста животного.
