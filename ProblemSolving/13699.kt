fun main() {
    val n = readLine()!!.toInt()
    val dp = LongArray(36)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..35) {
        for (j in 0 until i) {
            dp[i] += dp[j] * dp[i - 1 - j]
        }
    }
    print(dp[n])
}