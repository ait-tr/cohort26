import { useEffect } from 'react';
import FavoriteIcon from '@mui/icons-material/Favorite';
import { useAppDispatch, useAppSelector } from '../../app/hooks';
import {
	selectFavoriteProduct,
	selectProducts,
	selectToggle,
} from './selectors';
import {
	changeToggleStatus,
	chooseFavoriteProduct,
	deleteProduct,
	loadProducts,
} from './productsSlice';

export default function ProductsList(): JSX.Element {
	const products = useAppSelector(selectProducts);
	const toggle = useAppSelector(selectToggle);
	const favoriteProduct = useAppSelector(selectFavoriteProduct);
	const dispatch = useAppDispatch();
	useEffect(() => {
		dispatch(loadProducts());
	}, [dispatch]);

	function handleDelete(id: number): void {
		dispatch(deleteProduct(id));
	}
	return (
		<div>
			<h1>Products List</h1>
			<h2>Любимый товар: </h2>
			{!favoriteProduct && <p>товар не выбран</p>}
			<p>
				{favoriteProduct?.title} {favoriteProduct?.description}
			</p>
			<div
				style={
					toggle ? { backgroundColor: 'green' } : { backgroundColor: 'red' }
				}
			>
				STATUS
			</div>
			<button type="button" onClick={() => dispatch(changeToggleStatus())}>
				Изменить статус переключателя
			</button>
			<h2>Все товары: </h2>
			{products.map((product) => (
				<li key={product.id}>
					{product.title}
					<FavoriteIcon
						onClick={() => dispatch(chooseFavoriteProduct(product))}
					/>
					<button type="button" onClick={() => handleDelete(product.id)}>
						Удалить
					</button>
				</li>
			))}
		</div>
	);
}
