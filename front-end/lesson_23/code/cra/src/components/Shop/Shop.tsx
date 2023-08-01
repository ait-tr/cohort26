import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import Product from './types/Product';
import styles from './Shop.module.css';

export default function Shop(): JSX.Element {
  const [products, setProducts] = useState<Product[]>([]);

  async function loadProducts(): Promise<void> {
    const res = await fetch('https://fakestoreapi.com/products');
    const arr = await res.json();
    setProducts(arr);
  }

  useEffect(() => {
    loadProducts();
  }, []);

  return (
    <ul className={styles.productList}>
      {products
        .map((product) =>
        (
          <li key={product.id} className={styles.productCard}>
            <span className={styles.title}>{product.title}</span>
            <div className={styles.imgContainer}>
              <img className={styles.image} src={product.image} alt={`product ${product.id}`} />
            </div>
            <span className={styles.price}>{product.price}</span>
            <Link className={styles.link} to={String(product.id)}>К товару</Link>
          </li>
        )
        )}
    </ul>
  );
}
