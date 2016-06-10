class Solution(object):

    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        n = len(nums)
        ind = sorted(range(n), key=lambda x: nums[x])
        sorted_nums = [nums[ind[i]] for i in range(n)]
        print('nums: ', nums)
        print('ind: ', ind)
        print('sorted_nums: ', sorted_nums)
        for i in range(n):
            k1 = i + 1
            k2 = n - 1
            print('i, k1, k2: ', i, k1, k2)
            while k1 <= k2:
                k = int((k1 + k2) / 2)
                print('   k1, k2, k: ', k1, k2, k)
                s = sorted_nums[i] + sorted_nums[k]
                if s == target:
                    return ind[i], ind[k]
                elif s < target:
                    k1 = k + 1
                else:
                    k2 = k - 1

if __name__ == '__main__':
    sol = Solution()
    nums = [3, 2, 1, 4]
    target = 6
    result = sol.twoSum(nums, target)
    print(result)
