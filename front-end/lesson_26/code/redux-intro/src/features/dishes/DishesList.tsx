import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import ClearIcon from '@mui/icons-material/Clear';
import styles from './DishesList.module.css';
import selectDishes from './selectors';
import { DishId } from './types/Dish';
import DishEditForm from './DishEditForm';

export default function DishesList(): JSX.Element {
  const dishes = useSelector(selectDishes);
  const dispatch = useDispatch();
  const handleDelete = (id: DishId): void => {
    dispatch({ type: 'dishes/delete', payload: id });
  };

  return (
    <ul className={styles.list}>
      {
        dishes.map((dish) => (
          <li key={dish.id} className={styles.dishCard}>
            <h3 className={styles.heading}>{dish.title}</h3>
            <p className={styles.category}>{dish.category}</p>
            <img className={styles.image} src={dish.image} alt={dish.title} />
            <p className={styles.price}>{dish.price} €</p>
            <ClearIcon onClick={() => handleDelete(dish.id)} />
            <DishEditForm dish={dish} />
          </li>
        ))
      }
    </ul>
  );
}
