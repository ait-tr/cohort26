public class Main {
    //The if Statement
    public static void main(String[] args) {


   /*
    1. if

    */
        int a = 2;
        int b = 1;

        int sum = a + b;
        if ( a == b ) {
            sum = sum * 2;
        }

        System.out.println(sum);
       //2. if-else
     if (a>b) {
         System.out.println("a>b");
    }else {
         System.out.println("a<=b");}

     int i=10,j=30,k=116,x,y=3;
     int x1;
     int y1 = 2;
//3. Nested ifs
        if (i == 10){

            if(j<40)x=y;
            if (k>115) x1=y1;
            else x = 9;
        }
        else x = y1;

  //4. if-else-if ladder

    /*
    if(condition)
        statement;
    else if(condition)
        statement
     else if(condition)
        statement
        .
        .
        .
     else
        statement
     */

        int num = 1;

        if ( num == 1) {
            System.out.println("num is one");
            System.out.println("num is one");
        }
        else if (num == 2) {
            System.out.println("num is two");
        }
        else if ( num == 3) {
            System.out.println("num is three");
        }
        else if (num == 4) {
            System.out.println("num is four");
        }
        else {
            System.out.println(1+2);
            System.out.println("num is not between 1 and 4");
        }



        System.out.println("if simply if");

        num = 1;

        if ( num == 1) {
            System.out.println("num is one");
            System.out.println("num is one");
        }
        if (num == 2) {
            System.out.println("num is two");
        }
        if ( num == 3) {
            System.out.println("num is three");
        }
        if (num == 4) {
            System.out.println("num is four");
        }
        else {
            System.out.println("num is not between 1 and 4");
        }

        //Logical operators
        /*
        & AND  &&
        | OR   ||
        ^ XOR
        ! NOT

         p       q       p&q       p|q     p^q     !p
        ------------------------------------------------
        False  False    False      False   False    True

        True   False    False      True    True     False

        False  True     False      True    True     True

        True   True     True       True    False    False

         */
        boolean p =false;
        boolean q = true;
        boolean result = p&q;

       boolean b1 = true;
       boolean b2 = false;

       if (b1 & b2) {
           System.out.println("this won't be typed");}

       if ( !(b1&b2)){
           System.out.println("!(b1&b2) is true");
       }


       if( b1 |b2) {
           System.out.println("b1|b2 is true");
       }

       if(b1^b2){
           System.out.println("b1^b2 is true");
       }

       int n = 10;
     //  int d = 5;
     int d = 3;
       if(d != 0 && (n%d) == 0)
       {
           System.out.println(" n can be divided by d without remainder");
       }


   //    int number = 5/0;
   //     System.out.println(number);

      //  if(d != 0 && (n%d)==0){
        if(d != 0 & (n%d)==0){
            System.out.println(" n can be divided by d without remainder");
        }
    //Operator Precedence  приоритет

      /* самый высокий
        ++(postfix)  --
        ++(prefix)  --    !
        *   /  %
        +  -
        >    >=   <  <=
        ==  !=
        &
        ^
        |
        &&
        ||
        =
        самый низкий
       */
        /*
        Написать программу , определяющую является ли год високосным.
        Для того, чтобы быть високосным год должен:
         делится без остатка на 4 и либо не должен делится без остатка  на 100
         либо если он делится на 100, то он должен делится также на 400.



         */


    }


}
