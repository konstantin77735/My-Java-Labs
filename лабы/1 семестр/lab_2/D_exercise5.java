package stepanyan.konstantin.lab_2;
import java.util.Scanner;

public class D_exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int dayTicket = 30; //цена дневного билета (к.)
        final int eveningTicket = 60; //цена вечернего билета (к.)

        System.out.println("Добро пожаловать в Кинотеатр Терек!"+"\n"
                +"Билет на дневной сеанс стоит: "+dayTicket+" к. \n"
                +"Билет на вечерний сеанс стоит: "+eveningTicket+" к. \n"
                +"Какой сеанс вы выбираете?"+"\n");
        String ticketAnswer = scanner.nextLine(); //выбранный сеанс;

        System.out.println("Сколько билетов вы хотите купить?");
        int ticketAmount = scanner.nextInt(); //выбранное кол-во билетов

        int coeff=0;
        switch (ticketAnswer.toLowerCase()) {
            case "дневной":
                coeff = dayTicket;
                break;
            case "вечерний":
                coeff = eveningTicket;
                break;
        }

        int price = ticketAmount * coeff; //цена билетов
        System.out.println("С Вас: "+price+" к. \n"
                +"Введите сумму (в копейках):");
        int payment = scanner.nextInt(); //введённые деньги

        //Если внесли денег меньше цены, то денег не хватает ↓
        if(payment<price){
            int diff = price-payment;
            System.out.println("Вы внесли недостаточно средств. Не хватает: "+diff+"к. ");
            return;
        }

        //Если внесли денег больше цены, то вернуть сдачу ↓
        if(payment>price){
            int change = payment - price; //сдача
            System.out.println("Возьмите вашу сдачу: "+change+" к. ");
        }

        System.out.println("Спасибо за покупку!");
    }
}
