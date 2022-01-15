package C2_A2_Q3;

// create a class with a main method to test BirdSightingMachine class
public class BirdSightingMachineTester {
    public static void main(String[] args) {
        // instantiate an object by using BirdSightingMachine's constructor and passing two arguments.
        BirdSightingMachine bsm = new BirdSightingMachine("pigeon", "seagull");
        // create a loop with 3 iterations to mimic 3 seasons
        for (int i = 0; i < 3; i++) {
            // generate a random number from 0 to 1000;
            int randomNo1 = (int) Math.floor(Math.random() * (1000 - 0 + 1) + 0);
            // use this random number to mimic the number of sightings of bird A in each season
            for (int j = 0; j < randomNo1; j++) {
                // increase the number of sightings of bird A by one
                bsm.sightingOfBirdA();
            }
            // generate a random number from 0 to 1000;
            int randomNo2 = (int) Math.floor(Math.random() * (1000 - 0 + 1) + 0);
            // use this random number to mimic the number of sightings of bird B in each season

            for (int j = 0; j < randomNo2; j++) {
                // increase the number of sightings of bird B by one
                bsm.sightingOfBirdB();
            }
            // print out "Result of season"
            System.out.println("Result of season: ");
            // print out bird A name and the number of sightings of bird A
            System.out.println(bsm.getBirdNameA() + ": " + bsm.getNumberOfSightingOfBirdA() + " sightings");
            // print out bird B name and the number of sightings of bird B
            System.out.println(bsm.getBirdNameB() + ": " + bsm.getNumberOfSightingOfBirdB() + " sightings");
            // compare number of sightings for bird A and bird B
            // if bird A > bird B, print out bird A wins; if bird A < bird B, print out bird B wins; if they are equal, print out "it's a draw!"
            if (bsm.getNumberOfSightingOfBirdA() > bsm.getNumberOfSightingOfBirdB()) {
                System.out.println(bsm.getBirdNameA() + " wins");
            } else if (bsm.getNumberOfSightingOfBirdA() < bsm.getNumberOfSightingOfBirdB()) {
                System.out.println(bsm.getBirdNameB() + " wins");
            } else {
                System.out.println("It's a draw!");
            }
            // print out an empty line between each season
            System.out.println();
            // reset number of sightings of bird A and bird B to zero, after each season tally.
            bsm.reset();
        }


    }
}
