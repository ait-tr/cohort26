import MovieCredentials from './MovieCredentials';

type Action =
  | { type: 'movies/add', payload: MovieCredentials }
  | { type: 'movies/delete', payload: string }
  | { type: 'movies/editTitle', payload: { id: string, newTitle: string } };

export default Action;
