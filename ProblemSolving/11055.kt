import kotlin.math.max

fun main() {
    val input = readLine()
    val a = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val dp = a.copyOf()
    for (i in 1 until dp.size) {
        for (j in 0 until i) {
            if (a[i] > a[j]) {
                dp[i] = max(a[i] + dp[j], dp[i])
            }
        }
    }
    print(dp.maxOrNull())
}