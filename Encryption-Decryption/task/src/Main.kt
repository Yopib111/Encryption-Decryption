package tictactoe

import java.io.File

fun main(args: Array<String>) {
    val alfabith = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var readMeth = "enc"
    var readS = ""
    var key = 0
    var exit = ""
    var alg = "shift"
    if ("-mode" in args) readMeth = args[args.indexOf("-mode") + 1]
    if ("-key" in args) key = args[args.indexOf("-key") + 1].toInt()
    if ("-alg" in args) alg = args[args.indexOf("-alg") + 1]

    if ("-in" in args) {
        val fileReadName = args[args.indexOf("-in") + 1]
        readS = File(fileReadName).readText()
    }

    if ("-data" in args) {
        readS = args[args.indexOf("-data") + 1]
    } else if ("-in" in args) {
        val fileName = args[args.indexOf("-in") + 1]
        try {
            readS = File(fileName).readText()
        } catch (ect: Exception) {
            println("Error")
        }
    } else readS = ""

    when (readMeth) {
        "enc" -> {
            when (alg) {
                "unicode" -> {
                    for (i in 0..readS.length - 1) {
                        val simvol = readS[i].code + key
                        exit += simvol.toChar()
                    }
                }

                else -> {
                    for (i in 0..readS.length - 1) {
                        if (readS[i].isUpperCase()) {
                            for (j in 0..alfabith.length - 1) {
                                if (readS[i] == alfabith[j]) {
                                    if (j + key <= 25) {
                                        exit += alfabith[j + key]
                                    } else {
                                        exit += alfabith[j - 25 + key - 1]
                                    }
                                }

                            }
                        } else if (readS[i].isLowerCase()) {
                            for (j in 0..alfabith.length - 1) {
                                if (readS[i] == alfabith[j].lowercaseChar()) {
                                    if (j + key <= 25) {
                                        exit += alfabith[j + key].lowercase()
                                    } else {
                                        exit += alfabith[j - 25 + key - 1].lowercase()
                                    }
                                }

                            }

                        } else exit += readS[i]
                    }
                }
            }
        }

        "dec" -> {
            when (alg) {
                "unicode" -> {
                    for (i in 0..readS.length - 1) {
                        val simvol = readS[i].code - key
                        exit += simvol.toChar()
                    }
                } else -> {
                for (i in 0..readS.length - 1) {
                    if (readS[i].isUpperCase()) {
                        for (j in 0..alfabith.length - 1) {
                            if (readS[i] == alfabith[j]) {
                                if (j - key < 0) {
                                    exit += alfabith[26 - key + j]
                                } else {
                                    exit += alfabith[j - key]
                                }
                            }

                        }
                    } else if (readS[i].isLowerCase()) {
                        for (j in 0..alfabith.length - 1) {
                            if (readS[i] == alfabith[j].lowercaseChar()) {
                                if (j - key < 0) {
                                    exit += alfabith[26 - key + j].lowercase()
                                } else {
                                    exit += alfabith[j - key].lowercase()
                                }
                            }

                        }

                    } else exit += readS[i]
                }
            }
            }
        }
    }
    if ("-out" in args) {
        val fileName = args[args.indexOf("-out") + 1]
        File(fileName).writeText(exit)
    } else println(exit)
}
