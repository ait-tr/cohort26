import { uid } from 'uid';
import Movie from './types/Movie';
import Action from './types/Action';

const initialState: Movie[] = [
  {
    id: uid(),
    title: 'Harry Potter',
    genre: 'fantasy',
    country: 'Great Britain',
    releaseDate: '2001-02-03'
  }
];

export default function moviesReducer(
  state: Movie[] = initialState,
  action: Action
): Movie[] {
  switch (action.type) {
    case 'movies/add':
      return [...state, { ...action.payload, id: uid() }];
    case 'movies/delete':
      return state.filter((movie) => movie.id !== action.payload);
    case 'movies/editTitle':
      return state.map(
        (movie) =>
          movie.id === action.payload.id
            ? { ...movie, title: action.payload.newTitle }
            : movie
      );
    default: return state;
  }
}
