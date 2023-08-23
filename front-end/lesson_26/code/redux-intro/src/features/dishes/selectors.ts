import { RootState } from '../../store';
import Dish from './types/Dish';

const selectDishes = (state: RootState): Dish[] => state.dishes;

export default selectDishes;
