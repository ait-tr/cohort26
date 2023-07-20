const cityElement = document.getElementById("city");
const temperatureElement = document.getElementById("temperature");
const windElement = document.getElementById("wind");
const descriptionElement = document.getElementById("description");

// https://get.geojs.io/v1/ip/geo.json
// киньте fetch по адресу и получите денные про широту, долготу и город
// 18-00

async function loadWeather() {
  const res = await fetch("https://get.geojs.io/v1/ip/geo.json");
  const obj = await res.json();
  console.log(obj);
  const { longitude, latitude, city } = obj;
  console.log(longitude, latitude, city);
  // сделать фетч запрос по адресу, 
  // заменить в строке запроса координаты на те, которые получены выше :
  // https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current_weather=true
  // Получить данные погоды: температуру, скорость ветра и т.д.
  // Обратите внимание, что объект будет вложен в другой объект в данном конкретном случая
  // 18-45
  const weatherRes = await fetch(`https://api.open-meteo.com/v1/forecast?latitude=${latitude}&longitude=${longitude}&current_weather=true`);
  const weatherObj = await weatherRes.json();
  // console.log(weatherObj);
  const { current_weather } = weatherObj;
  // console.log(current_weather);
  const { temperature,
    windspeed,
    winddirection,
    weathercode,
    is_day,
    time } = current_weather;

  console.log(windspeed);
  console.log(weathercode); // цифра обозначающая код погоды 
  console.log(getWeatherDescription(weathercode));

  cityElement.textContent += city;
  temperatureElement.textContent += temperature;
  windElement.textContent += windspeed;
  descriptionElement.textContent += getWeatherDescription(weathercode);
  // 1. функция, которая интерпертирует код погоды

  //  0 -> "clear sky"
  //  1 -> "Mainly clear"

  // 2. Разместите информацию на html странице 

  // 3. Подключите стили

  // 4. Рефакторинг кода - в отдельные методы (опционально)

  // 5. Сделайте deploy на git pages 

}

function getWeatherDescription(code) {
  switch (code) {
    case 0:
      return "Clear sky";
    case 1:
      return "Mainly clear";
    case 2:
      return "Partly cloudy";
    case 3:
      return "Overcast";
    case 45:
      return "Fog";
    case 48:
      return "Depositing rime fog";
    case 51:
      return "Light drizzle";
    case 53:
      return "Moderate drizzle ";
    case 55:
      return "Dense intensity drizzle";
    case 56:
      return "Light freezing drizzle";
    case 57:
      return "Dense intensity drizzle";
    case 61:
      return "Slight rain";
    case 63:
      return "Moderate rain";
    case 65:
      return "Heavy intensity rain";
    case 66:
      return "Light freezing rain";
    case 67:
      return "Freezing rain heavy intensity";
    case 71:
      return "Slight snow fall";
    case 73:
      return "Moderate snow fall";
    case 75:
      return "Heavy intensity snow fall";
    case 77:
      return "Snow grains";
    case 80:
      return "Slight rain showers Slight";
    case 81:
      return "Moderate rain showers";
    case 82:
      return "Violent rain showers";
    case 85:
      return "Slight snow showers";
    case 86:
      return "Heavy snow showers";
    case 95:
      return "Thunderstorm: slight and moderate";
    case 96:
      return "Thunderstorm with slight hail";
    case 99:
      return "Thunderstorm with heavy hail";
    default:
      return "-";
  }
}

loadWeather();


// 1. зашли в браузер создали новый репозиторий на гите
// 2. git init // обязтельно зайдите в папку проекта - чтобы она была написана большими буквами WEATHER-APP
// 3. git remote add origin git@github.com:AlisherKhamidov/weather.git  // взяли команду из браузера 
// 4. git branch -M main
// 5. git add .
// 6. git commit -m "init"
// 7. git push origin main
// 8. заходим в браузер - settings - pages - выбрать Branch - main - нажать save