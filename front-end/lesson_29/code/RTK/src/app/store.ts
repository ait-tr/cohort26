import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
// eslint-disable-next-line import/no-cycle
import counterReducer from '../features/counter/counterSlice';
import productsReducer from '../features/products/productsSlice';
import postsReducer from '../features/posts/postsSlice';

export const store = configureStore({
	reducer: {
		counter: counterReducer,
		products: productsReducer,
		posts: postsReducer,
	},
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
	ReturnType,
	RootState,
	unknown,
	Action<string>
>;
