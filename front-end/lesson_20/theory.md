# useEffect()
Хук Реакта, позволяет выполнять побочные эффекты на одном из этапов жизненного цикла компонента.  
 - Принимает: callback-функцию и массив зависимостей
 - Возвращает: ничего

Callback-функция может возвращать любую другую функцию, которая будет выполнена сразу перед размонтированием компонента.  

useEffect - это функция отложенного типа.

````
    useEffect(() => {
        // какая-то функция-эффект

        return () => {
       // функция очистки эффекта
        }
    }, [/* массив зависимостей */])
````
Массив зависимостей:
- если нет - эффект запускается при каждой отрисовке
- если пустой [] - эффект сработает только при первом рендере
- если есть зависимости [...] - эффект сработает при первом рендере и при изменении переменных, от которых он зависит

Еще пример с async await:
````
 useEffect(() => {
        async function loadGender(): Promise<void> {
            const response = await fetch(`https://api.genderize.io?name=${firstName}`);
            const object = await response.json();
            // console.log(object); // {count: 14512, gender: 'female', name: 'sasha', probability: 0.52}
            setGender(object.gender)
        }
        console.log("use effect gender");
        loadGender()
    },[firstName])
````

## Полезные ссылки
- Общая информация про useEffect и useRef с примерами [ссылка](https://www.w3schools.com/react/react_useeffect.asp)
- Видео Минина про useEffect на примере to-do list [ссылка](https://www.youtube.com/watch?v=hwPo6OLBbD8)
- Видео Минина про все хуки [ссылка](https://www.youtube.com/watch?v=9KJxaFHotqI)
- Сайт с бесплатной Api [ссылка](https://genderize.io/)
- Сайт с генерацией Api вашего формата [ссылка](https://designer.mocky.io/)
