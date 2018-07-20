class Solution:
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        # count = 0
        # for c in S:
        #     if c in J:
        #         count += 1
        # return count
        
        # return len([c for c in S if c in J])
        
        return sum(S.count(c) for c in J)
        
