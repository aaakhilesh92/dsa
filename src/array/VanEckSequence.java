package array;

// Java program to count the occurrence of nth term in first n terms of Van Eck's sequence
public class VanEckSequence {
    final private int n;
    final private int[] sequence;

    VanEckSequence(int n) {
        this.n = n;
        sequence = new int[n];
    }

    // Utility function to compute Van Eck's sequence
    public void vanEckSequence() {
        // Initialize sequence array
        for (int i = 0; i < n; i++) {
            sequence[i] = 0;
        }
        // Loop to generate sequence
        for (int i = 0; i < n - 1; i++) {
            // Check if sequence[i] has occurred previously or is new to sequence
            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] == sequence[i]) {
                    // If occurrence found then the next term will be how far back this last term occured previously
                    sequence[i + 1] = i - j;
                    break;
                }
            }
        }
    }

    public int getNthTerm(int n) {
        return sequence[n];
    }

    public void printVanEckSequence() {
        for (int i = 0; i < n; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }

    // Utility function to count the occurrence of nth term in first n terms of the sequence
    public int countOccurrenceOfNthTermInFirstNTerms(int n) {
        // Initialize count as 1
        int count = 1;
        int i = n - 1;
        while (sequence[i + 1] != 0) {
            // Increment count if (i+1)th term is non-zero
            count++;
            // Previous occurrence of sequence[i] will be it (i - sequence[i+1])th position
            i = i - sequence[i + 1];
        }
        return count;
    }

    // Driver code
    public static void main(String[] args) {
        VanEckSequence obj = new VanEckSequence(20);
        obj.vanEckSequence();
        obj.printVanEckSequence();
        int n = 8;
        // Print count of the occurrence of nth term in first n terms of the sequence
        System.out.println(obj.countOccurrenceOfNthTermInFirstNTerms(n));

        n = 7;
        // Print count of the occurrence of nth term in first n terms of the sequence
        System.out.println(obj.countOccurrenceOfNthTermInFirstNTerms(n));
    }
}
