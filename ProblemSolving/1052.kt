fun main() {
    var (n, m) = readLine()!!.split(' ').map { it.toInt() }
    var answer: Int = 0

    while (true) {
        var count: Int = 0
        var temp: Int = n
        while (temp > 0) {
            if (temp % 2 == 1) count++
            temp /= 2
        }
        if (count <= m) {
            break
        }
        n++
        answer++
    }
    print(answer)
}