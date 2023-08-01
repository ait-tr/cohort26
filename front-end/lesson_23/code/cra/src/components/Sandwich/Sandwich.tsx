import React, { useState } from 'react';
import styles from './Sandwich.module.css'; // импорт модуля css

export default function Sandwich(): JSX.Element {
  const [sandwich, setSandwich] = useState<string>('Бутерброд:');
  function handleAddCheese(): void {
    setSandwich(`${sandwich} сыр`);
  }
  function handleAddBread(): void {
    setSandwich(`${sandwich} хлеб`);
  }
  function handleAddSalami(): void {
    setSandwich(`${sandwich} колбаса`);
  }
  function handleClear(): void {
    setSandwich('Бутерброд:');
  }
  return (
    <div className={`${styles.container} ${styles.anotherClass}`}>
      <h1>Sandwich</h1>
      <p>{sandwich}</p>
      <button type="button" onClick={handleAddCheese} className={styles.btn}>Добавить сыр</button>
      <button type="button" onClick={handleAddBread} className={styles.btn}>Добавить хлеб</button>
      <button type="button" onClick={handleAddSalami} className={styles.btn}>Добавить колбасу</button>
      <button type="button" onClick={handleClear} className={styles.btn}>Сбросить</button>
    </div>
  );
}
