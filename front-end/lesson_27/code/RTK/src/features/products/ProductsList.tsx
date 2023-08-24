import React, { useEffect } from 'react';
import { useAppDispatch, useAppSelector } from '../../app/hooks';
import { selectProducts } from './selectors';
import { deleteProduct, loadProducts } from './productsSlice';

export default function ProductsList():JSX.Element {
  const products = useAppSelector(selectProducts);
  const dispatch = useAppDispatch();
  useEffect(() => {
    dispatch(loadProducts());
  }, [dispatch]);

  return (
    <div>
      <h1>Products List</h1>
      {
        products.map((product) => (
          <li key={product.id}>
            {product.title}
            <button type="button" onClick={() => dispatch(deleteProduct(product.id))}>
              Удалить
            </button>
          </li>
        ))
      }
    </div>
  );
}
