package java;

public class kokoEatingBananas {
     public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];
        
        // Find max in single pass
        for (int pile : piles) {
            if (pile > right) right = pile;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Calculate hours with early exit
            long hours = 0;
            for (int pile : piles) {
                hours += (pile - 1) / mid + 1;
                if (hours > h) break;  // Early exit if already exceeded
            }
            
            if (hours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
