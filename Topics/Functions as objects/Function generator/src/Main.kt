val x = 4
fun identity(x: Int) = x
fun half(x: Int) = x / 2
fun zero(x: Int) = 0
// TODO: provide three functions here

fun generate(functionName: String): (Int) -> Int {
    return when (functionName) {
        "identity" -> {
            ::identity
        }
        "half" -> {
            ::half
        }
        else -> {
            ::zero
        }
    }
    // TODO: provide implementation here
}