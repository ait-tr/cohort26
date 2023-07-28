import React from 'react';

interface Flower {
  title: string;
  family: string;
  price: number;
  color: string;
}

interface Props {
  flower: Flower
}

export default function FlowerCard(props: Props): JSX.Element {
  const { flower } = props;
  const {
    title, family, price, color
  } = flower;
  return (
    <div>
      <h3>Карточка цветка {title}</h3>
      <p>Семейство: {family}</p>
      <p>Цена: {price}</p>
      <p style={{ backgroundColor: color }}>Цвет: {color}</p>
    </div>
  );
}
