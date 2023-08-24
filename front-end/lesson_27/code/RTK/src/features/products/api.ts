import Product from './types/Product';

// GET - метод для получения данных
// eslint-disable-next-line import/prefer-default-export
export async function getAll(): Promise<Product[]> {
  const res = await fetch('https://fakestoreapi.com/products');
  return res.json(); // в этой строке без await
}

// DELETE - явно указали
export async function deleteProduct(id: number): Promise<Product> {
  const res = await fetch(`https://fakestoreapi.com/products/${id}`, {
    method: 'DELETE'
  });
  return res.json();
}
