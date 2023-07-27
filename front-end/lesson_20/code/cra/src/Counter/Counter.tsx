import React, { useEffect, useState } from 'react';
import styles from './Counter.module.css';

function Counter(): JSX.Element {
  const [counter, setCounter] = useState<number>(0);
  const [age, setAge] = useState(30);
  function handleAge(): void {
    setAge(age + 1);
  }

  function handlePlus(): void {
    setCounter(counter + 1);
  }

  function handleMinus(): void {
    setCounter(counter - 1);
  }
  // Случай 1 -  пустой массив зависимостей - мать кукушка
  useEffect(() => {
    console.log('useEffect 1 - только при первом рендере');
  }, []);

  // Случай 2 - не указали зависимостей - бабушка в любом случае ворчит
  useEffect(() => {
    console.log('useEffect 2 - при первом и каждом другом рендере - при любых изменениях');
  });

  // Случай 3 - указали зависимость - counter - мать ребенка по имени каунтер
  useEffect(() => {
    console.log('useEffect 3 - при первом рендере и при каждом изменении переменной counter');
  }, [counter]);

  // мать ребенка по имени age
  useEffect(() => {
    console.log('useEffect 4-age - при первом рендере и при каждом изменении переменной age');
  }, [age]);

  // бабушка age и каунтера
  useEffect(() => {
    console.log('useEffect 4-age-counter - при первом рендере и при каждом изменении переменной age и counter');
  }, [age, counter]);

  return (
    <div className={styles.container}>
      <h2 className={styles.heading}>Counter</h2>
      <button type="button" onClick={handleMinus} className={styles.btn}>-</button>
      <span className={styles.counter}>{counter}</span>
      <button type="button" onClick={handlePlus} className={styles.btn}>+</button>
      <span>Возраст: {age}</span>
      <button type="button" onClick={handleAge} className={styles.btn}>Стать старше</button>
    </div>
  );
}

export default Counter;
