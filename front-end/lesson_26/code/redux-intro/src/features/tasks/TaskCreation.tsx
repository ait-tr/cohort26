import React, { FormEvent, useState } from 'react';
import { useDispatch } from 'react-redux';

export default function TaskCreation(): JSX.Element {
  const [title, setTitle] = useState<string>('');
  const [description, setDescription] = useState<string>('');
  const dispatch = useDispatch();

  function handleSubmit(event: FormEvent<HTMLFormElement>): void {
    event.preventDefault();
    dispatch({ type: 'tasks/add', payload: { title, description, isDone: false } });
    setTitle('');
    setDescription('');
  }

  return (
    <div>
      <h1>Форма создания задачи</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="title"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <input
          type="text"
          placeholder="description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <button type="submit">Создать</button>
      </form>
    </div>
  );
}
