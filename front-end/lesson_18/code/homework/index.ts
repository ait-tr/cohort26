// В отдельном файле ts создайте interface Airplane - самолет с полями:

// numberOfEngines - количество двигателей
// isJet - реактивный
// maxHeight - максимальная высота полета
// capacity - опциональное поле вместимость
// Создайте несколько переменных типа Airplane.

interface Airplane {
  numberOfEngines: number;
  isJet: boolean;
  maxHeight: number;
  capacity?: number;
}

const airbus310: Airplane = {
  numberOfEngines: 4,
  isJet: false,
  maxHeight: 11_000,
  capacity: 100
}
