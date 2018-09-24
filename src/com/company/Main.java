package com.company;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {


    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();


    public static void main(String[] args) {
        loadResults();


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
            System.out.println(myNum);
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
                    long t = t2 - t1;


                    userLost = false;
                    //sohranjaem rezultat
                    GameResult r = new GameResult();
                    r.name = playername;
                    r.triesCount = i;
                    r.timetries = t;
                    results.add(r);
                    //sortiruem rezultat v faile
                    results.sort(Comparator.comparingInt(r0 -> r0.triesCount));
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
        saveResults();
        System.out.println("Пока! " + playername);
    }

    private static void loadResults() {
        //vivodim tablicu recordov pered igroj
        File file = new File("Top_scores.txt");
        try (Scanner in = new Scanner(file)) {

            while (in.hasNext()) {
                GameResult result = new GameResult();
                result.name = in.next();
                result.triesCount = in.nextInt();
                result.timetries = in.nextLong();
                results.add(result);
            }

        } catch (IOException e) {
            System.out.println("Cannnot load from file");
        }
    }

    private static void saveResults() {
        //sozdajom fail sohranenija
        File file = new File("Top_scores.txt");
        try (PrintWriter out = new PrintWriter(file)) {

            for (GameResult r : results) {
                out.printf("%s %d %d\n", r.name, r.triesCount, r.timetries);
                String Str = r.name;


            }
        } catch (IOException e) {
            System.out.println("Cannot save file");
        }

    }

    //    //pokazivaem rezultat
//    private static void showResults() {
//        //vivodit tolko 5 rezulttov i ispravljaet esli ih <5
//        int count = Math.min(5, results.size());
//        for (int i = 0; i < count; i++) {
//            GameResult r = results.get(i);
//
//            System.out.printf("%s %d %.2f sek\n", r.name, r.triesCount, r.timetries / 1000.0);
//        }
//    }
    //pokazivaem rezultat samij prostoj i korotkij metod
    private static void showResults() {
        //vivodit tolko 5 rezulttov i ispravljaet esli ih <5, sortiruem po popitkam i vremeni
        results.stream()
                .sorted(Comparator.<GameResult>comparingInt(r -> r.triesCount)
                        .thenComparingLong(r -> r.timetries))
                .limit(5)
                .forEach(r -> {
                    System.out.printf("%s %d %.2f sek\n", r.name,
                            r.triesCount, r.timetries / 1000.0);
//int str = r.name.length();



                    int str = r.name.length();
                    for (Integer i: str) {
                        if(i < min);
                        i = min;
                        if (i > max);
                        i = max;}


                    //toze neponjatno 4to s stolbikami
                   // String max = Collections.max(r.name, Comparator.comparing(s -> s.lenght()));

                    //pitalsja virovnit` stolbiki v txt faile

//                    int index = 0;
//                    for (int i = 0; i < r.name.length(); i++) {
//                        if (r.name.length() > str) {
//                            str = r.name.length();
//                            index = i;
//                        }
//                    }
//System.out.println(index);

                });
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








