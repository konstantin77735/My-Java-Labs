package stepanyan.konstantin.lab_1_8;

import java.io.*; import java.text.SimpleDateFormat; import java.time.LocalDate;
import java.time.DayOfWeek; import java.time.LocalTime; import java.time.LocalDateTime;
import java.time.format.DateTimeParseException; import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit; import java.util.Locale;
import java.util.Scanner; import java.time.Period;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class Time {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню: ");

            System.out.println(
                    "a. Метод возвращает объект LocalDate из строковой даты"+"\n"
                            +"b. Метод возвращает объект LocalTime из строкового времени"+"\n"
                            +"c. Метод возвращает объект LocalDateTime из строкового даты и времени"+"\n"
                            +"d. Метод принимает дату в одном из трех форматов:"
                            +" дата, время или дата и время И выводит по ним всю информацию"+"\n"
                            +"e. Метод определяет когда наступит (или уже наступил) ваш День рождения относительно текущей даты"+"\n"
                            +"f. Метод выбирает из строки с перечисленными датами ВСЕ выходные дни"+"\n"
                            +"g. Метод определяет сколько дней осталось до Нового года."+"\n"
                            +"h. Метод считает сколько дней осталось до Вашего Дня рождения"+"\n"
                            +"i. Метод определяет день недели, соответствующий переданной в него дате. "+"\n"
                            +"j. Метод определяет возраст  в днях и месяцах"+"\n"
                            +"k. Метод выводит на экран дни недели, на которые выпадает ваш День рождения "
                            + "в ближайшие 10 лет."+"\n"
                            +"L. Метод принимает день (в формате: JANUARY 1 2013) "
                            +"и если день нечётный возвращает true, если чётный - false"+"\n"
                            +"X. Введите X чтобы выйти из меню."+"\n"
            );

            System.out.println("Выберете пункт меню:");

            String c = scanner.next();
            switch (c) {
                case "a": System.out.println("a. Введите дату в формате: yy-mm-dd");
                    String dateInput = scanner.next().toString();
                    LocalDate date = getDate(dateInput);

                    System.out.println("Класс: "+ date.getClass().getSimpleName());
                    printDate(date.toString());

                    returnToMenu();
                    break;

                case "b": System.out.println("b. Введите время в формате: hh:mm:ss");
                    String timeInput = scanner.next().toString();
                    LocalTime time = getTime(timeInput);

                    System.out.println("Класс: "+ time.getClass().getSimpleName());
                    printDate(timeInput.toString());

                    returnToMenu();
                    break;

                case "c": System.out.println("c. Введите дату и время в формате: yy-mm-ddThh:mm:ss");
                    String dateTimeString = scanner.next().toString();
                    LocalDateTime dateTime = getDateTime(dateTimeString);

                    System.out.println("Класс: " + dateTime.getClass().getSimpleName());
                    printDate(dateTime.toString());

                    returnToMenu();
                    break;

                case "d": System.out.println("d. Метод prindDate(String _date). _date: yy-mm-dd или hh:mm:ss или yy-mm-ddThh:mm:ss");
                    String _date = scanner.next().toString();
                    printDate(_date);

                    returnToMenu();
                    break;

                case "e": System.out.println("e. Введите День рождения: yy-mm-dd");
                    String birthday = scanner.next();
                    getBirthday(birthday);

                    returnToMenu();
                    break;

                case "g": System.out.println("g. Узнать сколько дней осталось до Нового Года:");
                    getNewYear();
                    returnToMenu();
                    break;

                case "h": System.out.println("h. Посчитать сколько дней ОСТАЛОСЬ ДО Вашего Дня Рождения. Введите дату в формате: yy-mm-dd ");
                    String _birthday = scanner.next();

                    getDaysBeforeBirthday(_birthday);

                    returnToMenu();
                    break;

                case "f": System.out.println("f. Введите несколько дат в формате (через пробел): yy-mm-dd yy-mm-dd ... yy-mm-dd");
                    String _dates = scanner.nextLine().toString(); //nextLine - видит символы после пробела

                    BufferedReader input = new BufferedReader ( new InputStreamReader ( System.in ) );
                    String dates = input.readLine();
                    getHolidays(dates);

                    returnToMenu();
                    break;

                case "i": System.out.println("i. Введите день (получить день недели): yy-mm-dd");
                    String day = scanner.next();
                    getDayOfWeek(day);
                    System.out.println("___________");

                    returnToMenu();
                    break;

                case "j": System.out.println("j. Определить возраст. Введите дату рождения: yy-mm-dd");
                    String birthdayDate = scanner.next();
                    getAge(birthdayDate);

                    returnToMenu();
                    break;

                case "k": System.out.println("k. Ваш День рождения в ближайшие 10 лет. Введите дату: yy-mm-dd");
                    String birthdayNext10Years = scanner.next();
                    getBirthdayOfNext10Years  (birthdayNext10Years);

                    returnToMenu();
                    break;



                case "l": case "L": System.out.println("L. Узнать какой по счёту день в году: чётный или нечётный"+"\n"
                        +"Введите дату в формате (например: January 1 2000)");

                    BufferedReader indexOfDay = new BufferedReader ( new InputStreamReader ( System.in ) );
                    String indexOfDayString = indexOfDay.readLine();
                    indexOfDayString = indexOfDayString.substring(0,1).toUpperCase() + indexOfDayString.substring(1).toLowerCase();
                    System.out.println(indexOfDayString);

                    isDateOdd(indexOfDayString);
                    System.out.println("___________");

                    returnToMenu();
                    break;

                case "x": case "X":
                    return;
            }
        }

    }

    public static Boolean returnToMenu(){
        System.out.println("Чтобы вернуться в меню введите X: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        switch(input) {
            case "X": case "x":
                return false;
        }
        return true;
    }

    public static LocalDate getDate(String _date) {
        LocalDate _localDate = LocalDate.parse(_date);

        return _localDate;
    }

    public static LocalTime getTime(String _time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm:ss"); //H - (0-23)
        LocalTime _localTime = LocalTime.parse(_time, formatter);

        return _localTime;
    }

    public static LocalDateTime getDateTime(String _dateTime) {
        LocalDateTime _localDateTime = LocalDateTime.parse(_dateTime);

        return _localDateTime;
    }

    public static void printDate(String date) {
        //Date:
        if (date.contains("-") && !date.contains("T")) {
            LocalDate _localDate = getDate(date);

            System.out.println("День: " + _localDate.toString() + "\n"
                    + "День месяца (число): " + _localDate.getDayOfMonth() + "\n"
                    + "День недели: " + _localDate.getDayOfWeek() + "\n"
                    + "День по счёту (за год): " + _localDate.getDayOfYear() + "\n"
                    + "Месяц: " + _localDate.getMonth() + "\n"
                    + "Месяц по счёту: " + _localDate.getMonthValue() + "\n"
                    + "Год: " + _localDate.getYear() + "\n" + "___________");
        } else {
            //Time:
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
            if (!date.contains("T")) {
                LocalTime _localTime = getTime(date);
                String timeUS = _localTime.format(dateTimeFormatter);

                System.out.println("Время: "+_localTime.toString()+"\n"
                        + "Часы: " + _localTime.getHour() + "\n"
                        + "Минуты: " + _localTime.getMinute() + "\n"
                        + "Секунды: " + _localTime.getSecond() + "\n"
                        + "Наносекунды: " + _localTime.getNano() + "\n"
                        + "Часы в формате US: " + timeUS + "\n" + "______________");
            }

            //DateTime (yy-mm-ddThh:mm:ss)
            else {
                //LocalTime _localTime = getTime(  date.substring(11)  ); //аргумент DateTime (после T)
                LocalDateTime _localDateTime = getDateTime(date);

                String timeUS = _localDateTime.format(dateTimeFormatter);

                System.out.println("День и время: " + _localDateTime.toString() + "\n"
                        + "День месяца (число): " + _localDateTime.getDayOfMonth() + "\n"
                        + "День недели: " + _localDateTime.getDayOfWeek() + "\n"
                        + "День по счёту (за год): " + _localDateTime.getDayOfYear() + "\n"
                        + "Месяц: " + _localDateTime.getMonth() + "\n"
                        + "Месяц по счёту: " + _localDateTime.getMonthValue() + "\n"
                        + "Год: " + _localDateTime.getYear() + "\n"
                        + "Время: " + _localDateTime.toString() + "\n"
                        + "Часы: " + _localDateTime.getHour() + "\n"
                        + "Минуты: " + _localDateTime.getMinute() + "\n"
                        + "Секунды: " + _localDateTime.getSecond() + "\n"
                        + "Наносекунды: " + _localDateTime.getNano() + "\n"
                        + "Часы в формате US: " + timeUS + "\n" + "______________");
            }
        }
    }


    //Метод находит разницу между сегодняшней датой и датой в аргументе
    public static Long DaysBetweenDates(String date, String dayName) {
        LocalDate currentDate = LocalDate.now();
        LocalDate secondDate = LocalDate.parse(date);

        Long days = DAYS.between(currentDate, secondDate); //считает строго в днях
        Long months = MONTHS.between(currentDate, secondDate); //считает строго в месяцах

        Period period = Period.between(currentDate, secondDate);
        int _years = Math.abs(period.getYears()); //сколько лет прошло
        int _months = Math.abs(period.getMonths()); //месяцев (годы не входят; если дней < чем в месяце тоже не входит)
        int _days = Math.abs(period.getDays()); //дней (годы и месяцы не входят, только остаток "дней")

        if(dayName!="" && dayName!="Возраст"){
            if(currentDate.isBefore(secondDate)){ System.out.println("До "+dayName+" осталось ВСЕГО: "+days+" дней");}
            if(currentDate.isAfter(secondDate)){System.out.println("С "+dayName+" прошло ВСЕГО: "+Math.abs(days)+" дней");}
            System.out.println("Или же: "+_years+" лет, "+_months+" месяцев, "+_days+" дней"+"\n"+"___________");
        }
        if(dayName=="Возраст"){
            System.out.println("Возраст в днях: "+Math.abs(days)+" дней"+"\n"
                    +"Или Возраст в месяцах: "+Math.abs(months) + " месяцев, " +_days+" дней"+"\n"
                    +"Или Возраст: "+_years+ " лет, " +_months+" месяцев, "+ _days +" дней"+"\n"+"___________");
        }

        return days;
    }

    public static void getBirthday(String birthday){
        DaysBetweenDates(birthday, "Дня рождения");
    }

    public static void getHolidays(String date){
        String[] _dates = date.split(" ");

        for(int i=0; i< _dates.length; i++){
            LocalDate d = LocalDate.parse(_dates[i]);

            if(d.getDayOfWeek().toString()=="SATURDAY" || d.getDayOfWeek().toString()=="SUNDAY"){
                System.out.println(_dates[i]+" - это выходной день: "+d.getDayOfWeek().toString());
            }
        }
        System.out.println("___________");
    }

    public static void getNewYear(){
        String currentYear = String.valueOf(  LocalDate.now().getYear()  );
        String nextYear = String.valueOf(  LocalDate.now().plusYears(1).getYear() );

        String _31dec = currentYear+"-12-31";
        String _1jan = nextYear+"-01-01";

        DaysBetweenDates(_31dec, "31 декабря");
        DaysBetweenDates(_1jan, "1 января");
    }

    public static void getDayOfWeek(String date){
        LocalDate _localDate = getDate(date);
        System.out.println(date+" — это: "+_localDate.getDayOfWeek());
    }

    public static void getAge(String date){
        DaysBetweenDates(date, "Возраст");

    }

    public static void getDaysBeforeBirthday(String birthday){
        Long daysBeforeBirthday = DaysBetweenDates(birthday, "");

        if(daysBeforeBirthday<0){System.out.println("Ваш День рождения уже прошёл");}
        else{System.out.println("ДО Вашего Дня рожддения осталось: "+daysBeforeBirthday+" дней");}
        System.out.println("___________");
    }

    public static void getBirthdayOfNext10Years(String dateString){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, dtf);
        for (int i = 0; i <= 10; i++) {
            LocalDate nextDate = date.plusYears(i);
            DayOfWeek dayOfWeek = nextDate.getDayOfWeek();
            System.out.println("В " + nextDate.getYear() + " году дата:"+ nextDate+" попадает на: " + dayOfWeek);
        }
        System.out.println("___________");
    }

    //dateString в формате (MMMM dd yyyy) (FEBRUARY 26 2023)
    public static Boolean isDateOdd(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy").withLocale(Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);

        //если день нечётный
        if(date.getDayOfYear()%2!=0 ) {
            System.out.println("Дата нечётная, поэтому: "+true);
            return true;
        }

        //если день чётный
        System.out.println("Дата чётная, поэтому: "+false);
        return false;
    }

}
