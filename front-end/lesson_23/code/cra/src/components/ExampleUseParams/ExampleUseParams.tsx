import React from 'react';
import { useParams } from 'react-router-dom';

export default function ExampleUseParams(): JSX.Element {
  const { catId, toyId } = useParams();
  // useParams возращает объект с ключами, которые мы указали после двоеточий в App
  // path="example/:catId/:toyId"
  // тип параметра string | undefined
  return (
    <div>
      <h1>Пример для useParams</h1>
      <p>Кошка под индексом: {catId} </p>
      <p>Игрушка под индексом: {toyId} </p>
    </div>
  );
}
