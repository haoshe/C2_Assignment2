package C2_A2_Q3;

public class BirdSightingMachine {
    // initialize four properties of the BirdSightingMachine class
    private String birdNameA;
    private String birdNameB;
    private int numberOfSightingOfBirdA;
    private int numberOfSightingOfBirdB;

    // constructor takes has two parameters, birdNameA and birdNameB
    public BirdSightingMachine(String birdNameA, String birdNameB) {
        this.birdNameA = birdNameA;
        this.birdNameB = birdNameB;
    }

    // getter method for birdA
    public String getBirdNameA() {
        return birdNameA;
    }

    // getter method for birdB
    public String getBirdNameB() {
        return birdNameB;
    }

    // getter method for the number of sightings of bird A
    public int getNumberOfSightingOfBirdA() {
        return numberOfSightingOfBirdA;
    }

    // getter method for the number of sightings of bird B
    public int getNumberOfSightingOfBirdB() {
        return numberOfSightingOfBirdB;
    }

    // increase the number of sightings of bird A by one every time a bird A is spotted
    public void sightingOfBirdA() {
        numberOfSightingOfBirdA++;
    }

    // increase the number of sightings of bird B by one every time a bird B spotted
    public void sightingOfBirdB() {
        numberOfSightingOfBirdB++;
    }

    // reset the number of sightings of bird A and bird B to zero after each season
    public void reset() {
        numberOfSightingOfBirdA = 0;
        numberOfSightingOfBirdB = 0;
    }
}
