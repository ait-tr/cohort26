
# Проект - день 1
## Deploy Vite project on GitHub Pages
Инструкция по деплою проекта React, созданного на vite.
Дорогие друзья, на данном этапе вы уже создали реакт-приложение, осталось только сделать финальные штрихи. Данная инструкция поможет вам, выполните ее по шагам.

1. В package.json вашего проекта перед строчкой ``name`` добавьте строку

```"homepage": "./", ```

2. Установите пакет gh-pages при помощи команды.
   ```npm install gh-pages -D```  
   Обратите внимание, что после выполнения в файле package.json будет добавлена новая  development dependencies:
```
"devDependencies": {
    "gh-pages": "^5.0.0"
  }
  ```
3. Добавьте свойства "predeploy" и "deploy" в скрипт в "scripts" в `package.json`
 ```json
  "scripts": {
    "start": "react-scripts start",
    "predeploy": "npm run build",
    "deploy": "gh-pages -d build",
    "build": "react-scripts build",
    "test": "react-scripts test",
    "eject": "react-scripts eject",
    "typecheck": "tsc",
    "lint": "eslint ."
  },
 ```
4. Создайте пустой репозиторий на GitHub. Вы можете назвать его так же как ваше приложение.
5. В файле `vite.config.ts` добавьте строчку ```base: '/имя-репозитория-гитхаб/',```
   Пример того, как выглядит файл после добавления.
  ```
  import { defineConfig } from 'vitest/config';
import react from '@vitejs/plugin-react';

// https://vitejs.dev/config/
export default defineConfig({
	plugins: [react()],
	server: {
		open: true,
	},
	base: '/vite-deploy/',
	build: {
		outDir: 'build',
		sourcemap: true,
	},
	test: {
		globals: true,
		environment: 'jsdom',
		setupFiles: 'src/setupTests',
		mockReset: true,
	},
});
  ```
6. Если в вашем проекте используется роутер, замените BrowserRouter на HashRouter:
 ``` javascript
 import { HashRouter } from 'react-router-dom';

 const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <HashRouter>
      <App />
    </HashRouter>
  </React.StrictMode>
);
 ```



7. Добавьте "remote" к вашему локальному GitHub репозиторию

Для этого запустите в терминале команды:

``git init``

``git remote add origin https://github.com/<username>/<repo-name>.git`` - Не забудьте заменить `<username>` и `<repo-name>` на ваше актуальное имя пользователя и имя репозитория. - можете взять эту команду из предложенных при создании репозитория

8. Запустите деплой React app в GitHub
   Для это запустите команду: ``npm run deploy``
```
Это приведет к запуску скриптов predeploy и deploy, определенных в package.json.

Под капотом сценарий предварительного развертывания(predeploy) создаст дистрибутив версию приложения React и сохранит ее в папке с именем build. Затем сценарий развертывания запушит содержимое этой папки в новую в ветку gh-pages вашего репозитория GitHub, создав эту ветку, если она еще не существует.

По умолчанию новый коммит в ветке gh-pages будет иметь сообщение коммита `Updates`. Вы можете указать собственное сообщение коммита: 
npm run deploy -- -m "Deploy React app to GitHub Pages"
```

9.  Настройка GitHub Pages (этот шаг может сделаться автоматически, тогда просто проверьте, что все так)
    В вашем браузере перейдите в настройки GitHub Pages
    "Settings" --> "Code and automation" --> "Pages" --> "Build and deployment"

Выберите следующие значения:
- Source: Deploy from a branch
- Branch: gh-pages
- Folder: / (root)  
  Нажмите "Save".   
  На этом этапе вы успешно справились с deploy. 😈

9. Опционально можете разместить source код на GitHub в ветке main
```
git add .
git commit -m "Message of your commit"
git push origin master
```




