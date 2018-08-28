package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //generiruet slu4ainoe 4islo
        int myNum = rand.nextInt(100) + 1;
        //esli zakomentit` sled stroku, 4islo ne vidno
        System.out.println(myNum);

        boolean userLost = true;
        for (int i = 1; i < 11; i++) {
            System.out.println("Popitka #" + i);
            //sprasivaem 4islo
            int userNum = scan.nextInt();
            //varianti otveta

            if (myNum == userNum) {
                System.out.println(" Ugadal!");
                userLost = false;
                break;
            } else if
            (myNum < userNum) {
                System.out.println(" myNum < userNum");
            } else {
                System.out.println(" myNum > userNum");

            }


        }
        if (userLost) {
            System.out.println("Proigral!");
        }
    }
}




