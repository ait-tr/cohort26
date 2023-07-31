import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import { Outlet } from 'react-router-dom';
import NavBar from '../../components/NavBar/NavBar';

export default function Layout(): JSX.Element {
  return (
    <>
      <header>
        {/* здесь хедер, если нужно */}
      </header>
      <NavBar />
      {/* вместо аутлета подставляет компонент, чей путь указан в адресной строке */}
      <Outlet />
      <footer>
        Футер
      </footer>
    </>
  );
}
