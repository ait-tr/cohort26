import { RootState } from '../../app/store';
import User from './types/User';

export const selectUser = (state: RootState): User | undefined =>
	state.auth.user;

export const selectError = (state: RootState): string | undefined =>
	state.auth.error;
