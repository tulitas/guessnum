package com.company;


import java.util.*;

public class Main {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();


    public static void main(String[] args) {


        int userScore = 0;
        int myScore = 0;

        String playername;
        String answer;
        //na4alo cikla, kotorij budet povtorjatsa
        do {
            System.out.println("Как тебя зовут?");
            playername = scan.next();
            Scanner in = new Scanner(System.in);
            System.out.println("Привет " + playername);
            long t1 = System.currentTimeMillis();
            //generiruet slu4ainoe 4islo
            System.out.println("Введи число!");
            int myNum = rand.nextInt(100) + 1;
            //esli zakomentit` sled stroku, 4islo ne vidno
            //System.out.println(myNum);
            boolean userLost = true;
            //kol-vo popitok
            for (int i = 1; i < 10; i++) {
                System.out.println("Попытка #" + i);
                //sprasivaem 4islo
                int userNum = askNum();

                //varianti otveta

                if (myNum == userNum) {
                    userScore += 1;

                    System.out.println(" Победа!");
                    long t2 = System.currentTimeMillis();
                    long t = (t2 - t1) / 1000;


                    userLost = false;
                    //sohranjaem rezultat
                    GameResult r = new GameResult();
                    r.name = playername;
                    r.triesCount = i;
                    r.timetries = t;
                    results.add(r);
                    break;
                } else if (myNum < userNum) {
                    System.out.println(" Моё число < " + playername);
                } else {
                    System.out.println(" Моё число > " + playername);
                }
            }
            if (userLost) {
                myScore += 1;
                System.out.println("Проиграл!");

            }


            //vopros na prodolzenie igri


            System.out.println(playername + " " + userScore + " Мой счёт " + myScore);


            System.out.println(" Ещё раз ? y / n ");
            answer = askYN();


        } while (answer.equals("y"));
        //pokazivaem rezultat, sozdajom metod
        showResults();
        System.out.println("Пока! " + playername);
    }

    //pokazivaem rezultat
    private static void showResults() {
        for (GameResult r : results) {
            System.out.println(r.name + " -> " + r.triesCount + " sek " + r.timetries);
        }
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








