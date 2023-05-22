package stepanyan.konstantin.lab_7_14;
import java.util.Scanner;

class ParentClass {
    public void commonMethod() {
        System.out.println("ParentClass.commonMethod() called.");
    }
}


class ChildClass1 extends ParentClass {
    public void specificMethod() {
        System.out.println("ChildClass1.specificMethod() called.");
    }
}

class ChildClass2 extends ParentClass {
    public void specificMethod() {
        System.out.println("ChildClass2.specificMethod() called.");
    }
}

class ChildClass3 extends ParentClass {
    public void specificMethod() {
        System.out.println("ChildClass3.specificMethod() called.");
    }
}

interface MyInterface {
    void interfaceMethod();
}

class ClassImplementingInterface1 implements MyInterface {
    public void interfaceMethod() {
        System.out.println("ClassImplementingInterface1.interfaceMethod() called.");
    }
}

class ClassImplementingInterface2 implements MyInterface {
    public void interfaceMethod() {
        System.out.println("ClassImplementingInterface2.interfaceMethod() called.");
    }
}

class ClassImplementingInterface3 implements MyInterface {
    public void interfaceMethod() {
        System.out.println("ClassImplementingInterface3.interfaceMethod() called.");
    }
}




public class TestClass {
    
    /*
     * Добавить в класс TestClass метод firstTest(), в котором:
        a. Создать массив объектов родительского класса
        b. Добавить в него объекты классов-наследников
        c. Обращаться к общим методам этих классов посредством прохода по
        элементам массива
     */
    public void firstTest() {
        ParentClass[] array = new ParentClass[2]; // создание массива объектов родительского класса
        array[0] = new ChildClass1(); // добавление объектов классов-наследников в массив
        array[1] = new ChildClass2();
        
        // обращение к общим методам этих классов посредством прохода по элементам массива
        for (int i = 0; i < array.length; i++) {
            array[i].commonMethod();
            System.out.println("Вызов commonMethod() у объекта " + array[i].getClass().getSimpleName());
        }
    }



    /*
        * Добавить в класс TestClass метод secondTest(), в котором:
        a. Создать массив объектов одного из интерфейсов.
        b. Добавить в него экземпляры классов, его реализующих
        c. Вызывать методы интерфейса у элементов массива в цикле
    */
    public void secondTest() {
        MyInterface[] array = new MyInterface[2]; // создание массива объектов интерфейса
        array[0] = new ClassImplementingInterface1(); // добавление экземпляров классов, реализующих интерфейс
        array[1] = new ClassImplementingInterface2();

        // вызов методов интерфейса у элементов массива в цикле
        for (int i = 0; i < array.length; i++) {
            array[i].interfaceMethod();
            System.out.println("Вызов interfaceMethod() у объекта " + array[i].getClass().getSimpleName());
        }
    }

    /*
     * 8. Организовать в методе main() класса TestClass меню для вызова методов:
firstTest(), secondTest()
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestClass testClass = new TestClass();
        int choice;

        do {
            System.out.println("Выберите действие:");
            System.out.println("1. firstTest()");
            System.out.println("2. secondTest()");
            System.out.println("0. Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    testClass.firstTest();
                    break;
                case 2:
                    testClass.secondTest();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }


}
