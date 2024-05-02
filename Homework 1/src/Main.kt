fun main() {
    val numbers = mutableListOf<Int>()
    var work = true
    while(work) {
        print("Enter number(or \"done\" to complete):")
        val str:String = readln()
        if(str == "done"){
            println("The input numbers are:${numbers}")
            println("The maximum number of input is ${maxNumber(numbers)}")
            println("The average of input is ${averageNumber(numbers)}")
            work = false
        }
        else if(checkNumber(str))numbers.add(str.toInt())
        else println("Error input, try again!")
    }
}
fun maxNumber(lst:MutableList<Int>):Int{
    var max = 0
    for(num in lst)if(num > max)max = num
    return max
}
fun averageNumber(lst:MutableList<Int>):Double{
    var sum = 0
    for(num in lst)sum += num
    return (sum.toDouble() / lst.size)
}
fun checkNumber(str:String):Boolean{
    for(ch in str)if(ch !in ('0'..'9')) return false
    return true
}