import { NavLink } from 'react-router-dom';
import { useAppSelector } from '../../app/hooks';
import { selectUser } from '../../features/auth/selectors';

export default function Navbar(): JSX.Element {
	const user = useAppSelector(selectUser);
	return (
		<nav>
			{user?.username ? (
				<>
					<NavLink to="counter">Counter</NavLink>
					<NavLink to="create-product">Create product</NavLink>
					<NavLink to="products">Products</NavLink>
					<NavLink to="/">Home</NavLink>
					<NavLink to="posts">Forum</NavLink>
				</>
			) : (
				<NavLink to="login">Login</NavLink>
			)}
		</nav>
	);
}
