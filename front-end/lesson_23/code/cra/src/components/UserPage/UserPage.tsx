import React, { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import User from '../UsersPage/types/User';

export default function UserPage(): JSX.Element {
  const { userId } = useParams();
  const initialValue: User = {
    id: 0,
    email: '',
    username: '',
    password: '',
    name: {
      firstname: '',
      lastname: ''
    },
    address: {
      city: '',
      street: '',
      number: 0,
      zipcode: '',
      geolocation: {
        lat: '',
        long: ''
      }
    },
    phone: ''
  };
  const [user, setUser] = useState<User>(initialValue);
  useEffect(() => {
    async function loadUser(): Promise<void> {
      const res = await fetch(`https://fakestoreapi.com/users/${userId}`);
      const obj = await res.json();
      setUser(obj);
    }
    loadUser();
  }, [userId]);
  return (
    <div style={{ border: 'solid black 2px', margin: '10px' }} key={user.id}>
      <div>Ник: {user.username}</div>
      <div>Имя, фамилия: {user.name.firstname} {user.name.lastname}</div>
      <div>Телефон: {user.phone}</div>
      <div>E-mail: {user.email}</div>
      <div>Zip-code: {user.address.zipcode}</div>
      <Link to="../users">К cписку пользователей</Link>
    </div>
  );
}
