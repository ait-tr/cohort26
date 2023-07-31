import React from 'react';
import Hunter from '../Hunter/Hunter';

export default function HunterParent(): JSX.Element {
  const hunter = {
    name: 'John',
    age: 46,
    isDrunk: true
  };

  return (
    <div>
      <Hunter hunter={hunter} />
    </div>
  );
}
