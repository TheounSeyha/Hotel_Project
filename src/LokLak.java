//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Frame;
import java.util.Random;
import java.util.Scanner;

public class LokLak extends Frame {
    public LokLak() {
    }

    public static void main(String[] args) {
        int user;
        int  money ;
        int usedMoney = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your money($): ");
        money = scanner.nextInt();

        while(usedMoney != 0) {
            Random random = new Random();
            int answer = random.nextInt(1, 7);
            System.out.println("Your money: " + money + "$");
            System.out.println("Enter your  money that you want to use or Enter 0 to exit : ");
            usedMoney = scanner.nextInt();
            System.out.print("Enter number between 1 and 6 : ");
             user = scanner.nextInt();
            if (user == 7) {
                System.out.println("Thank you!");
            } else {
                if (user == answer) {
                    System.out.println("You win!");
                    usedMoney *= 4;
                    money += usedMoney;
                } else {
                    System.out.println("You lose!");
                    money -= usedMoney;
                }

                System.out.println("The true number is : " + answer);
            }
        }

    }
}
