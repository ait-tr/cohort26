import { combineReducers, createStore } from 'redux';
import counterReducer from './features/counter/counterReducer';
import sandwichReducer from './features/sandwich/sandwichReducer';
import tasksReducer from './features/tasks/tasksReducer';
import moviesReducer from './features/movies/moviesReducer';
import dishesReducer from './features/dishes/dishesReducer';

const store = createStore(combineReducers(
  {
    counter: counterReducer,
    sandwich: sandwichReducer,
    tasks: tasksReducer,
    movies: moviesReducer,
    dishes: dishesReducer,
    // здесь имена других фич и ссылка на редюсеры
  }
));

export default store;

export type RootState = ReturnType<typeof store.getState>;
