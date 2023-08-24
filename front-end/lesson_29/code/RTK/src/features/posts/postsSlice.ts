import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import PostsState from './types/PostsState';
import * as api from './api';

const initialState: PostsState = {
	posts: [],
	filtered: [],
};

export const loadPosts = createAsyncThunk('posts/loadPosts', () =>
	api.getAll()
);

export const loadPostsByWord = createAsyncThunk(
	'posts/loadPostsByWord',
	(word: string) => api.getPostsByWord(word)
);

export const editTitle = createAsyncThunk(
	'posts/editTitle',
	({ title, id }: { title: string; id: number }) => api.editPostTitle(title, id)
);

export const postsSlice = createSlice({
	name: 'posts',
	initialState,
	reducers: {},
	extraReducers: (builder) => {
		builder
			.addCase(loadPosts.fulfilled, (state, action) => {
				state.posts = action.payload.posts;
			})
			.addCase(editTitle.fulfilled, (state, action) => {
				// если бы айпишка сохраняла - мы бы использовали вместо filtered - posts
				state.filtered = state.filtered.map((post) =>
					post.id === action.payload.id ? action.payload : post
				);
			})
			.addCase(loadPostsByWord.fulfilled, (state, action) => {
				state.filtered = action.payload.posts;
			});
	},
});

export default postsSlice.reducer;
