package C2_A2_Q1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Write a Java program to do the following:

Compose a random sequence of 10 case-sensitive letters. Allowable letters are:
A   B   C   D   E   F   a   b   c   d   e   f

Assign random values to each letter. Allowable values are:
0.5   1   1.5   2   2.5   3

Display a comma separated list of each generated letter followed by its assigned value.
Do not include a space between the letter and its assigned value.
The program should determine which letters were not used, and print these on the next line.
Use an ArrayList as part of the solution to this question.

Sample output:

a1,c3,e2.5,f3,c2,B0.5,D3,b1.5,C2,f3
Letters not used: A,E,F,d

 */

public class Question1 {
    public static void main(String[] args) {

        // create a hashmap
        Map<Character, Integer> map = new HashMap<>();

        // this method takes in a map object, put letters from A to F and from a to f into the map, and set each of its value to 0
        addRequiredLetters(map);

        // create an arraylist
        List<Character> lettersArray = new ArrayList<>();

        // this method takes in an arraylist object, add letters from A to F and from a to f into the arraylist
        addRequiredLetters(lettersArray);

        // create an array, add 0.5, 1, 1.5, 2, 2.5, 3 as strings into this array
        // the reason why I add them as strings, not as doubles, is because I need to concat them with characters later
        String[] doubleArray = {"0.5", "1", "1.5", "2", "2.5", "3"};

        // this for_loop will generate 10 randomly picked letters from lettersArray, put the letter into the map, then increase its value by 1
        for(int i=0; i<10; i++){
            // generate random integer in the range of 0 to 9
            int indexForLetterArray = getRandomNumber(0,9);
            // randomly pick a letter from lettersArray, using the randomly generated index number
            Character letter = lettersArray.get(indexForLetterArray);
            // put the letter into the map, and increase its value by 1
            map.put(letter, map.get(letter)+1);
            // generate random integer in the range of 0 to 5;
            int indexForStringArray = getRandomNumber(0,5);
            if(i == 9){
                // if i == 9, means it is the last output, system prints out the value without ","
                System.out.print(lettersArray.get(indexForLetterArray) + doubleArray[indexForStringArray]);
            }else{
                // it's not the last output, system prints out the value with a ","
                System.out.print(lettersArray.get(indexForLetterArray) + doubleArray[indexForStringArray] + ",");
            }
        }

        // print a line to separate the two results
        System.out.println();

        // use the method which takes in a map object, it checks all the values in the map, if the value is 0, which means the key(letter) is not used, system prints it out
        getNotUsedLetters(map);
    }

    // create a method, takes in an array object, add letters from A to F and from a to f into the array
    // set the method access modifier to private, so it can't be used outside Question1 class
    // set it to static, so it belongs to Question1 class, when I want to use it within the class, I can use it straight away.
    // so I don't need to instantiate a Question1 class object.
    private static void addRequiredLetters(List<Character> array){
        // this for_loop is to add letters from A to F to the lettersArray
        // in ASCII code table, A is 65, F is 70, i starts at 65, increase by one after each loop, ends at 70
        for(int i = 65; i <= 70; i++){
            // cast i into a character, then add it to the lettersArray
            array.add((char)i);
        }
        // this for_loop is to add letters from a to f to the lettersArray
        // in ASCII code table, A is 97, F is 102, i starts at 97, increase by one after each loop, ends at 102
        for(int i = 97; i <= 102; i++){
            // cast i into a character, then add it to the lettersArray
            array.add((char)i);
        }
    }

    // overwrite the previous method, the same method signature but takes in a map object, put letters from A to F and from a to f into the map, and set each of its value to 1
    private static void addRequiredLetters(Map<Character,Integer> map){
        // this for_loop is to put letters from A to F into a map
        // in ASCII code table, A is 97, F is 102, i starts at 97, increase by one after each loop, ends at 102
        for(int i = 65; i <= 70; i++){
            // cast i into a character, then put it to the map, set the value to 1
            map.put((char)i, 0);
        }
        // this for_loop is to put letters from a to f to a map
        // in ASCII code table, A is 97, F is 102, i starts at 97, increase by one after each loop, ends at 102
        for(int i = 97; i <= 102; i++){
            // cast i into a character, then put it to the map, set the value to 1
            map.put((char)i, 0);
        }
    }

    // create a method which takes in two integer arguments, return a random number with the two integers inclusive
    private static int getRandomNumber(int min, int max){
        // The formula for generating random numbers with min and max values inclusive: Math.floor(Math.random()*(max-min+1)+min)
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    // create a method which takes in a map object, it checks all the values in the map, if the value is 0, which means the key(letter) is not used, system prints it out
    // the reason why I have to use another arraylist is because the last print out letter can't be followed by a ","; I need indexes to check if the letter is the last one
    // hashmap has no index, I can't track the letter's location
    private static void getNotUsedLetters(Map<Character,Integer> map){
        // create an arraylist
        List<Character> lettersNotUsedArray = new ArrayList<>();
        // loop through the map
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 0){
                // if the letter's value is zero, means it is not picked, add it to the lettersNotUsedArray
                lettersNotUsedArray.add(entry.getKey());
            }
        }
        // print out the required sentence
        System.out.print("Letters not used: ");
        // loop through the lettersNotUsedArray
        for(int i=0; i<lettersNotUsedArray.size(); i++){
            if(i == lettersNotUsedArray.size()-1){
                // when it is the last letter, print it out without ","
                System.out.println(lettersNotUsedArray.get(i));
            }else{
                // if it is not the last letter, print it out with a ","
                System.out.print(lettersNotUsedArray.get(i)+",");
            }
        }
    }
}
