package day1.kotlin

import java.io.File
import java.nio.file.Paths

fun main() {
    val path = Paths.get("").toAbsolutePath().toString()
    val file = File("$path/day1/input.txt")
    val readLines = file.readLines()

    var max = 0
    var sum = 0
    for (readLine in readLines) {
        if ("" == readLine) {
            max = max.coerceAtLeast(sum)
            sum = 0
        } else {
            sum += readLine.toInt()
        }
    }
    print(max)
}