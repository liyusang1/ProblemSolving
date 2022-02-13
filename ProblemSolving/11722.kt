//11722

fun main() {
    val input = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(input) { 1 }

    for (i in 1 until dp.size) {
        for (j in 0 until i) {
            if (a[i] < a[j] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1
            }
        }
    }
    print(dp.maxOrNull())
}