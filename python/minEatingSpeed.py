class Solution(object):
    def minEatingSpeed(self, piles, h):
        """
        :type piles: List[int]
        :type h: int
        :rtype: int
        """
        def can_eat(k):
            hours = 0
            for pile in piles:
                hours += (pile + k - 1) // k  
            return hours <= h
        
        left = 1
        right = max(piles)
        
        while left < right:
            mid = (left + right) // 2
            if can_eat(mid):
                right = mid
            else:
                left = mid + 1
        
        return left