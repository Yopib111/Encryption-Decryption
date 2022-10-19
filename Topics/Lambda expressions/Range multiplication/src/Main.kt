    val lambda: (Long, Long) -> Long = { a: Long, b: Long ->
        var sum: Long = a
        for (i in a + 1..b) {
            sum *= i
        }
        sum
    }
