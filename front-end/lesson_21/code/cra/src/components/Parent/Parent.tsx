import React from 'react';
import Child from '../Child/Child';
import FlowerCard from '../FlowerCard/FlowerCard';

export default function Parent(): JSX.Element {
  const pirate = { name: 'John', age: 37 };
  const flower = {
    title: 'cactus',
    family: 'CARIOPHULLALES',
    color: 'pink',
    price: 5
  };
  return (
    <div>
      <Child pirate={pirate} />
      <FlowerCard flower={flower} />
    </div>
  );
}
