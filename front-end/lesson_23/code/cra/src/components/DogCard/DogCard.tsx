import React, { useEffect, useState } from 'react';
import styles from './DogCard.module.css';

export default function DogCard(): JSX.Element {
  const [url, setUrl] = useState('');

  function fetchImage(): void {
    fetch('https://dog.ceo/api/breeds/image/random')
      .then((res: Response) => res.json())
      .then((obj: { message: string }) => {
        const { message } = obj;
        // console.log(message);
        setUrl(message);
      });
  }

  useEffect(() => {
    // функция сработает при Mounting - когда компонент впервые отрисовался
    fetchImage();
  }, []);

  function refreshImage(): void {
    fetchImage();
  }
// Component lifecycle - цикл жизни React компонента
// Mount - монтирование - первичная установка на странице
// Update - жизнь - обновление
// Unmount - размонтирование - когда исчезает со страницы

// useEffect(() => {
//  код будет вызван только при первом рендере
//  }, []);

// useEffect(() => {
//  при каждом рендере элемента
//  });

// useEffect(() => {
//  код будет вызван при первом рендере
//  и в случае изменения переменной anyVar
//  }, [anyVar]);

  return (
    <div className={styles.container}>
      <h1>Random Dog Photo</h1>
      <button type="button" onClick={refreshImage}>Обновить картинку</button>
      <div>
        <img className={styles.image} src={url} alt="" />
      </div>
    </div>
  );
}
