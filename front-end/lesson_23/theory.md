
## Redux
Это библиотека для JavaScript с открытым исходным кодом, предназначенная для управления состоянием приложения. 

``npm install --save redux``

``npm install --save react-redux``

Решает проблему передачи данных в компоненты путём прокидывания через props. Теперь данные можно хранить в одном месте, используя глобальный state.

## React Redux
React Redux — это официальная библиотека для React, связывающая UI и Redux. Это позволяет вашим React компонентам читать данные из Redux "хранилища" (store) и "отправлять" (dispatch) "действия" (actions) в хранилище для обновления "состояния" (state).

## Хуки Redux
### useSelector
Хук, с помощью которого можно получить доступ к централизованному состоянию.
Принимает - callback-функцию, а она принимает в себя централизованное состояние. Через эту функцию мы получаем какие-то данные при помощи ключей.
Возвращает - данные из централизованного состояния.

Пример:
````
const result = useSelector((state: RootState) => state.auth.login) 

````
### useDispatch()
Хук для доступа к методу dispatch.
Принимает - ничего.
Возвращает - dispatch.

Сама же функция dispatch используется для изменения централизованного состояния.

Пример:
````
<button onClick={() => dispatch{type: "auth/login", payload: "something"}}

````
### reducer
Функция, которая принимает в себя какое-то начальное состояние, и action, который меняет его, и возвращает изменеённое состояние.

Пример:

````
const initialState: authState = {};

export default function authReducer(state: AuthState = initialState, action: Action): AuthState {
  switch (action.type) {
    case 'auth/saveLogin':
     return { ...state, login: action.payload };
     default: return state
  }
  
  // или можем вернуть стэйт здесь
  // return state;
}
````

### store
нужен, чтобы хранить в себе состояния всех сущностей. В объект store при помощи combineReducers() кладём все редьюсеры, чтобы они лежали в одном месте.

Пример:
````
const store = createStore(combineReducers({
   auth: authReducer,
   counter: counterReducer
}))
````

### <Provider>
Компонент, в который нужно обернуть всё наже приложение. С его помощью можно обращаться к store в любом компоненте на любом уровне вложенности.

````
<Provider>
  <App />
<Provider/>
````


