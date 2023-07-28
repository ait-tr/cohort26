import React from 'react';
import styles from './Home.module.css';

export default function Home():JSX.Element {
  return (
    <div className={styles.container}>
      Добро пожаловать на наш сайт.
      Здесь вы сможете посчитать каунтером, посмотреть фото милых животных,
      узнать про город, найти себе случайное занятие.
    </div>
  );
}
