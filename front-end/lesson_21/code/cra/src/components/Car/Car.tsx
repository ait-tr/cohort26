import React from 'react';

interface Props {
  brand: string;
  color: string;
}

export default function Car(props: Props): JSX.Element {
  const { brand, color } = props;
  return (
    <div style={{ backgroundColor: color }}>
      <h2>Car card</h2>
      <p>Марка: {brand}</p>
      <p>Цвет: {color}</p>
    </div>
  );
}

// создайте компонент Fruit с пропсами:
// - title
// - color
// - weight

// При помощи этого компонента создайте несколько элементов
// Желтый банан 2500 гр
// Зеленое яблоко 1000 гр
// Красное яблоко 2000 гр
