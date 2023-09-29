Запуск Spring Boot в VPS Google Cloud
=====================================

## Введение

VPS (англ. virtual private server) или VDS (англ. virtual dedicated server), виртуальный выделенный сервер — вид сервера, root-доступ к которому его клиент получает посредством удалённого интернет соединения. В плане управления операционной системой по большей части соответствует физическому выделенному серверу. В частности: root-доступ, собственные IP-адреса, порты, правила фильтрования и таблицы маршрутизации.

Статья: [Обзор популярных VPS серверов](https://habr.com/ru/articles/686238/)

Как получить?

Статья: [Как получить бесплатный VPS (VDS) сервер навсегда](https://seopulses.ru/kak-poluchit-besplatniy-vps-vds-server-navsegda/)

Результат: регистрация учётной записи в Google Cloud (или Oracle, или Amazon)

## Создание VM

Создаём новый виртуальный сервер в [Google Cloud](https://cloud.google.com):
Navigation menu -> Compute Engine -> VM instances  -> CREATE INSTANCE

Параметры:
- Series: E2
- Machine type: e2-micro
- Boot disk:
  - operating system: CentOS
  - version: CentOS 7
- Firewall:
  x Allow HTTP traffic
  x Allow HTTPS traffic

## Развертывание HelloCRUD

Устанавливаем JDK11 командой:

```
sudo yum install java-11-openjdk-devel

```

Копируем приложение, собранное в виде jar hello-crud-0.0.1-SNAPSHOT и запускаем его командой:

```
java -jar hello-crud-0.0.1-SNAPSHOT
```

Открываем tcp порт 8080 добавляя правило в Set up firewall rules и после этого обращаемся к нашему запущенному приложению:

```
http://<ip адрес нашей VM>:8080
```