package leetcode

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- nums.indices){
      for (j <- i until nums.length){
        if (nums(i) + nums(j) == target && i != j) {
          return Array(i,j)
        }
      }
    }
    Array.empty
  }
}
