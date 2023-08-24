import React from 'react';
import { Counter } from './features/counter/Counter';
import './App.css';
import ProductsList from './features/products/ProductsList';

function App():JSX.Element {
  return (
    <div className="App">
        <Counter />
        <ProductsList />
    </div>
  );
}

export default App;
