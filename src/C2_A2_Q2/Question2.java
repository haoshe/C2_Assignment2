package C2_A2_Q2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

Write a program that generates 16 random lowercase letters of the alphabet (range a–z inclusive) and then writes the letters to a file.
Each letter in the file should be separated by a | symbol with four letters per line. No line should begin or end with a | symbol.
The program should also write control totals on the last 2 lines of the file as follows:

The second last line should show the letter(s) that was/were generated the most number of times. Include the number of times generated as per sample file output.

The last line should show the letter(s) that was/were generated the least number of times. Include the number of times generated as per sample file output.

Example file contents:

f|j|r|h
u|g|b|f
u|z|o|h
y|w|m|p
Generated the most number of times (2 times): f h u
Generated the least number of times (0 times): a c d e i k l n q s t v x

 */

public class Question2 {
    public static void main(String[] args) {
        // create an array list, containing all lower case letters, from a to z
        List<Character> charArray = new ArrayList<>();
        // create a hash map, for counting most and least randomly picked letters
        Map<Character, Integer> map = new HashMap<>();
        // in ASCII code table, a is 97, z is 122. the for-loop adds all lower case letters into the charArray list
        for(int i = 97; i <= 122; i++){
            // cast integer i into a character, then add it into charArray
            // everytime a loop finishes, integer i will increase its value by one, so from 97 to 122, all lower case letters will be put into the charArray
            charArray.add((char)i);
            // and put all lower case letters into the map as keys, all values set to zero.
            map.put((char)i, 0);
        }
        // this counter is for the while loop, each time a loop finishes, decrease it by 1; so loop 16 times altogether.
        int counter = 16;
        // this counter is for the number of letters being printed out. everytime a loop finishes, increase it by 1;
        // if it is not dividable by 4, the system prints out letters followed by a "|", when it is dividable by 4,
        // which means it is the 4th letter, the system then prints out the letter followed by "\n"
        int charCounter = 1;
        // set the break point. when counter is not equal to 0, the while loop will continue looping
        while(counter > 0){
            // because I created an arraylist containing 24 letters, so I need to create a random number range from 0 to 23 as a random index
            int index = getRandomNumber(0,23);
            // use the random index to get a letter from the arraylist
            Character c = charArray.get(index);
            // put the random picked letter into the map, and increase its value by one
            map.put(c, map.get(c)+1);
            // if the charCounter is not dividable by 4, the system prints out letters followed by a "|"
            if(charCounter%4 != 0){
                System.out.print(charArray.get(index)+"|");
            }else{
                // when it is dividable by 4,
                // which means it is the 4th letter, the system then prints out the letter followed by "\n"
                System.out.print(charArray.get(index)+"\n");
            }
            // decrease counter by one
            counter--;
            // increase charCounter by one
            charCounter++;
        }
        // the method I created takes in the map object, counting the most picked and the least picked letters in the map object, and print them out
        getLetterFrequency(map);
    }

    // create a method, the method takes two integers as arguments, and return a random number with the two numbers inclusively.
    // set the method access modifier to private, so it can't be used outside Question2 class
    // set it to static, so it belongs to Question2 class, when I want to use it within the class, I can use it straight away.
    // I don't need to instantiate a Question2 class object.
    private static int getRandomNumber(int min, int max){
        // The formula for generating random numbers with min and max values inclusive: Math.floor(Math.random()*(max-min+1)+min)
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    // create a method, takes in a map object, counting the most picked and the least picked letters in the map object, and print them out
    private static void getLetterFrequency(Map<Character, Integer> map){
        // initialize a maximum value
        int max = Integer.MIN_VALUE;
        // initialize a minimum value
        int min = Integer.MAX_VALUE;
        // loop through the map, find out the largest value and the smallest value in the map
        // the key with the largest value has the highest random picking rate
        // the key with the smallest value has the lowest random picking rate
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            // when max value is smaller than each value, set the max value to that value
            if(max < entry.getValue()){
                max = entry.getValue();
            }
            // when min value is smaller than each value, set the min value to that value
            if(min > entry.getValue()){
                min = entry.getValue();
            }
        }
        // use printf method to print the dynamic max value in a string. % is a placeholder, d means digit
        System.out.printf("Generated the most number of times (%d times): ", max);
        // loop through the map, find out which key/keys have the largest value, print them out.
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            // when the value equals to max, means the key is randomly picked most of the times
            if(entry.getValue() == max){
                // print the key(letter) out, followed by a space
                System.out.print(entry.getKey()+" ");
            }
        }
        // print a line to separate the two results
        System.out.println();
        // use printf method to print the dynamic min value in a string. % is a placeholder, d means digit
        System.out.printf("Generated the least number of times (%d times): ", min);
        // loop through the map again, find out which key/keys have the lowest value, print them out
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            // when the value equals to min, means the key is randomly picked least of times, or not being picked at all.
            // in such case, the value of that key will be zero.
            if(entry.getValue() == min){
                // print the key(letter) out, followed by a space
                System.out.print(entry.getKey()+" ");
            }
        }
    }
}
