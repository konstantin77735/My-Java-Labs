/**
* @author Степанян К. А.
*/
package stepanyan.konstantin.lab_4_11;

import java.text.Collator;
import java.util.*;

/**
* Класс OlympiadResult - базовый класс для объектов результата Олимпиады
*/class OlympiadResult {
    /**Поле для фамилии ученика*/ 
    private String surname;
    /**Поле для номера школы ученика*/ 
    private int schoolNumber;
    /**Поле для оценки*/ 
    private int grade;
    /**Поле для места*/ 
    private int place;

    /** Конструктор для создания "нового ученика". Принимает параметры: 
     * @param surname - принимает фамилию ученика
     * @param schoolNumber - принимает номер школы
     * @param grade - принимает оценку
     * @param place - принимает занятое место 
     
     И присваивает их экземпляру класса. например: this.surname = surname
    */
    public OlympiadResult(String surname, int schoolNumber, int grade, int place) {
        this.surname = surname;
        this.schoolNumber = schoolNumber;
        this.grade = grade;
        this.place = place;
    }

    /** Конструктор для создания "нового ученика" ТОЛЬКО по фамилии и занятому месту
     * @param surname - принимает фамилию ученика
     * @param place - принимает занятое место 
    */
    public OlympiadResult(String surname, int place) {
        this.surname = surname;
        this.place = place;
        this.schoolNumber = 0;
        this.grade = 0;
    }


    /** Геттер возвращает фамилию ученика */
    public String getSurname() {return surname;}
    /** Возвращает номер школы */
    public int getSchoolNumber() { return schoolNumber;}
    /** Возвращает оценку */
    public int getGrade() {return grade;}
    /** Возвращает занятое место */
    public int getPlace() {return place;}

    /** Сеттер принимает параметр:
     * @param surname - фамилия ученика 
     * и присваивает текущему экземпляру Класса
     */
    public void setSurname(String surname) {this.surname = surname;}

    /** Принимает номер школы и присваивает текущему экземпляру класса */
    public void setSchoolNumber(int schoolNumber) {this.schoolNumber = schoolNumber;}

    /** Принимает оценку и присваивает текущему экземпляру класса */
    public void setGrade(int grade) {this.grade = grade;}

    /** Принимает занятое место и присваивает текущему экземпляру класса */
    public void setPlace(int place) {this.place = place;}

    //Переопределение toString
    /** Переопределяет метод toString и 
     * @return String.format("Фамилия: %s\tШкола: %d\tКласс: %d\tМесто: %d",
                surname, schoolNumber, grade, place) - возвращает форматированные данные ученика: фамилия, номер школы, оценка, место
    */
    public String toString() {
        return String.format("Фамилия: %s\tШкола: %d\tКласс: %d\tМесто: %d",
                surname, schoolNumber, grade, place);
    }

}

/**
 * Основной класс Main позволяет добавлять результаты олимпиады учеников и выполнять некоторые аналитические функции на основе этих результатов.
 */
public class Main {
    /** Список учеников и их результатов */
    static List<OlympiadResult> resultList = new ArrayList<>(Arrays.asList(
            new OlympiadResult("Иванов", 1, 5, 1),
            new OlympiadResult("Петров", 2, 4, 2),
            new OlympiadResult("Сидоров", 3, 3, 3),
            new OlympiadResult("Козлов", 4, 2, 4),
            new OlympiadResult("Федоров", 5, 1, 5)));

    
    /*Основной метод класса Main */
    public static void main(String[] args) {
        /** Инициализация "сканера". Это нужно чтобы пользователь мог вводить свои ответы в терминал. */
        Scanner scanner = new Scanner(System.in);
        boolean exitMenu = false;

        /** Пишет меню в терминале, которое работает пока true. При нажатии X меняется на false */
        while (exitMenu==false) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Добавить ученика");
            System.out.println("2. Оставить как есть");
            System.out.println("X. Введите X чтобы выйти из меню.");

            /** Переменная хранит вводимые пользователем ответы */
            String userAnswer = scanner.next();
            switch (userAnswer) {
                /** Если пользователь выбрал первый пункт меню "1. Добавить ученика" 
                 * то сначала он вводит сколько учеников он добавляет,
                 * затем он пишет для каждого из них фамилию, номер школы, оценку, место.
                 * После этого новые ученики добавляют в список учеников.
                 * 
                 * @param resultList - список учеников (с добавленными учениками)
                 * method_A - выводит список школ, занявших призовые места; 
                 * method_B - определяет какая из школ заняла больше всех призовых мест; 
                 * method_C - упорядочивает учеников, занявших первые места, и выводит их;
                */
                case "1":
                    System.out.println("Введите количество сколько учеников вы добавите:");
                    int studentCount = scanner.nextInt();
                    for(int i = 0; i < studentCount; i++){
                        System.out.println("Введите данные ученика " + (i+1) + ":");
                        System.out.println("Введите фамилию ученика:");
                        String name = scanner.next();
                        System.out.println("Введите номер школы:");
                        int schoolNumber = scanner.nextInt();
                        System.out.println("Введите оценку:");
                        int grade = scanner.nextInt();
                        System.out.println("Введите место:");
                        int place = scanner.nextInt();

                        resultList.add(new OlympiadResult(name, schoolNumber, grade, place));
                        System.out.println("___________________");
                    }

                    method_A(resultList);
                    method_B(resultList);
                    method_C(resultList);
                    break;

                case "2":
                /** Если пользователь выбрал второй пункт меню "2. Оставить как есть",
                 * то вызывается эти методы. В данном случае 
                 * @param resultList - равен изначальному списку учеников
                 */
                    method_A(resultList);
                    method_B(resultList);
                    method_C(resultList);
                    break;

                case "X":
                case "x":
                /** Если пользователь выбрал пункт меню: "X. Введите X чтобы выйти из меню.",
                 * то меню закрывается, т.к. true меняется на false
                 */
                    scanner.close();
                    exitMenu=true;
                    break;

                default:
                /** Если пользователь ввёл символ, не соответствующий ни одному из пунктов меню
                 * то ему даётся другая попытка выбрать пункт меню
                 */
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
                    break;
            } 
        }
    }

    /**
     * Метод выводит список школ, занявших призовые места
     * @param resultList - список учеников
     */
    public static void method_A(List<OlympiadResult> resultList) {
        /** Хранит школы, занявшие призовые места (с первого по третье) */
        List<Integer> winningSchools = new ArrayList<>();

        /** Цикл проходит по всем элементам списка resultList
         * и добавляет в winningSchools всех учеников (включая их школы и т.д.) занявших с первое по третье место
        */
        for (OlympiadResult result : resultList) {
            if (result.getPlace() <= 3 && !winningSchools.contains(result.getSchoolNumber())) {
                winningSchools.add(result.getSchoolNumber());
            }
        }

        /** Выводит список школ занявших призовые места */
        System.out.println("a) Школы, занявшие призовые места:");
        for (Integer schoolNumber : winningSchools) {
            System.out.println("Школа " + schoolNumber);
        }
        System.out.println("___________");
    }

    /**
     * Метод определяет какая из школ заняла больше всех призовых мест;
     * @param resultList - список учеников
     */
    public static void method_B(List<OlympiadResult> resultList) {
        /** хранит значение, равное наибольшему кол-ву финалистов (без привязки к школе) ↓*/
        int maxWinnersGlobal = 0;
        /** хранит номер этой школы, в которой больше всего финалистов ↓*/
        int schoolWithMaxWinners = 0;
        /** Хранит школы, занявшие призовые места */
        List<Integer> winningSchools = new ArrayList<>();

        /** Находит школы, занявшие призовые места */
        for (OlympiadResult result : resultList) {
            if (result.getPlace() <= 3 && !winningSchools.contains(result.getSchoolNumber())) {
                winningSchools.add(result.getSchoolNumber());
            }
        }

        /** В этом цикле school - это каждая из школ-финалистов (winningSchools) */
        for (int school : winningSchools) {
            /** сколько учеников-финалистов в school*/
            int countWinnersInSchool = 0;

            /** Проходит по списку resultList (спиоск всех учеников) */
            for (OlympiadResult result : resultList) {
                /** Эти переменные хранят соответствующие поля каждого ученика*/
                int schoolNumber = result.getSchoolNumber();
                int place = result.getPlace();

                /** Если эта школа есть в списке финалистов
                 * И один из её учеников занял одно из первых трёх мест
                 * то список финалистов этой школы увеличивается на 1
                 */
                if (school == schoolNumber  && place <= 3) {
                    countWinnersInSchool++;
                }
            }

            /** countWinnersInSchool - число финалистов в конкрентной школе (school)
             * maxWinnersGlobal - числов финалистов без привязки к школе (изначально = 0)
             * 
             * Если в какой-то школе финалистов больше, чем 0, то в maxWinnersGlobal присваивается это новое число
             * и в школу с большИм числом финалистов schoolWithMaxWinners присваивается эта школа (school)
             */
            if (countWinnersInSchool > maxWinnersGlobal) {
                maxWinnersGlobal = countWinnersInSchool;
                schoolWithMaxWinners = school;
            }
        }

        /** Выводит школу занявшую больше всех призовых мест */
        System.out.println("b) Школа, занявшая больше всех призовых мест:");
        System.out.println("Школа " + schoolWithMaxWinners);
        System.out.println("___________");
    }

    /**
     * Упорядочивает учеников, занявших первые места, по алфавиту по фамилии
     * и выводит их
     * @param resultList - список всех учеников
     */
    public static void method_C(List<OlympiadResult> resultList) {
        System.out.println("c) Ученики, занявшие первое место:");

        /** Упорядочивает список учеников по алфавиту по фамилии */
        resultList.sort(Comparator.comparing(OlympiadResult::getSurname, Collator.getInstance(new Locale("ru"))));

        /** проходит по всем ученикам, выбирает только занявших 1 место и выводит этот список */
        for (OlympiadResult result : resultList) {
            if (result.getPlace() == 1) {
                System.out.println("Фамилия: " + result.getSurname());
                System.out.println("Школа: " + result.getSchoolNumber());
                System.out.println("Класс: " + result.getGrade());
                System.out.println("Место: " + result.getPlace());
                System.out.println("___________");
            }
        }
    }
}
