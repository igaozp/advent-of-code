package day2

import java.io.File
import java.nio.file.Paths

var chooseMapTable = buildMap {
    put("A", listOf("Y", "X", "Z"))
    put("B", listOf("Z", "Y", "X"))
    put("C", listOf("X", "Z", "Y"))
}

var scoreMap = buildMap {
    put("X", 1)
    put("Y", 2)
    put("Z", 3)
}

fun main() {
    val path = Paths.get("").toAbsolutePath().toString()
    val file = File("$path/day2/input.txt")
    val readLines = file.readLines()

    var sum = 0
    for (line in readLines) {
        val split = line.split(" ")
        sum += judge(split[0], split[1])
    }
    println(sum)
}

fun judge(opponent: String, my: String): Int {
    val index = chooseMapTable[opponent]?.indexOf(my)
    var score = 0

    when (index) {
        0 -> score = 6
        1 -> score = 3
        2 -> score = 0
    }
    return score + scoreMap[my]!!
}