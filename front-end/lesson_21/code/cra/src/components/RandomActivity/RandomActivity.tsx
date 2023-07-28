import React, { useEffect, useState } from 'react';
import type Activity from './types/Activity';

export default function RandomActivity(): JSX.Element {
  const initialValue: Activity = {
    activity: '',
    type: '',
    participants: 0,
    price: 0,
    link: '',
    key: '',
    accessibility: 0
  };
  const [activity, setActivity] = useState<Activity>(initialValue);
  async function loadActivity(): Promise<void> {
    const res = await fetch('https://www.boredapi.com/api/activity');
    const obj: Activity = await res.json();
    console.log(obj);
    setActivity(obj);
  }
    // вариант с then
    // fetch('https://www.boredapi.com/api/activity')
    //   .then((res: Response) => res.json())
    //   .then((obj: Activity) => {
    //     setActivity(obj);
    //   });
    // Тоже самое но async await
  useEffect(() => {
    loadActivity();
  }, []);

  return (
    <div>
      <h1>{activity.activity}</h1>
      <p>Участники: {activity.participants} Цена: {activity.price}</p>
      {/* ниже пример условного рендеринга */}
      {activity.link ? <a href={activity.link}>К событию</a> : ''}
      <button type="button" onClick={loadActivity}>Обновить</button>
    </div>
  );
}
