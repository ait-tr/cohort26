/* eslint-disable import/no-extraneous-dependencies */
import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Counter from '../components/Counter/Counter';
import Sandwich from '../components/Sandwich/Sandwich';
import Layout from '../layouts/Layout/Layout';
import Home from '../components/Home/Home';
import RandomActivity from '../components/RandomActivity/RandomActivity';
import ErrorPage from '../components/ErrorPage/ErrorPage';
import Shop from '../components/Shop/Shop';
import ProductPage from '../components/ProductPage/ProductPage';
import ExampleUseParams from '../components/ExampleUseParams/ExampleUseParams';
import UsersPage from '../components/UsersPage/UsersPage';
import UserPage from '../components/UserPage/UserPage';

function App(): JSX.Element {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="counter" element={<Counter />} />
        <Route path="sandwich" element={<Sandwich />} />
        <Route path="random-activity" element={<RandomActivity />} />
        <Route path="products" element={<Shop />} />
        <Route path="products/:productId" element={<ProductPage />} />
        <Route path="users" element={<UsersPage />} />
        <Route path="users/:userId" element={<UserPage />} />
        <Route path="example/:catId/:toyId" element={<ExampleUseParams />} />
        <Route path="*" element={<ErrorPage />} />
        {/* звездочка - если такого пути нету - например, страница 404 */}
      </Route>
    </Routes>
  );
}

export default App;
