import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import { NavLink } from 'react-router-dom';
import styles from './NavBar.module.css';

export default function NavBar(): JSX.Element {
  return (
    <nav className={styles.container}>
      <NavLink to="counter" className={styles.link}>Counter</NavLink>
      <NavLink to="sandwich" className={styles.link}>Sandwich</NavLink>
      <NavLink to="random-activity" className={styles.link}>Random activity</NavLink>
      <NavLink to="products" className={styles.link}>Shop</NavLink>
      <NavLink to="users" className={styles.link}>Users</NavLink>
      <NavLink to="/" className={styles.link}>Home</NavLink>
    </nav>
  );
}
