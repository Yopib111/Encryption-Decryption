    fun main(args: Array<String>) {
        val aaa = arrayOf("first", "second", "third")
        if (args.size < 3) {
            main(aaa)
        } else { 
            for (i in args) {
                println(i)
            }
        }
    }
