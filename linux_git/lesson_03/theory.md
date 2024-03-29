## Коммит

- точка фиксации проекта
- снимок проекта на определенное состояние
- `git commit -m 'update'`

## Индексация файлов (добавление в очередь на коммит)

- `git add .` добавить все изменения

## Git

- вспомогательный инструмент любого разработка

## Просмотр состояния раб/каталога

- `git status -s`

**Основные маркеры**

- `??` Untracked
- `M` Modified
- `D` Deleted
- `A` Added

## Ветвление в Git

- **Ветка** - поток изолированной разработки (еще одна версия проекта)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/96efe921-4ea3-49f9-a2af-c731a0e3ab8d/Untitled.png)

## Клонирование (скачивание) репо

- `git clone скопированная_ссылка`
- выполняется для скачивания на компьютер

## Модели совместной разработки

1. **С доступом на запись (shared repo model)**
    1. лучше подходит для небольших организованных команд с приватными проектами (репо)
2. **Без доступа на запись (Fork and pull model)**
    1. лучше подходит для проектов с открытым исходным кодом и неопределенным кругом разработчиков

## Общий порядок (схема) работы в режиме с доступом на запись к репо

1. Открыть имеющийся репо (или создать новый)
2. Добавить членов команды
3. Клонировать репо (скачать на компьютер)
    1. `git clone ссылка_на_репо`
4. Открыть репо (как проект в любимом редакторе)
5. Создать отдельную ветку под задачу и переключиться на нее
    1. `**git checkout -b my_branch**`
    2. `git checkout -b my_branch main`
    3. `git checkout -b my_branch origin/friend_branch`
6. Вносим изменения в код
7. Фиксируем изменения
8. Выгружаем свою ветку на **GitHub**
    1. `git push -u origin my_branch`
9. Оформляем “заявку на улучшение” (pull request, **PR**, запрос слияния)

## Сценарии коммита

1. **Сценарий 1. Необходим, когда есть новые файлы**
    1. `git add .`
    2. `git commit -m 'update'`
2. **Сценарий 2. Сокращенный порядок**
    1. `git commit -am 'update'`
    

## Fork

- копия репо, созданная на GitHub

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/27098b83-a241-439e-adfc-8149afd8007c/Untitled.png)

## Выпуск ПО (релизы, release)

- очередная версия ПО со всеми улучшениями
- важная точка в жизненном цикле продукта
- представляет собой конкретную версию (сборку)
- периодичность может быть любая (каждый месяц и т.д.)

**Составляющие**

1. **Семантическое версионирование (SemVer)**
    1. способ (подход) к нумерации версий ПО, основанный на семантике (характере) изменений в коде
    2. `v<MAJOR>.<MINOR>.<PATCH>`
2. **Теги (метки) в Git**
    1. Ссылка на определенный коммит
    2. Точка в истории разработки
- `git tag -a v0.1.0 -m 'release 0.1.0'`
- `git push --tags`
1. **Добавление релиза на GitHub**
    1. Открыть **Releases**
    2. Выбрать **Draft a new release**
    3. Дальше выбрать последний тег
    4. Нажать **Generate Release Notes**
    5. Подтвердить создание

### v`MAJOR`.`MINOR`.`PATCH`

`PATCH` - исправление багов, прочие мелкие правки

`MINOR` - улучшения, новый функционал (без нарушения обратной совместимости)

`MAJOR` - координальные изменения (с нарушением обратной совместимости)

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/553339c5-043a-4fef-8f7e-1371e12c7db6/Untitled.png)

## Сценарий. Коммит на ошибочной ветке

- `git branch новая_ветка` создать новую ветку
- `git reset --hard HEAD~1` сбросить откатить ветку (напр., `main`) на один коммит назад