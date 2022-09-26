package leetcode

object MaxProfit {
  def maxProfit(prices: Array[Int]): Int = {
    var minPrice = Int.MaxValue
    var maxProfit = Int.MinValue
    for (i <- prices.indices) {
      minPrice = Math.min(minPrice, prices(i))
      maxProfit = Math.max(maxProfit, prices(i) - minPrice)
    }
    maxProfit
  }

  def main(args: Array[String]): Unit = {
    println(maxProfit(Array(7,6,4,3,1)))
  }
}
