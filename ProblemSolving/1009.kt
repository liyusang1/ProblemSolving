fun solution(a: Int, b: Int): Int {
    var result = a % 10
    for (i in 1 until b) {
        result = (result * a) % 10
    }
    return if (result == 0) {
        10
    } else {
        result
    }
}

fun main() {
    var count = readLine()!!.toInt()
    for (i in 0 until count) {
        val (n, m) = readLine()!!.split(' ').map { it.toInt() }
        println(solution(n, m))
    }
}