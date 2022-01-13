fun reverse(x: Int): Int {
    if (Int.MAX_VALUE < x || Int.MIN_VALUE > x) {
        return 0
    } else if (x > 0) {
        var temp = x.toString()
        var reverseNumber = StringBuffer(temp).reverse().toString().toLong()
        if (Int.MAX_VALUE < reverseNumber || Int.MIN_VALUE > reverseNumber) {
            return 0
        }
        return reverseNumber.toInt()
    } else {
        var tempNumber:Long = -1 * x.toLong()
        var temp = tempNumber.toString()
        var reverseNumber = StringBuffer(temp).reverse().toString().toLong()*-1
        if (Int.MAX_VALUE < reverseNumber || Int.MIN_VALUE > reverseNumber) {
            return 0
        }
        var number = reverseNumber.toInt()
        return (number)
    }
}

fun main() {
    println(reverse(-2147483648))
}