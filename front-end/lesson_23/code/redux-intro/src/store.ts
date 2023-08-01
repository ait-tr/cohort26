import { combineReducers, createStore } from 'redux';
import counterReducer from './features/counter/counterReducer';

const store = createStore(combineReducers(
  {
    counter: counterReducer,
    // здесь имена других фич и ссылка на редюсеры
  }
));

export default store;

export type RootState = ReturnType<typeof store.getState>;
