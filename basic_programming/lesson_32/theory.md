# Сценарии использования `Git` и [GitHub](https://github.com)

## Создали проект с репозиторием в Idea, создали пустой репозиторий на GitHub

Идеальный вариант.

1. Создаёте проект в Idea с Git репозиторием и примером кода (sample code):
   ![Создаёте проект в Idea с Git репозиторием и примером кода (sample code)](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/project.png)
2. Добавляете в файл `.gitignore` следующие строчки:
   ```
   .idea/
   *.iml
   ```
   1. Если папка `.idea` и файл `ИмяПроекта.iml` отмечены зелёным, то нажимаете кнопку **Rollback** и отмечаете именно их. После отката изменений файлы будут отмечены серо-жёлтым.
   ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/rollback.png)
   1. Если папка `.idea` и файл `ИмяПроекта.iml` (были) отмечены красным, то через какое-то время они сразу станут отмечены жёлтым, кнопка **Rollback** при этом будет недоступна.
3. Пишете свой код, коммитите изменения.
4. Создаёте на GitHub пустой репозиторий
   ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/empty_github_repo.png)
5. Для сохранения изменений на GitHub подключаете свой созданный проект через меню **"Git" -> "Manage remotes..." -> "+"** или через **"Push" -> "Define remote"**.
   - **"Git" -> "Manage remotes..." -> "+"**
      1. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/Git-Manage_remotes.png)
      2. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/add_remote.png)
   - **"Push" -> "Define remote"**
      1. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/Push-Define_remote.png)
   В качестве ссылки вставляете скопированную с GitHub HTTPS-ссылку.
   1. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/empty_github_repo_link.png)
   2. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/define_remote.png)
6. После этого при первой на этом компьтере попытке команды **Push** Idea попросит зайти на GitHub (**Log in via GitHub...**).
   1. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/idea-github.png)
   2. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/jetbrains.png)
   3. ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/github-jetbrains.png)
   4. Открывшуюся страницу с текстом "You can close this page" можно закрывать.

## Создали проект с репозиторием в Idea, создали репозиторий **с файлами** на GitHub

Делаете всё, как в предыдущем пункте.

Ссылка расположена вот здесь:
![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/github_repo_link.png)

При попытке **Push** необходимо сделать **Force push**.
![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/force_push.png)

При необходимости нажать пункт **Force push anyway**.
![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/force_push_anyway.png)

## Создали репозиторий с файлами на GitHub, загружаете его в качестве проекта в Idea.

1. Создаёте репозиторий на GitHub
   ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/github_repo.png)
2. Создаёте проект в Idea из существующего (**Get from VCS** - получить из системы контроля версий)
   ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/get_from_vcs.png)
3. Добавляете в файл `.gitignore` следующие строчки:
   ```
   .idea/
   *.iml
   ```
4. Создаёте папку **src**.
5. Помечаете её как **Sources Root**:
   **Mark Directory as -> Sources Root**
   ![](https://github.com/ait-tr/cohort26/raw/main/basic_programming/lesson_32/img/mark_as-Sources_root.png)
6. Пишете свой код, коммитите (**Commit**) и пушите (**Push**) изменения.
