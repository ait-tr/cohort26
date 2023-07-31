import React, { useEffect, useState } from 'react';

export default function CatFact(): JSX.Element {
  const [fact, setFact] = useState('');
  const [factLength, setFactLength] = useState(0);

  function loadFact(): void {
    fetch('https://catfact.ninja/fact')
      .then((res: Response) => res.json())
      .then((obj: { fact: string, length: number }) => {
        const { fact: catFact, length } = obj;
        setFact(catFact);
        setFactLength(length);
      });
  }
  useEffect(loadFact, []);

  // добавьте кнопку обновить факт
  return (
    <div>
      <h1>Random fact about cat</h1>
      <p>{fact}</p>
      <p>{factLength}</p>
      <button type="button" onClick={loadFact}>Следующий факт</button>
    </div>
  );
}
