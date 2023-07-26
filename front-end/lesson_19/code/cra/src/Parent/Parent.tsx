import React from 'react';
import Child from '../Child/Child';

export default function Parent(): JSX.Element {
  const pirate = { name: 'John', age: 37 };
  return (
    <div>
      <Child pirate={pirate} />
    </div>
  );
}
