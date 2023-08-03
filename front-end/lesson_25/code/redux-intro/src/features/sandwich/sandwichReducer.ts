import Action from './types/Action';
import SandwichState from './types/SandwichState';

// начальное значение централизованного состояния
const initialState: SandwichState = {
  value: ''
};

export default function sandwichReducer(
  state: SandwichState = initialState,
  action: Action
): SandwichState {
  switch (action.type) {
    case 'sandwich/addIngredient':
      return { ...state, value: `${state.value} ${action.payload}` };
    case 'sandwich/clear':
      return { ...state, value: '' };
    default:
      return state;
  }
}
