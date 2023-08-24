import { FormEvent, useState } from 'react';
import { useAppDispatch, useAppSelector } from '../../app/hooks';
import { login } from './authSlice';
import { useNavigate } from 'react-router-dom';
import { selectError } from './selectors';

export default function Login(): JSX.Element {
	const [username, setUsername] = useState<string>('');
	const [password, setPassword] = useState<string>('');
	const error = useAppSelector(selectError);
	const dispatch = useAppDispatch();
	const navigate = useNavigate();
	function handleLogin(e: FormEvent<HTMLFormElement>): void {
		e.preventDefault();
		console.log(dispatch(login({ username, password })));
		// .then((data) => console.log(data.meta));
		// navigate('/'); // переводим на другую страничку - путь которой указали в кавычках
	}
	return (
		<>
			<p> Подсказка: kminchelle, 0lelplR</p>
			<p>{error}</p>
			<form onSubmit={handleLogin}>
				<input
					type="text"
					placeholder="username"
					value={username}
					onChange={(e) => setUsername(e.target.value)}
				/>
				<input
					type="text"
					placeholder="password"
					value={password}
					onChange={(e) => setPassword(e.target.value)}
				/>
				<button type="submit">Login</button>
			</form>
		</>
	);
}
