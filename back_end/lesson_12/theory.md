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

Копируем приложение, собранное в виде jar: hello-crud-0.0.1-SNAPSHOT.jar и запускаем его командой:

```
java -jar hello-crud-0.0.1-SNAPSHOT
```

Открываем tcp порт 8080 добавляя правило в Set up firewall rules и после этого обращаемся к нашему запущенному приложению:

```
http://<ip адрес нашей VM>:8080
```

## Установка postgresql-server

Для установки и настройки postgresql-server используем статью [How to Install PostgreSQL on CentOS 7](https://www.hostinger.com/tutorials/how-to-install-postgresql-on-centos-7/), вторую часть (How to Install PostgreSQL on CentOS 7 Using the CentOS Repositories)

Установка:

```
sudo yum install postgresql-server
```

Инициализация:

```
sudo postgresql-setup initdb
```

Запуск сервиса:

```
sudo systemctl start postgresql.service
```

Подключаемся к серверу:

```
sudo -u postgres psql
```

Меняем пароль пользователя postgres и создаём базу данных:

```
ALTER USER postgres PASSWORD 'root';
CREATE DATABASE cohort26;
```

Редактируем файл pg_hba.conf согласно совету [PostgreSQL - FATAL: Ident authentication failed for user](https://stackoverflow.com/questions/50085286/postgresql-fatal-ident-authentication-failed-for-user) и после этого перезапускаем postgresql:

```
sudo systemctl restart postgresql.service
```

## Развёртыванием HelloLiquibase

Копируем приложение, собранное в виде jar: hello-liquibase-0.0.1-SNAPSHOT.jar, при этом файл application.yaml не должен быть в составе jar, он размещается отдельно в папке /config. Подробнее об этом в статье [Spring Properties File Outside jar](https://www.baeldung.com/spring-properties-file-outside-jar). Запускаем приложение:

```
java -jar hello-liquibase-0.0.1-SNAPSHOT.jar
```

## Развертывание HelloLiquibase как службы

Читаем статью [Spring Boot Application as a Service](https://www.baeldung.com/spring-boot-app-as-a-service), учитывая то, что в CentOS используется Systemd. Создаём файл /etc/systemd/system/hello-liquibase.service со следующим содержимым:

```
[Unit]
Description=Hello-Liquibase
After=syslog.target

[Service]
User=opc
ExecStart=/opt/hello-liquibase/hello-liquibase.jar
SuccessExitStatus=143

[Install]
WantedBy=multi-user.target
```

Перемещаем наш jar файл в папку /opt/hello-liquibase/ (не забываем про папку config с содержимым) и создаём символическую ссылку:

```
sudo ln -s /opt/hello-liquibase/hello-liquibase-0.0.1-SNAPSHOT.jar /opt/hello-liquibase/hello-liquibase.jar
```

Запускаем наше приложение как службу:

```
sudo systemctl start hello-liquibase.service
```

Сервис также можно останавливать (команда stop), перезапускать (restart) и проверять его статус (status)