package com.company;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        String answer;
        //na4alo cikla, kotorij budet povtorjatsa
        do {
            //generiruet slu4ainoe 4islo
            int myNum = rand.nextInt(100) + 1;
            //esli zakomentit` sled stroku, 4islo ne vidno
            //System.out.println(myNum);
            boolean userLost = true;
            //kol-vo popitok
            for (int i = 1; i < 3; i++) {
                System.out.println("Попытка #" + i);
                //sprasivaem 4islo
                int userNum = askNum();
                //varianti otveta
                if (myNum == userNum) {
                    System.out.println(" Победа!");
                    userLost = false;
                    break;
                } else if (myNum < userNum) {
                    System.out.println(" Моё число < Твоё число");
                } else {
                    System.out.println(" Моё число > Твоё число");
                }
            }
            if (userLost) {
                System.out.println("Проиграл!");
            }
            //vopros na prodolzenie igri

            System.out.println(" Ещё раз ? y / n ");
            answer = askYN();
        } while (answer.equals("y"));
        System.out.println("Пока!");
    }

    //otdelnij metod, kotorij rabotaet s osnovnim
    //esli varian otveta ne "n" i ne "y"
    static String askYN() {
        String answer;
        do {
            answer = scan.next();
            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("Ошибка! y или n");
                continue;
            } else {
                return answer;
            }
        } while (true);


    }

    //uslovie vvoda 4isla ot 1do 100, esli vvedeno ne 4islo
    static int askNum() {
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Это не число!");
                //scan.next prerivaet cikl "eto ne 4islo"
                scan.next();
                continue;
            }
            if (answer < 1 || answer > 100) {
                System.out.println("Только от 1 до 100!");
            } else {
                return answer;
            }
        } while (true);
    }

}







