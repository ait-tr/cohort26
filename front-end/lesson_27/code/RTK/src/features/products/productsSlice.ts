import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import ProductsState from './types/ProductsState';
import * as api from './api';

const initialState: ProductsState = {
  products: [],
};

// Как писать фичу
// папка -> types -> типы для одной сущности и для централизрованного состояния
// -> пишем api -> создаем файл slice -> initital state -> async thunk ->
// -> сам slice -> добавляем в store

// eslint-disable-next-line import/prefer-default-export
export const loadProducts = createAsyncThunk(
  'products/loadProducts', // type нашего action
  () => api.getAll() // payload - в данном случае Product[]
  // - то что возвращает api с раскрытым промисом
);

export const deleteProduct = createAsyncThunk(
  'products/deleteProduct', // type нашего action
  (id: number) => api.deleteProduct(id) // payload - в данном случае Product
);

export const productsSlice = createSlice({
  name: 'products',
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(loadProducts.fulfilled, (state, action) => {
        state.products = action.payload;
      })
      .addCase(deleteProduct.fulfilled, (state, action) => {
        state.products = state.products.filter((product) => product.id !== action.payload.id);
      });
  }
});

export default productsSlice.reducer;
