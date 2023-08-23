import Product from './Product';

export default interface ProductsState {
  products: Product[];
  error?: string;
  toggle?: boolean;
  favoriteProduct?: Product;
}
