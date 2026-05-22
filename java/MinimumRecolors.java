package java;

public class MinimumRecolors {
class Solution {
    public int minimumRecolors(String blocks, int k) {
        int white = 0;

        // first window
        for (int i = 0; i < k; i++) {

            if (blocks.charAt(i) == 'W') {
                white++;
            }
        }

        int min = white;

        // slide window
        for (int i = k; i < blocks.length(); i++) {

            // remove left char
            if (blocks.charAt(i - k) == 'W') {
                white--;
            }

            // add right char
            if (blocks.charAt(i) == 'W') {
                white++;
            }

            min = Math.min(min, white);
        }

        return min; 
    }
}
}