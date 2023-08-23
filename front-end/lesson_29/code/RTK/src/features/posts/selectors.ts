import { RootState } from '../../app/store';
import Post from './types/Post';

export const selectPosts = (state: RootState): Post[] => state.posts.posts;
export const selectFiltered = (state: RootState): Post[] =>
	state.posts.filtered;
