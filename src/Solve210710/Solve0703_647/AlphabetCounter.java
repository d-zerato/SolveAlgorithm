package Solve210710.Solve0703_647;

public class AlphabetCounter {
    //
    public char alphabet;
    public int count;

    public AlphabetCounter(char alphabet) {
        //
        this.alphabet = alphabet;
        this.count = 1;
    }

    public void increaseCount() {
        this.count++;
    }

    public char getAlphabet() {
        return alphabet;
    }

    public int getCount() {
        return count;
    }
}
