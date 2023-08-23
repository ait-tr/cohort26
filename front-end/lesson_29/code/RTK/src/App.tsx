/* eslint-disable import/no-extraneous-dependencies */
import { Route, Routes } from 'react-router-dom';
import { Counter } from './features/counter/Counter';
import './App.css';
import ProductsList from './features/products/ProductsList';
import ProductCreate from './features/products/ProductCreate';
import Layout from './layouts/Layout';
import Home from './components/Home/Home';
import PostsList from './features/posts/PostsList';

function App(): JSX.Element {
	return (
		<Routes>
			<Route path="/" element={<Layout />}>
				<Route index element={<Home />} />
				<Route path="counter" element={<Counter />} />
				<Route path="create-product" element={<ProductCreate />} />
				<Route path="products" element={<ProductsList />} />
				<Route path="posts" element={<PostsList />} />
			</Route>
		</Routes>
	);
}

export default App;
