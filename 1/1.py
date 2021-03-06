class Solution(object):

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] == target:
                    return i, j

if __name__ == '__main__':
    sol = Solution()
    nums = [3, 2, 4]
    target = 6
    result = sol.twoSum(nums, target)
    print(result)
