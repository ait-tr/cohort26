public class Main {

    public static void main(String[] args) {
      int x = 9;
      //String x ="wert";
      x = 10;

        System.out.println("x="+x);
      //  System.out.println("X="+X);

        int priceA =1000;
        int priceB = 500;
        int discount = 100;

        int y=5;
        y = y+1;
        y++;//increment - увеличивает значение переменной на единицу

        y = y-1;
        y--;// decrement operator

        y++;//postfix form
        --y;
        ++y;// prefix form

        x=10;
        y = ++x;//11
        System.out.println("if ++x then y = "+y);
        System.out.println("x = "+x);

        x = 10;
        y = x++; //10
        System.out.println("if x++ then y = "+y);
        System.out.println("x = "+x);


        x = x +10;

        x = 0;
        x += 10;

        x = x - 100;//то же самое что и запись в строке 43
        x -= 100;
     //   x = -100;
        x *= 10;

        //Type conversion

        int i;
        float f;

        i = 10;
        f = i; // assign an int to float  присваиваем переменной типа float значение int

        boolean bool = false;
       // i = bool

        long l;
        l = i;
        // для автоматического присвоения одного типа другому должны соблюдаться два условия:
       // - типы данных должны быть совместимы
        // - тип данных слева больше чем источник данных ( тип данных справа )

        double d;

        l = 10000000L;
        d = l;

        byte b = 100;
        i = b;

        //присвоение несовместимых типов .  Casting incompatible types

          double x1,y1;
          byte b1;
          int i1;
          char ch;

          x1 = 10.0;
          y1 = 3.0;

          i1 =(int) (x1/y1);// casting double to int
      System.out.println("integer result of x/y: "+i1);
     // i1 =(int) x1;

        i = 100;
        b1 =(byte) i;
      System.out.println("b is "+b1);

      i = 300;
      b1 =(byte) i;
      System.out.println(" if i is 300, b is "+b1);

      b1 =88;
      ch = (char)b1;
      System.out.println("ch: "+ch);

      // Class Math

      // вычисляет абсолютное значение числа
      int abs1 = Math.abs(10);
      int abs2 = Math.abs(-10);
      System.out.println(abs2);

      int min =Math.min(10,20);
      System.out.println("min= "+min);

      Math.max(10,20);

      int n = 2;
      System.out.println(n*n*n);

     double power = Math.pow(2,2);
      System.out.println("power2 = "+power);

     double power8 = Math.pow(2,8);
      System.out.println("power8 = "+power8);

     double sqrt4 = Math.sqrt(4);
      System.out.println("sqrt4 = "+sqrt4);

     double pi = Math.PI;
      System.out.println("pi is "+pi);

// Characters  Символы
     // ASCII- American Standard Code for Information Interchange

      char ch1 = 'a';
      char ch2 ='A';

      char c1,c2,c3;

      c1 = 65;
      c2 ='B';
      c3 = 67;

      System.out.println("The characters are: "+c1+c2+c3);

      char c = 'A';
      System.out.println("the value of c is "+c);

      c++;

      System.out.println("After incrementing: "+c);
      











    }



}
