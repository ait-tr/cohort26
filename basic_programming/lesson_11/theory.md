## Сравнение строк

- метод `equals(String)` сравнивает строки (строки должны польностью совпадать)
- метод `toLowerCase()` возвращает нам копию строки, где все буквы переделаны в строчные
- метод `toUpperCase()` возвращает нам копию строки, где все буквы переделаны в заглавные
- метод `equalsIgnoreCase(String)` сравнивает строки без учёта регистра
- метод `contains(String)` проверяет, есть ли в строке такая подстрока


## Почему нельзя использовать == для сравненя строк???
// Java program to understand
// why to avoid == operator

public class Test {
public static void main(String[] args)
{
String s1 = new String("HELLO");
String s2 = new String("HELLO");

		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}

## Как работает встроенный метод compareTo

// Java program to show how to compare Strings
// using library function
public class Test
{ public static void main(String[] args)
{
String s1 = "Ram";
String s2 = "Ram";
String s3 = "Shyam";
String s4 = "ABC";

		System.out.println(" Comparing strings with compareTo:");
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		System.out.println(s1.compareTo(s4));
	}
}

