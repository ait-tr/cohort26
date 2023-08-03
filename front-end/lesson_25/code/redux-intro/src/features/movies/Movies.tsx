import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import DeleteIcon from '@mui/icons-material/Delete';
import { RootState } from '../../store';
import MovieEdit from './MovieEdit';

export default function Movies(): JSX.Element {
  const movies = useSelector((state: RootState) => state.movies);
  const dispatch = useDispatch();
  const handleDelete = (id: string): void => {
    dispatch({ type: 'movies/delete', payload: id });
  };
  return (
    <div>
      <h1>Movies</h1>
      <ul>
        {movies.map((movie) => (
          <li key={movie.id}>
            <p>{movie.title}</p>
            <MovieEdit id={movie.id} />
            <p>{movie.country}, {movie.genre}, {movie.releaseDate}</p>
            <DeleteIcon onClick={() => handleDelete(movie.id)} />
          </li>
        ))}
      </ul>
    </div>
  );
}
