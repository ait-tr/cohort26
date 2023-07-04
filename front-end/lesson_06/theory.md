# Bootstrap

[Ссылка на документацию: docs](https://getbootstrap.com/docs/5.0/layout/grid/)

Bootstrap - это фреймворк для разработки веб-интерфейсов, который предоставляет набор готовых CSS-стилей, компонентов и JavaScript-плагинов. Одним из основных компонентов Bootstrap является система сетки (grid system), которая обеспечивает гибкую и адаптивную разметку веб-страниц.

Система сетки Bootstrap основана на концепции разделения веб-страницы на 12 колонок. Вся ширина экрана делится на 12 равных сегментов, которые могут быть использованы для размещения содержимого. Разработчик может выбрать количество колонок, которые будут занимать определенный элемент, и в зависимости от этого элемент будет занимать соответствующую долю доступной ширины.

Bootstrap предлагает классы, которые можно применять к HTML-элементам для определения их расположения в системе сетки. Классы, начинающиеся с "col-", определяют количество колонок, которое элемент будет занимать. Например, класс "col-6" указывает, что элемент будет занимать половину доступной ширины (6 из 12 колонок). Также существуют классы для определения расположения элементов на разных размерах экрана, например, "col-md-4" указывает, что элемент будет занимать 4 колонки на устройствах среднего размера.

Система сетки Bootstrap также позволяет использовать вложенность колонок. Это означает, что элементы могут быть размещены внутри других элементов и занимать определенное количество колонок в пределах родительского элемента. Это полезно для создания сложных макетов и сеток с различными уровнями вложенности.

Одна из важных особенностей системы сетки Bootstrap - ее адаптивность. Фреймворк предоставляет различные классы для определения расположения элементов на различных размерах экрана. Например, классы "col-sm-", "col-md-", "col-lg-" и "col-xl-" позволяют задавать разное количество колонок в зависимости от ширины экрана. Это обеспечивает адаптивность веб-страницы и ее корректное отображение на различных устройствах, таких как мобильные телефоны, планшеты и настольные компьютеры.

Кроме системы сетки, Bootstrap предлагает множество других компонентов и стилей, которые могут быть использованы для создания современных и отзывчивых веб-интерфейсов. Это включает в себя типографию, кнопки, формы, навигацию, модальные окна, карусели и многие другие элементы.

В целом, система сетки Bootstrap является мощным инструментом для создания адаптивных и гибких макетов веб-страниц. Она позволяет разработчикам легко размещать и располагать элементы на странице, а также обеспечивает совместимость и консистентность на различных устройствах и экранах.

## Стартовый шаблон

```html
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <h1>Hello, world!</h1>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>
```
