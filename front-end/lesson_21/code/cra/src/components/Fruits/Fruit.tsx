import React from 'react';

interface Props {
  color: string;
  weight: number;
  title: string;
}

export default function Fruit(props: Props): JSX.Element {
  const { color, weight, title } = props;
  return (
    <div>
      <p>{title} {color} {weight} гр</p>
    </div>
  );
}
