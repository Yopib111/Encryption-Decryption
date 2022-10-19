fun main() {    
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()
    // Do not touch lines above
    // Write only exchange actions here.
    val a = numbers[0]
    numbers[0] = numbers[numbers.size-1]
    numbers[numbers.size - 1] = a
    // Do not touch lines below
    println(numbers.joinToString(separator = " "))
    val d = char
}