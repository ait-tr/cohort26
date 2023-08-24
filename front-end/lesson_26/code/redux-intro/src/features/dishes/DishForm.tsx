import React, { FormEvent, useState } from 'react';
import { useDispatch } from 'react-redux';

export default function DishForm(): JSX.Element {
  const [title, setTitle] = useState<string>('');
  const [category, setCategory] = useState<string>('');
  const [image, setImage] = useState<string>('');
  const [price, setPrice] = useState<number>(0);
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

  function clearInputsAndError(): void {
    setCategory('');
    setTitle('');
    setPrice(0);
    setImage('');
    setError('');
  }
  const dispatch = useDispatch();
  function handleSubmit(e: FormEvent<HTMLFormElement>): void {
    e.preventDefault();
    if (validateInputs()) {
      dispatch({
        type: 'dishes/create',
        payload: {
          title, category, image, price
        }
      });
      clearInputsAndError();
    }
  }

  return (
    <div>
      <h1>Форма создания меню</h1>
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
        <button type="submit">Создать блюдо</button>
      </form>
    </div>
  );
}
