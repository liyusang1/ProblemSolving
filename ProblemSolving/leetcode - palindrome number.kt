fun isPalindrome(x: Int): Boolean {
    var number = x.toString()
    val temp = StringBuffer(number).reverse().toString()
    return temp==number
}

fun main(){
    print(isPalindrome(-121))
}