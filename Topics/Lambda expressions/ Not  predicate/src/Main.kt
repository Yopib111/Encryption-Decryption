    val notPredicate: (Char) -> Boolean = { a: Char -> 
        !originalPredicate(a)
    }
