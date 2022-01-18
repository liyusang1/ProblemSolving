package PS

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val queue: Queue<Int> = LinkedList()
    repeat(n) {
        queue.add(it + 1)
    }
    while (queue.size != 1) {
        queue.poll()
        queue.add(queue.poll())
    }
    print(queue.poll())
}