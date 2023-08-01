import React from 'react';
import styles from './CatPage.module.css';
import catPicture from './img/cat.jpeg';

export default function CatPage(): JSX.Element {
  return (
    <div className={styles.container}>
      <h1>Cat Pasha</h1>
      <p>Pasha is a british cat, he is grey and he has yellow eyes</p>
      <img className={styles.pashaImage} src={catPicture} alt="Pasha" />
    </div>
  );
}
