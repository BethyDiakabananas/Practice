# count the number of 1 bits in binary string
class Solution:
    # @param A : integer
    # @return an integer
    def numSetBits(self, A):
        count = 0
        while A != 0:
            if A&1:
                count += 1
            A = A >> 1
        return count
