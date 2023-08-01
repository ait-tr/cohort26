import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import User from './types/User';

export default function UsersPage(): JSX.Element {
  const [users, setUsers] = useState<User[]>([]);
  async function loadUsers(): Promise<void> {
    const res = await fetch('https://fakestoreapi.com/users');
    const arr = await res.json();
    setUsers(arr);
  }

  useEffect(() => {
    // здесь будем бросать фетч
    loadUsers();
  }, []);

  return (
    <div>
      <ul>
        {users.map((user) => (
          <li style={{ border: 'solid black 2px', margin: '10px' }} key={user.id}>
            <div>Ник: {user.username}</div>
            <div>Имя, фамилия: {user.name.firstname} {user.name.lastname}</div>
            <div>Телефон: {user.phone}</div>
            <div>E-mail: {user.email}</div>
            <div>Zip-code: {user.address.zipcode}</div>
            <Link to={String(user.id)}>К пользователю</Link>
          </li>
        )
        )}
      </ul>
    </div>
  );
}
