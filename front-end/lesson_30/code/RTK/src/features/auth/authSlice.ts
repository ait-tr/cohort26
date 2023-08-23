import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import * as api from './api';
import AuthState from './types/AuthState';
import Credentials from './types/Credentials';

const initialState: AuthState = {
	user: undefined,
};

export const login = createAsyncThunk('auth/login', ({ username, password }: Credentials) =>
	api.login(username, password)
);

export const authSlice = createSlice({
	name: 'auth',
	initialState,
	reducers: {},
	extraReducers: (builder) => {
		builder
			.addCase(login.fulfilled, (state, action) => {
				if ('message' in action.payload) {
					state.error = action.payload.message;
				} else {
					state.user = action.payload;
					state.error = '';
				}
				// в случае успешного входа уберем ошибку - если она была
			})
			.addCase(login.rejected, (state, action) => {
				state.error = 'Wrong email or password'; // случай неудачного входа - добавили ошибку
			});
	},
});

export default authSlice.reducer;
