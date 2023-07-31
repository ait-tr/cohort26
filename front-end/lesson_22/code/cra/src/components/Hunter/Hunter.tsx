import React from 'react';

interface IHunter {
  name: string;
  age: number;
  isDrunk: boolean;
}

interface Props {
  hunter: IHunter;
}

export default function Hunter(props: Props): JSX.Element {
  const { hunter } = props;
  const { name, age, isDrunk } = hunter;
  return (
    <div>{name} {age} {isDrunk ? 'пьяный' : 'трезвый'}</div>
  );
}
