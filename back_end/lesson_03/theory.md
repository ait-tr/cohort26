# Software design pattern

Wiki:

>In software engineering, a software design pattern is a general, reusable solution to a commonly occurring problem within a given context in software design. It is not a finished design that can be transformed directly into source or machine code. Rather, it is a description or template for how to solve a problem that can be used in many different situations. Design patterns are formalized best practices that the programmer can use to solve common problems when designing an application or system.

>Шаблон проектирования (паттерн, от англ. design pattern) — повторяемая архитектурная конструкция в сфере проектирования программного обеспечения, предлагающая решение проблемы проектирования в рамках некоторого часто возникающего контекста. Обычно шаблон не является законченным образцом, который может быть прямо преобразован в код; это лишь пример решения задачи, который можно использовать в различных ситуациях. Объектно-ориентированные шаблоны показывают отношения и взаимодействия между классами или объектами, без определения того, какие конечные классы или объекты приложения будут использоваться.

Стандартный подход к решению проблемы.

Самые известные паттерны:

- Factory
- Observer
- Model-View-Contoller
- Singleton

# Model-View-Contoller

- Разделение ответвенности на три компонента(Model-View-Contoller)
- Понимание какой код писать в зависимости от задачи

- Model - отвечает за данные, например хранит их. Никак не связана с UI
- View - отвечает только за отображение
- Controller - взязующее звено между Model и View.

MVC в каждом фреймворке несколько свой, но освоившись с одним понять другие будет проще.


## Почитать про MVC

https://www.freecodecamp.org/news/the-model-view-controller-pattern-mvc-architecture-and-frameworks-explained/
https://www.codejava.net/images/articles/frameworks/spring/Understanding%20Spring%20MVC/SpringMVCArchitecture.jpg

Статья [Составные шаблоны. MVC](https://docs.google.com/document/d/17y80dbR88Pi-JIi10HZgEKrtes_5dN2jPfDlagR2MKA/)

# Model-View-Contoller in Spring

Spring MVC это реализация MVC паттерна. Spring MVC предназначен для разрабтки web-приложений с использованием MVC паттерна.

Плюсы использование паттерна MVC:

- Разделение ответственности -> каждый компонент проще устроен -> проще разрабатывать
- Структурированность позволяет любому человеку понимать где лежит код т.к. его место стандартизованно

Мы говорим о приложениях где возвращается html.

- Controller
    - Принимает реквест и получает данные запроса
    - Заполняет Model
    - Указывает как View отобразить
- Model
    - Служит для переноса данных между Contoller и View
- View занимается только отображением. В данном случае это HTML.

Процесс обработки запроса:

1. Controller получает запрос. Вызывается соответствующий метод
2. Controller работает с Model для получения/записи данных
3. Controller говорит какой View отдать
4. View отображает данные

![](https://www.codejava.net/images/articles/frameworks/spring/Understanding%20Spring%20MVC/SpringMVCArchitecture.jpg)

![](https://terasolunaorg.github.io/guideline/1.0.1.RELEASE/en/_images/RequestLifecycle.png)

## Controller and @Controller и @RequestMapping

Аннотация @Controller используется чтобы пометить класс, что он используется как контроллер, а это значит
что такой класс будет обрабатывать HTTP-запросы.

@RequestMapping используется чтобы пометить конкретный метод на какие запросы он будет отвечать.

```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello, world!");
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

}
```

**@RequestMapping** примеры:

```
@RequestMapping(value = "/greeting", method = RequestMethod.GET)

@GetMapping(value = "/image2", produces = MediaType.IMAGE_PNG_VALUE)
```


[@RequestMapping](https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/spring-request-mapping.html)

# Thymeleaf

- [Introduction to Using Thymeleaf in Spring](https://www.baeldung.com/thymeleaf-in-spring-mvc)
- [Методичка по Thymeleaf](https://docs.google.com/document/d/1Alet4zSJQwn4vi7nfFUlQkVw83Zuz-di6qJYeq8_rzg/)

