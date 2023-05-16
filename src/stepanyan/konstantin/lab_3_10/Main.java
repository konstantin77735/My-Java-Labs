import java.util.ArrayList;import java.util.Arrays;import java.util.List;import java.util.Scanner;

class OlympiadResult {
    //Приватные переменные
    private String surname;
    private int schoolNumber;
    private int grade;
    private int place;

    //Конструткоры:
    public OlympiadResult(String surname, int schoolNumber, int grade, int place) {
        this.surname = surname;
        this.schoolNumber = schoolNumber;
        this.grade = grade;
        this.place = place;
    }

    //Конструктор для маленького ответа:
    public OlympiadResult(String surname, int place) {
        this.surname = surname;
        this.place = place;
        this.schoolNumber = 0;
        this.grade = 0;
    }

    //Геттеры:
    public String getSurname() {return surname;}
    public int getSchoolNumber() { return schoolNumber;}
    public int getGrade() {return grade;}
    public int getPlace() {return place;}

    //Сеттеры
    public void setSurname(String surname) {this.surname = surname;}
    public void setSchoolNumber(int schoolNumber) {this.schoolNumber = schoolNumber;}
    public void setGrade(int grade) {this.grade = grade;}
    public void setPlace(int place) {this.place = place;}
    
    //Переопределение toString
    public String toString() {
        return String.format("Фамилия: %s\tШкола: %d\tКласс: %d\tМесто: %d",
            surname, schoolNumber, grade, place);
    }
    
}

public class Main {

    static List<OlympiadResult> resultList = new ArrayList<>(Arrays.asList(
            new OlympiadResult("Иванов", 1, 5, 1),
            new OlympiadResult("Петров", 2, 4, 2),
            new OlympiadResult("Сидоров", 3, 3, 3),
            new OlympiadResult("Козлов", 4, 2, 4),
            new OlympiadResult("Федоров", 5, 1, 5)));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Добавить ученика");
            System.out.println("2. Оставить как есть");
            System.out.println("X. Введите X чтобы выйти из меню.");

            String c = scanner.next();
            switch (c) {
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
                    method_A(resultList);
                    method_B(resultList);
                    method_C(resultList);
                    break;

                case "X":
                case "x":
                    scanner.close();
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
                    break;
            }

            if (c.equalsIgnoreCase("X")) {
                break;
            }
        }


    }

    public static void method_A(List<OlympiadResult> resultList) {
        List<Integer> winningSchools = new ArrayList<>();
        for (OlympiadResult result : resultList) {
            if (result.getPlace() <= 3 && !winningSchools.contains(result.getSchoolNumber())) {
                winningSchools.add(result.getSchoolNumber());
            }
        }

        System.out.println("a) Школы, занявшие призовые места:");
        for (Integer schoolNumber : winningSchools) {
            System.out.println("Школа " + schoolNumber);
        }
        System.out.println("___________");
    }

    public static void method_B(List<OlympiadResult> resultList) {
        int maxWinners = 0;
        int schoolWithMaxWinners = 0;
        List<Integer> winningSchools = new ArrayList<>();
        for (OlympiadResult result : resultList) {
            if (result.getPlace() <= 3 && !winningSchools.contains(result.getSchoolNumber())) {
                winningSchools.add(result.getSchoolNumber());
            }
        }

        for (int school : winningSchools) {
            int count = 0;
            for (OlympiadResult result : resultList) {
                if (result.getSchoolNumber() == school && result.getPlace() <= 3) {
                    count++;
                }
            }
            if (count > maxWinners) {
                maxWinners = count;
                schoolWithMaxWinners = school;
            }
        }
        System.out.println("b) Школа, занявшая больше всех призовых мест:");
        System.out.println("Школа " + schoolWithMaxWinners);
        System.out.println("___________");
    }

    public static void method_C(List<OlympiadResult> resultList) {
        System.out.println("c) Ученики, занявшие первое место:");
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
