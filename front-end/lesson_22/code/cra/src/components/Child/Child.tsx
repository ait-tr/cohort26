import React from 'react';

interface Pirate {
  name: string;
  age: number;
}

interface Props {
  pirate: Pirate;
}

export default function Child(props: Props): JSX.Element {
  const { pirate } = props;
  const { name, age } = pirate;
  return (
    <div>{name} {age}</div>
  );
}
