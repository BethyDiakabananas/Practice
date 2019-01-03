    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        S = sum(nums)
        left = 0
        for i, num in enumerate(nums):
            if left == S - left - num:
                return i
            left += num
        return -1;
         
