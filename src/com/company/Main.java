package com.company;

import javax.swing.*;
import java.awt.FlowLayout;
import java.util.Random;
import java.util.Scanner;

public class Main {
    JButton myButton = new JButton();
    JFrame myFrame = new JFrame();
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
                int userNum = scan.nextInt();
                //varianti otveta
                if (myNum == userNum) {
                    System.out.println(" Победа!");
                    userLost = false;
                    break;
                } else if
                (myNum < userNum)
                    System.out.println(" myNum < userNum");
                else {
                    System.out.println(" myNum > userNum");
                }
            }
            if (userLost) {
                System.out.println("Проиграл!");
            }
            //vopros na prodolzenie igri

            System.out.println(" Ещё раз? ");
            System.out.println(" Y ? " + " N ? ");
            answer = scan.next();
        } while (answer.equals("Y"));
        /*do {
            System.out.println("Пока, очень жаль!");
            break;
        } while (answer.equals("N"));*/
        if (answer.equals("N")) {
            System.out.println("Очень жаль");
        } else {
            System.out.println("Ошибочка");
        }
    }
}




