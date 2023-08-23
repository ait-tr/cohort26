import { Outlet } from 'react-router-dom';
import Navbar from '../components/Navbar/Navbar';

export default function Layout(): JSX.Element {
	return (
		<>
			<header>Хедер</header>
			<Navbar />
			<Outlet />
			<footer>Футер</footer>
		</>
	);
}
