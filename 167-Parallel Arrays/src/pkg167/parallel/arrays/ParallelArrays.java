/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg167.parallel.arrays;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author nettariana
 */
public class ParallelArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String filename = args[0];
        String[] names = new String[80];
        int[] scores = new int[80];
        readPlayerData(names, scores, filename);
        sortPlayersInDecreasingorder(scores, names);
        printToConsole(names, scores);
        System.out.println("The average player score is: " + averageScores(scores));
        outputTopX(names, scores, 10);

    }

    public static void readPlayerData(String[] names, int[] scores, String filename) {

        try {

            Scanner scan = new Scanner(new File(filename));
            int i = 0;
            while (scan.hasNext()) {

                names[i] = scan.next();
                scores[i] = Integer.parseInt(scan.next());
                if (i != 79) {
                    scan.nextLine();
                }
                i++;
            }

        } catch (Exception e) {
            System.out.print("Something broke");

        }

    }

    public static void printToConsole(String[] names, int[] scores) {
        String format = "%1$-10s\t|\t%2$-10s\n";
        System.out.format(format, "Player Name", "High Score");
        System.out.println("-----------------------------------");

        String format2 = "%1$-10s\t\t%2$-10s\n";

        for (int i = 0; i < names.length; i++) {
            System.out.format(format2, names[i], scores[i]);
        }
        System.out.println();


    }
    
    public static double averageScores(int [] scores){
        double average = 0.0;
        
        for (int i = 0; i < scores.length; i++){
        
            average += scores[i];
        }
        
        average = average/scores.length;
        return average;
        
    }
    
    public static void sortPlayersInDecreasingorder(int [] scores, String [] names){
        for (int i = 0; i < scores.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < scores.length; j++)
                if (scores[j] > scores[index]) 
                    index = j;
      
            int largestNumber = scores[index];  
            String playerName = names[index];
            scores[index] = scores[i];
            names[index] = names[i];
            scores[i] = largestNumber;
            names[i] = playerName;
        }
    }
    
    public static void outputTopX(String[] names, int[] scores, int topX) {
        System.out.println();
        String format = "%1$-10s\t|\t%2$-10s\n";
        System.out.format(format, "Player Name", "High Score");
        System.out.println("-----------------------------------");

        String format2 = "%1$-10s\t\t%2$-10s\n";

        for (int i = 0; i < topX; i++) {
            System.out.format(format2, names[i], scores[i]);
        }


    }
}
