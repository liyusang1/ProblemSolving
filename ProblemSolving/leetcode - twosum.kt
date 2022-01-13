fun twoSum(nums: IntArray, target: Int): IntArray {
    for (index1 in nums.indices) {
        for (index2 in index1 + 1 until nums.size) {
            if (target == nums[index2] + nums[index1]) {
                return intArrayOf(index1, index2)
            }
        }
    }
    return intArrayOf(-1)
}

fun main() {
    print(twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
}