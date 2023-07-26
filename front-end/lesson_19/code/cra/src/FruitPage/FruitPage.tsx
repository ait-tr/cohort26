import React from 'react';
import Fruit from '../Fruits/Fruit';

function FruitPage(): JSX.Element {
  return (
    <div>
      <Fruit color="yellow" title="banana" weight={2500} />
      <Fruit color="green" title="apple" weight={1000} />
      <Fruit color="red" title="apple" weight={2000} />
    </div>
  );
}

export default FruitPage;
