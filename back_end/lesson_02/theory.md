Spring и все все все
====================

## HTTP Recap

**Methods**

[developer.mozilla.org: Methods](https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods)

**Headers**

[developer.mozilla.org: Headers](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers)

https://developer.mozilla.org - рекомендую.

В Firefox удобно смотреть назначение заголовка.

## Java Spring Framework

Набор библиотек и фреймворков. Глобальной целью является предоставление инструментов для удобной разработки.
Он предоставляет понятную архитектуру и набор компонентов для разработки приложений для бизнеса
(aka enterprise).

Состоит из множества проектов, но вот список основных интересных нам для разработки бэкенда

1. [The IoC Container - Inversion of Control (IoC) - Dependency injection (DI)](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/beans.html)
2. [Web MVC framework](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html) - фреймворк для веб-разработки
3. [Data Access](https://docs.spring.io/spring-framework/docs/current/reference/html/data-access.html) - доступ до данных, например до баз данных
4. [Spring Security](https://docs.spring.io/spring-security/reference/index.html) - аутентификация и авторизация. Или проще это про логин, доступ для тех кому разрешено или запрет доступа для тех кому запрещено
5. [Spring Boot](https://spring.io/projects/spring-boot) - надстройка над Spring которая упрощает жизнь

ДЗ: найдите еще компоненты, почитайте зачем они нужны

### Почитать 

- [Что такое Spring Framework? От внедрения зависимостей до Web MVC](https://habr.com/ru/articles/490586/)

## Создаем приложение

[Шаблон приложения](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.0-SNAPSHOT&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=serving-web-content&name=serving-web-content&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.serving-web-content&dependencies=web,thymeleaf,devtools)

Процесс создания приложения описан в
[Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/).
Будем идти по нему.

Проверяем, что все работает

- [Имя по умолчанию](http://localhost:8080/greeting)
- [Передаем параметр](http://localhost:8080/greeting?name=Homer)
- curl -i localhost:8080/greeting?name=xxx

## Управление зависимостями и Maven

1. Разработка с библиотеками
  - Скачивание нужных зависимостей и зависимостей зависимостей
2. Автоматизация задач в процессе разработки
  - Универсальная сборка независимая от IDE. А так же возможность собрать без IDE, применяется на серверах
  - Запуск тестов
  - Упаковка в JAR

Примеры систем: Maven, Gradle, Ant

Мы будем рассматривать Maven как один из самых популярных.

## Общий алгоритм добавления библиотеки

1. Определение задачи. Например: генерация QR-кода
2. Поиск подходящих библиотек. Google, помощь коллег
3. Сравнение их межу собой. Критерии: популярность, наличие документации и примеров, сложность использования,
   лицензия. Взять самую популярную - часто походит, но не всегда
4. Подключение библиотеки в проект
5. Подключение в конкретных классах и использование

## Как добавить зависимость в Maven

### Вариант 1. Через IDEA

[!IntelliJ IDEA: Managing Dependencies(English)](https://www.youtube.com/watch?v=nqb9yAecM9Y)

### Вариант 2. Вручную. Работает для любых IDE и даже без них

1. Ищем библитеку по названию в [central.sonatype.com](https://central.sonatype.com/)
2. Пример [страницы](https://central.sonatype.com/artifact/com.google.zxing/zxing.appspot.com/3.5.1) для ZXing
3. Копируем сниппет для Maven в pom.xml

```xml
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>zxing.appspot.com</artifactId>
    <version>3.5.1</version>
</dependency>
```

4. Собираем через IDE или командой
5. import в коде


Запуск Spring-приложения с помощью Maven

```
./mvnw spring-boot:run
```

Пакуем Sping-приложение в JAR и запускаем его

```
./mvnw clean package
java -jar target/serving-web-content-0.0.1-SNAPSHOT.jar
```
## Дополнительные материалы

### HTTP URL Parameters (Query String)

<img src="https://static.semrush.com/blog/uploads/media/5a/20/5a20dd9a3859e973f5a378a1d6f96a9f/Graphic%201.webp" width=50% height=50%>

<img src="https://static.semrush.com/blog/uploads/media/00/6e/006eebc38b54220916caecfc80fed202/Guide-to-URL-Parameters-2.webp" width=50% height=50%>



Источник: https://www.semrush.com/blog/url-parameters/ 

Пример https://www.youtube.com/watch?v=dQw4w9WgXcQ

Почитать

- [URL Parameters and How They Impact SEO](https://www.semrush.com/blog/url-parameters/)
- [developer.mozilla.org](https://developer.mozilla.org/en-US/docs/Learn/Common_questions/Web_mechanics/What_is_a_URL#parameters)

### Spring Web useful annotation + CURL

```java
@Controller
public class YourController {
};
```

```java
// curl "localhost:8080/greeting?name=Tim"
@RequestMapping(value = "/greeting", method = RequestMethod.GET)
public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    model.addAttribute("name", name);
    return "greeting"; // Return name of template
}
```

```java
// curl -X POST -d "John Smith" "http://localhost:8080/bye/specialforpost"
@RequestMapping(value = "/specialforpost", method = RequestMethod.POST)
@ResponseBody
public String get2(@RequestBody String fullName)
{
    return "I'm post controller and is't passed data " + fullName;
}
```

### Maven cheatsheet

```
./mvnw compile
```

```
./mvnw dependency:list -Dsort=true
```

```
./mvnw clean install -U
```

```
./mvnw dependency:tree
```

```
./mvnw spring-boot:run
```

```
./mvnw package
```

Build docker image

```
./mvnw spring-boot:build-image
```

