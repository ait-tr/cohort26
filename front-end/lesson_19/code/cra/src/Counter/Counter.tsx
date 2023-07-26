import React, { useState } from 'react';
import styles from './Counter.module.css';

function Counter(): JSX.Element {
  const [counter, setCounter] = useState<number>(0);
  function handlePlus(): void {
    setCounter(counter + 1);
  }

  function handleMinus(): void {
    setCounter(counter - 1);
  }

  return (
    <div className={styles.container}>
      <h2 className={styles.heading}>Counter</h2>
      <button type="button" onClick={handleMinus} className={styles.btn}>-</button>
      <span className={styles.counter}>{counter}</span>
      <button type="button" onClick={handlePlus} className={styles.btn}>+</button>
    </div>
  );
}

export default Counter;
