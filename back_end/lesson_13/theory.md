Тестирование в Spring Boot
==========================

## Простые модульные тесты

Добавляем в pom проекта артефакт

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

Тестовые классы размещаем в папке /src/test/java

Для простых тестов достаточно пометить тестовые методы аннотацией @Test

## Интеграционные тесты в Spring Boot

Для тестов, требующих инициализацию контекста приложения Spring Boot, необходимо пометить тестовые классы аннотацией @SpringBootTest

При тестировании операций с базой данных используется [база данных h2](https://coderlessons.com/tutorials/bazy-dannykh/izuchite-bazu-dannykh-h2/baza-dannykh-h2-kratkoe-rukovodstvo)