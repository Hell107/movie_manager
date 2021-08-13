Елена Парахня
===========

В данной программе реализован REST сервис для поиска фильмов по фамилии режиссера и рамках даты выхода.

Версия Java - 1.8

База данных - `Postgresql`

Использоваие `javax.servlet.jstl` версии 1.2

Развертывание - `tomcat7-maven-plugin` версии 2.2

Для удобства реализации предоставленных задач был использован фреймворк `Spring` и библиотеки `Hibernate`


Директория `resources` содержит `.sql` файлы для создания и заполнения базы данных `movies` там можно изменять 
наполнение таблиц

Сборка - `mvn compile`

Развертывание - `mvn install tomcat7:redeploy -Pdev`

Класс для запуска приложения - `Application`

Unit тесты находятся в 

`D:\Hell107\prog\java\movie_manager\src\test\java\com\test\godel\movie_manager\domain\dao\DefaultMovieManagerFilmDaoTest.java` 

После запуска проверка через ввод в бразере `url` для разных случаев:

`directorLastName` - поиск по фамилии режиссера

`releaseFromDate` - поиск производится от введенной даты

`releaseUntilDate` - до введенной даты


Комбинируя вводимые параметры формируем запросы:

Поиск по фамилии режиссера, от и после даты `http://localhost:8081/film?releaseUntilDate=12121995&directorLastName=Cameron`

Поиск по фамилии режиссера `http://localhost:8081/film?directorLastName=Cameron`

Поиск от даты `http://localhost:8081/film?releaseFromDate=12121995`

и тд.
