import React, { FormEvent, useState } from 'react';
import EditNoteIcon from '@mui/icons-material/EditNote';
import { useDispatch } from 'react-redux';
import Dish from './types/Dish';

export default function DishEditForm(props: { dish: Dish }): JSX.Element {
  const { dish } = props;
  const [toggle, setToggle] = useState<boolean>(false);
  const handleToggle = (): void => {
    setToggle(!toggle);
  };

  const [title, setTitle] = useState<string>(dish.title);
  const [category, setCategory] = useState<string>(dish.category);
  const [image, setImage] = useState<string>(dish.image);
  const [price, setPrice] = useState<number>(dish.price);
  const [error, setError] = useState<string>('');

  function validateInputs(): boolean {
    if (title.trim() === '') {
      setError('Название не должно быть пустым');
      return false;
    }
    if (category.trim() === '') {
      setError('Выберите категорию');
      return false;
    }
    if (image.trim() === '') {
      setError('Заполните поле картинка');
      return false;
    }
    if (price < 0) {
      setError('Цена не может быть отрицательной');
      return false;
    }
    return true;
  }

  function resetInputsAndError(): void {
    setCategory(dish.category);
    setTitle(dish.title);
    setPrice(dish.price);
    setImage(dish.image);
    setError('');
  }
  const dispatch = useDispatch();
  function handleSubmit(e: FormEvent<HTMLFormElement>): void {
    e.preventDefault();
    if (validateInputs()) {
      dispatch({
        type: 'dishes/edit',
        payload: {
          title, category, image, price, id: dish.id
        }
      });
      resetInputsAndError();
    }
  }

  return (
    <div>
      <EditNoteIcon onClick={handleToggle} />
      {toggle && (
        <form onSubmit={handleSubmit}>
          {error && <div style={{ color: 'red' }}>{error}</div>}
          <input
            type="text"
            placeholder="title"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
          />
          <input
            type="text"
            placeholder="image"
            value={image}
            onChange={(e) => setImage(e.target.value)}
          />
          <select
            name="category"
            value={category}
            onChange={(e) => setCategory(e.target.value)}
          >
            <option value="" disabled>category</option>
            <option value="main">main</option>
            <option value="dessert">dessert</option>
            <option value="snack">snack</option>
          </select>
          <input
            type="number"
            value={price}
            onChange={(e) => setPrice(Number(e.target.value))}
          />
          <button type="submit">Сохранить</button>
        </form>
      )}
    </div>
  );
}
