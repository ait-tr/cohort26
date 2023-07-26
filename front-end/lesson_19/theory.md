# Props

Props или пропсы - это аргументы, передаваемые в React компоненты. 

Пропсы передаются через HTML атрибуты (attributes).

Добавление атрибутов "brand" и "color".  

```<Car brand="Ford" color="Black"/>;```

В компоненте пропсы следует принять и типизировать: 

```
import React from 'react';

interface Props {
    brand: string;
    color: string;
}

function Car(props: Props): JSX.Element {
    const{brand, color} = props;
    return (
        <div style={{ backgroundColor: color }}>
            <h3>Карточка машины</h3>
            <p>Бренд машины: {brand} Цвет машины: {color}</p>
        </div>
    );
}

export default Car;
```