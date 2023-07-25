
### Create react app, useState, eslint
Чтобы создать приложение зайдите в папку, где хотите его расположить и введите в терминал команду(замените my-app на имя вашего приложения):
- npx create-react-app my-app --template typescript

После этого войдите в терминале в директорию приложение:
- верхнее меню file -> open folder 

И запустите приложение, откройте териминал в VSСode:
- npm start

### Запустите в терминале команды:
- `npm install --save-dev eslint-config-airbnb`
- `npm install --save-dev eslint-config-airbnb-typescript`
  
После выполнения команд, у вас package-json у вас появится следующее свойство:
```json lines
  "devDependencies": {
    "eslint-config-airbnb": "^19.0.4",
    "eslint-config-airbnb-typescript": "^17.0.0"
  }
```

- После этого замените в package-json свойства "scripts" и "eslintConfig" на:
````json lines
"scripts": {
    "start": "react-scripts start",
    "build": "react-scripts build",
    "test": "react-scripts test",
    "eject": "react-scripts eject",
    "typecheck": "tsc",
    "lint": "eslint ."
  },
  "eslintConfig": {
    "extends": [
      "react-app",
      "react-app/jest",
      "airbnb",
      "airbnb-typescript"
    ],
    "rules": {
      "react/jsx-indent": 0,
      "implicit-arrow-linebreak": 0,
      "@typescript-eslint/indent": 0,
      "@typescript-eslint/comma-dangle": 0,
      "function-paren-newline": 0,
      "no-param-reassign": 0,
      "no-nested-ternary": 0,
      "no-confusing-arrow": 0,
      "operator-linebreak": 0,
      "jsx-a11y/anchor-is-valid": 0,
      "jsx-a11y/label-has-associated-control": 0,
      "react/jsx-one-expression-per-line": 0,
      "jsx-a11y/click-events-have-key-events": 0,
      "default-case": 0,
      "@typescript-eslint/default-param-last": 0,
      "@typescript-eslint/switch-exhaustiveness-check": 2,
      "@typescript-eslint/explicit-function-return-type": [
        2,
        {
          "allowExpressions": true,
          "allowTypedFunctionExpressions": true,
          "allowHigherOrderFunctions": true,
          "allowDirectConstAssertionInArrowFunctions": true
        }
      ]
    },
    "parserOptions": {
      "project": [
        "tsconfig.json"
      ]
    }
  },
````

Теперь когда вы запускаете приложение у вас будут показываться ошибки от eslint.

Плюс все ошибки, которые eslint может исправить сам - вы сможете исправить, если запустите команду 
`npm run lint -- --fix`, однако многие проблемы необходимо решить вручную, например указание типа возвращаемого значения функций. 

### Для проектов на CRA мы будем использовать ES модули — с синтаксисом import/export
// App.jsx  
export default App;

// index.jsx  
import App from './App';

### node_modules
Поскольку директория node_modules указана в gitignore, когда вы склонируете проект к себе, вам потребуется подгрузить все эти модули, сделать это можно при помощи команды `npm i`.

## Ссылки
- React CRA: [ссылка](https://create-react-app.dev/docs/adding-typescript/)





