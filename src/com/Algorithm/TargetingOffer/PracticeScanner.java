package com.Algorithm.TargetingOffer;

import java.util.Scanner;

public class PracticeScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String next = scanner.nextLine();
            System.out.println(next);
            if(next.equals("quit")){
                break;
            }
        }
    }
}
