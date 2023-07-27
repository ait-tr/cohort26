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
import CatPage from './CatPage/CatPage';
import Animal from './Animal/Animal';
import HunterParent from './HunterParent/HunterParent';
import DogCard from './DogCard/DogCard';
import CatFact from './CatFact/CatFact';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  // <React.StrictMode>
  <>
    <App />
    <FruitPage />
    <CityPage />
    <Counter />
    <Sandwich />
    <Car color="red" brand="porsche" />
    <Car color="yellow" brand="ferrari" />
    <Parent />
    <CatPage />
    <Animal title="Львица" description="Люблю погулять под Берлином" age={2} />
    <Animal title="Кабанчик" description="Люблю театр" age={3} />
    <Animal title="Кабан" description="Дружу с кабанчиком, играем в охоту по ночам" age={6} />
    <HunterParent />
    <DogCard />
    <CatFact />
  </>
  // </React.StrictMode>
);
