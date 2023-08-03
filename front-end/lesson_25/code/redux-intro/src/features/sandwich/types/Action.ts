type Action =
  | { type: 'sandwich/addIngredient', payload: string }
  | { type: 'sandwich/clear' };

export default Action;
