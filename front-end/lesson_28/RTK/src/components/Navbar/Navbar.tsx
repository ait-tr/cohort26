import { NavLink } from 'react-router-dom';

export default function Navbar(): JSX.Element {
	return (
		<nav>
			<NavLink to="counter">Counter</NavLink>
			<NavLink to="create-product">Create product</NavLink>
			<NavLink to="products">Products</NavLink>
			<NavLink to="/">Home</NavLink>
		</nav>
	);
}
