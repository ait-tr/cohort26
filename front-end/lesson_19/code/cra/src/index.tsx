import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App/App';
import FruitPage from './FruitPage/FruitPage';
import CityPage from './CityPage/CityPage';
import Counter from './Counter/Counter';
import Sandwich from './Sandwich/Sandwich';
import Car from './Car/Car';
import Parent from './Parent/Parent';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <React.StrictMode>
    <App />
    <FruitPage />
    <CityPage />
    <Counter />
    <Sandwich />
    <Car color="red" brand="porsche" />
    <Car color="yellow" brand="ferrari" />
    <Parent />
  </React.StrictMode>
);
