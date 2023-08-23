import Dish, { DishId } from './Dish';
import DishDto from './DishDto';

type Action =
  | { type: 'dishes/create', payload: DishDto }
  | { type: 'dishes/delete', payload: DishId }
  | { type: 'dishes/edit', payload: Dish };

export default Action;
