import React, { FormEvent, useState } from 'react';
import { useDispatch } from 'react-redux';

export default function MovieCreation(): JSX.Element {
  const [title, setTitle] = useState<string>('');
  const [genre, setGenre] = useState<string>('');
  const [country, setCountry] = useState<string>('');

  const today = new Date().toISOString().substring(0, 10);
  const [releaseDate, setReleaseDate] = useState<string>(today);
  const [error, setError] = useState<string>('');

  const dispatch = useDispatch();
  function clearInputsAndError(): void {
    setCountry('');
    setGenre('');
    setReleaseDate(today);
    setTitle('');
    setError('');
  }

  function validateInputs(): boolean {
    if (title.trim() === '') {
      setError('Title is required field');
      return false;
    }
    if (genre.trim() === '') {
      setError('Genre is required field');
      return false;
    }
    if (country.trim() === '') {
      setError('Country is required field');
      return false;
    }
    return true;
  }

  function handleSubmit(e: FormEvent<HTMLFormElement>): void {
    e.preventDefault();
    if (validateInputs()) {
      dispatch({
        type: 'movies/add',
        payload: {
          title, genre, country, releaseDate
        }
      });
      clearInputsAndError();
    }
  }
  // '', 0, undefined, null, NaN -> false
  return (
    <div>
      <h1>Форма создания </h1>
      <form onSubmit={handleSubmit}>
        {error && (<div style={{ color: 'red' }}>{error}</div>)}
        <input type="text" placeholder="title" value={title} onChange={(e) => setTitle(e.target.value)} />
        <select name="genre" value={genre} onChange={(e) => setGenre(e.target.value)}>
          <option value="" disabled selected>genre</option>
          <option value="horror">horror</option>
          <option value="documentary">documentare</option>
          <option value="action">action</option>
          <option value="comedy">comedy</option>
          <option value="fantasy">fantasy</option>
        </select>
        <input type="text" placeholder="country" value={country} onChange={(e) => setCountry(e.target.value)} />
        <input type="date" value={releaseDate} onChange={(e) => setReleaseDate(e.target.value)} />
        <button type="submit">Создать</button>
      </form>
    </div>
  );
}
