### React Router

React Router — библиотека для работы с маршрутами в React.
React Router DOM — обёртка для React Router в веб-приложениях

### Декларативная маршрутизация
Декларативная маршрутизация — это стиль кодирования, используемый в React и React Router. Декларативные маршруты React являются компонентами и используют ту же инфраструктуру, что и любое приложение React. Эти маршруты связывают веб-адреса с определенными страницами и другими компонентами, используя мощный механизм рендеринга React и условную логику для программного включения и выключения маршрутов.

#### Чтобы установить пакет введите команду:
```npm i react-router-dom```

### Настройка приложения
```
import { BrowserRouter } from 'react-router-dom';

...

  <BrowserRouter>
    <App />
  </BrowserRouter>

```

```
import { Route, Routes } from 'react-router-dom';
...
function App(): JSX.Element {
return (
    <Routes>
        <Route path="/" element={<Layout />}>
            <Route path="/counter" element={<Counter />} />
            <Route path="/" element={<HomePage />} />
        </Route>
    </Routes>
);
}
```
```
import React from 'react';
import { Outlet } from 'react-router-dom';
import Navbar from '../componets/Navbar/Navbar';

export default function Layout(): JSX.Element {
    return (
        <>
            <Navbar />
            <Outlet />
        </>
    );
}
```

## Хуки от react-router

- Хук useNavigate возвращает функцию, которая позволяет осуществлять навигацию по сайту.
```
импорт:
    import { useNavigate } from "react-router-dom";
хук:
    const navigate = useNavigate();
использование:
    navigate("/main");
```


Подробнее узнать о роутер-дом вы можете на официальном [сайте](https://reactrouter.com/en/main)

Чтобы отключить сообщение об ошибке импорта из 'react-router-dom' добавьте правило в настройки eslint в package.json:

```"import/no-extraneous-dependencies": "off"```

## Компоненты от react-router
### `<Link>`
Обеспечивает декларативный и доступный способ навигации в приложении.
```
<Link to="/about">Контакты</Link>
```

### `<NavLink>`
Специальная версия ```<Link>```, предназначенная для добавления стилей к элементу, совпадающему с текущим URL (активному элементу).
(Например, если вы находитесь в личном кабинете, NavLink личный кабинет будет выделяться)

```<NavLink to="/about">About</NavLink>```

Пример применения стилей к активному элементу:
```
<NavLink
    to="/faq"
    activeStyle={{
        fontWeight: 'bold',
        color: 'red',
    }}
>
Часто задаваемые вопросы
</NavLink>
```