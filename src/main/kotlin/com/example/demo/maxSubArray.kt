package com.example.demo

import java.io.File
import kotlin.math.max
import kotlin.math.min
typealias arr2 =Array<IntArray>
class NumArray(var nums: IntArray) {
var sum= arr(nums.size+1)

init {
    (1..nums.lastIndex).forEach {
        sum[it]=sum[it-1]+nums[it-1]
    }
}
    fun sumRange(i: Int, j: Int)=sum[j+1]-sum[i]
}
fun maxProfit(prices: IntArray): Int {
    if(prices.size<=1) return 0
    var maxs=0
    var mins=prices[0]
    prices.forEachFrom(1){
        mins=min(it,mins)
        maxs=max(maxs,it-mins)
    }
return maxs
}



fun maxSubArray(nums: Array<Int>): Int? {
    (1..nums.lastIndex).forEach {
        nums[it]+=max(nums[it - 1], 0)
    }
    return nums.maxOrNull()
/*    nums.forEachFrom(1) {
        it += max(it.prev(nums), 0)
}*/

}
fun uniquePaths(m:Int,n:Int): Int {
    var dp =arr2(m,n,1)
    (1 until m).forEach {ip->
        (1 until n).forEach {
            dp[ip][it]=dp[ip-1][it]+dp[ip][it-1]
        }
    }
return dp[m-1][n-1]
}
@Suppress("UNSUPPORTED")
fun uniquePathsWithObstacles(ob: arr2): Int {
    var n = ob.size
    var m = ob[0].size
    var dp = arr(m)
    dp[0] = if (ob[0][0] == 1) 0 else 1
    for (i in 1 until m) {
        for (j in 1 until n) {
            if (ob[i][j] == 0) dp[j] = dp[j] + dp[j - 1]
            else dp[j] = 0
        }
    }


        [1,2,3].twoFilter({it>3},{it*2},{it*-2})

    return dp[m - 1]
}


class Tests(){
    fun first(){

    }
}

@Suppress("UNSUPPORTED")
fun main() {
//uniquePathsWithObstacles([[0,0,0],[0,1,0],[0,0,0]]).println()
//maxSubArray([1,4,3,-1,5,-3,8]).println()
//maxProfit([7,6,4,3,1]).println()
//NumArray([1,2,3,4,5,6]).sumRange(2,4).println()
   var a= [1,2,3,4,5,6]
        .twoFilter({it>3},{it*2},{it*-2})
    var b=2
    var number =if(true) "b" else 2

}

