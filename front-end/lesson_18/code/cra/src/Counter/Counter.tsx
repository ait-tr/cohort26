import React, { useState } from 'react';

function Counter(): JSX.Element {
  // создали переменную состояния counter
  // и функцию setCounter для изменения состояния
  // useState - это хук
  // в круглых скобочках начальное состояние переменной состояния

  // Хук useState принимает начальное значение переменной состояния
  // возвращает массив в котором на первом месте: переменная состояния
  // а на втором месте: функция сетер
  const [counter, setCounter] = useState<number>(0);
  function handlePlus(): void {
    setCounter(counter + 1);
  }

  function handleMinus(): void {
    setCounter(counter - 1);
  }

  return (
    <div>
      <h2>Counter</h2>
      <button type="button" onClick={handleMinus}>-</button>
      <span style={{ backgroundColor: 'lightblue' }}>{counter}</span>
      <button type="button" onClick={handlePlus}>+</button>
    </div>
  );
}

export default Counter;
