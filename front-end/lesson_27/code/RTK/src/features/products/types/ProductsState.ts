import Product from './Product';

export default interface ProductsState {
  products: Product[],
  error?: string
}
