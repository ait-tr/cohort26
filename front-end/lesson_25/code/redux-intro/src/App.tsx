import React from 'react';
import './App.css';
import Counter from './features/counter/Counter';
import Sandwich from './features/sandwich/Sandwich';
import Tasks from './features/tasks/Tasks';
import TaskCreation from './features/tasks/TaskCreation';
import Movies from './features/movies/Movies';
import MovieCreation from './features/movies/MovieCreation';

function App(): JSX.Element {
  return (
    <div>
      <Counter />
      <Sandwich />
      <Tasks />
      <TaskCreation />
      <MovieCreation />
      <Movies />
    </div>
  );
}

export default App;
