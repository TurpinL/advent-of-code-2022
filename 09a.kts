import kotlin.math.abs

val isTest = false

val inputLines = input().lines()

var headPos = Coord(0,0)
var tailPos = Coord(0,0)
val tailPositions = mutableListOf(tailPos)

println("================= Part 1 =================")
inputLines.forEach { line ->
    val instructions = line.split(" ")
    val direction = instructions[0]
    val repeats = instructions[1].toInt()

    for (i in 0 until repeats) {
        val prevHeadPos = headPos
        headPos = when(direction) {
            "U" -> Coord(prevHeadPos.x, prevHeadPos.y + 1)
            "D" -> Coord(prevHeadPos.x, prevHeadPos.y - 1)
            "L" -> Coord(prevHeadPos.x - 1, prevHeadPos.y)
            "R" -> Coord(prevHeadPos.x + 1, prevHeadPos.y)
            else -> Coord(prevHeadPos.x + 10000, prevHeadPos.y)
        }

        if (!headPos.isAdjacent(tailPos)) {
            tailPos = prevHeadPos
            tailPositions.add(tailPos)
        }
    }
}

println("Answer:")
tailPositions.toSet().size

data class Coord(val x: Int, val y: Int) {
    fun isAdjacent(other: Coord): Boolean {
        return abs(x - other.x) <= 1 && abs(y - other.y) <= 1
    }
}


fun input(): String {
    return if (isTest) {
        """
            R 4
            U 4
            L 3
            D 1
            R 4
            D 1
            L 5
            R 2
        """.trimIndent()
    } else {
        """
            U 1
            D 1
            L 1
            U 2
            L 1
            D 2
            L 2
            U 2
            L 1
            R 2
            U 2
            D 1
            R 2
            U 1
            R 1
            U 1
            R 1
            U 2
            L 1
            U 2
            D 1
            R 1
            U 2
            D 1
            U 2
            D 2
            U 2
            D 1
            R 1
            D 2
            L 2
            R 2
            L 1
            R 2
            D 2
            L 2
            U 1
            D 2
            R 2
            L 2
            R 2
            D 2
            R 1
            D 1
            L 1
            D 1
            L 2
            D 1
            R 1
            L 1
            U 2
            L 2
            U 1
            D 1
            U 1
            D 1
            L 2
            D 2
            L 2
            U 1
            R 2
            D 1
            U 1
            R 2
            L 1
            R 1
            L 1
            R 2
            L 1
            U 2
            R 1
            L 1
            U 1
            D 2
            R 1
            D 2
            L 1
            U 2
            D 2
            L 2
            U 1
            L 1
            D 1
            L 2
            U 2
            R 2
            U 1
            D 2
            L 1
            D 2
            R 1
            L 1
            R 1
            D 2
            U 1
            R 1
            L 1
            U 2
            R 2
            L 1
            R 2
            L 1
            R 1
            L 2
            U 1
            R 2
            D 2
            U 1
            D 1
            L 2
            D 1
            R 3
            D 1
            L 3
            D 1
            R 2
            D 1
            R 2
            U 3
            L 2
            U 2
            D 2
            L 3
            R 3
            U 3
            R 3
            L 1
            R 2
            L 2
            R 3
            U 2
            D 3
            L 3
            D 1
            R 2
            U 1
            D 2
            U 2
            L 1
            U 2
            R 2
            D 2
            L 3
            D 1
            L 1
            R 1
            D 3
            L 2
            R 2
            L 2
            R 2
            D 1
            R 2
            L 3
            U 1
            R 2
            D 2
            R 1
            D 2
            R 2
            L 3
            U 1
            L 2
            U 1
            D 3
            L 1
            U 1
            D 3
            U 2
            L 1
            U 3
            D 2
            R 2
            U 3
            L 3
            D 1
            U 3
            R 1
            U 2
            L 2
            D 1
            U 1
            D 3
            R 1
            D 3
            U 3
            L 3
            R 2
            D 3
            L 2
            U 3
            L 1
            D 3
            L 2
            D 1
            R 3
            L 1
            R 3
            U 2
            L 3
            D 1
            R 2
            L 1
            U 1
            L 3
            R 3
            U 2
            D 2
            U 2
            R 1
            L 3
            U 3
            L 1
            R 3
            D 3
            L 2
            D 3
            U 1
            L 3
            D 3
            R 2
            U 3
            D 1
            R 1
            L 1
            U 4
            L 2
            U 3
            R 3
            U 1
            D 2
            R 4
            U 1
            L 1
            U 3
            R 2
            D 4
            U 3
            D 1
            U 1
            L 1
            U 3
            R 4
            L 1
            R 4
            L 1
            R 2
            L 4
            D 1
            L 4
            R 2
            D 2
            R 2
            U 1
            D 2
            L 4
            D 1
            R 3
            D 2
            U 3
            D 4
            L 3
            U 2
            R 4
            U 4
            D 2
            L 2
            D 1
            U 3
            L 2
            R 4
            L 1
            U 3
            L 2
            R 3
            U 1
            R 4
            D 3
            L 3
            D 1
            U 4
            L 4
            D 3
            R 1
            L 1
            D 2
            L 1
            R 4
            D 2
            L 3
            D 4
            L 4
            U 2
            D 1
            U 4
            D 4
            U 2
            D 2
            R 4
            L 2
            D 4
            U 2
            L 1
            D 4
            U 3
            D 3
            R 2
            D 1
            U 4
            R 2
            U 3
            D 1
            R 1
            L 1
            D 1
            L 3
            R 4
            U 2
            L 4
            D 3
            L 2
            R 4
            L 3
            U 3
            L 1
            D 4
            R 1
            L 2
            D 1
            R 2
            L 1
            R 4
            L 1
            R 3
            U 2
            D 1
            R 2
            L 1
            D 5
            U 1
            D 2
            R 5
            U 4
            L 1
            D 2
            R 3
            U 2
            D 1
            L 4
            D 5
            R 4
            D 2
            R 3
            D 5
            L 2
            R 5
            U 2
            L 4
            R 4
            U 3
            D 3
            R 1
            U 4
            D 2
            U 2
            L 3
            D 4
            L 4
            D 2
            U 5
            R 1
            U 4
            L 2
            U 3
            R 5
            D 4
            U 5
            R 2
            D 5
            R 3
            U 1
            R 4
            L 3
            D 1
            L 1
            R 5
            L 5
            D 2
            U 5
            D 5
            R 5
            U 3
            D 4
            R 4
            U 2
            L 1
            D 3
            U 3
            R 4
            U 4
            D 1
            L 1
            R 2
            L 5
            R 1
            L 3
            D 1
            U 5
            R 1
            U 4
            D 5
            L 5
            R 2
            L 4
            U 1
            L 5
            D 2
            R 2
            D 1
            R 4
            D 5
            L 3
            D 3
            L 4
            U 5
            L 3
            R 4
            D 4
            R 2
            U 4
            R 4
            D 3
            U 3
            L 3
            R 1
            D 4
            U 1
            R 1
            D 1
            R 4
            D 3
            L 5
            U 1
            D 1
            U 5
            L 5
            D 3
            U 6
            D 5
            U 5
            D 1
            L 5
            D 4
            L 2
            R 6
            U 3
            R 6
            D 6
            U 5
            D 3
            L 1
            R 2
            U 2
            D 4
            U 6
            D 1
            U 1
            D 2
            U 3
            L 1
            U 6
            D 4
            L 6
            U 5
            D 4
            U 3
            R 6
            U 5
            R 2
            U 3
            D 6
            L 5
            U 2
            D 4
            L 4
            D 4
            R 6
            U 4
            L 3
            U 4
            R 6
            D 1
            U 4
            R 1
            L 1
            U 3
            D 6
            L 2
            D 2
            U 3
            R 5
            D 1
            R 3
            U 6
            L 2
            R 2
            U 4
            L 5
            D 4
            U 4
            R 4
            D 5
            L 1
            R 2
            U 4
            L 5
            D 6
            R 2
            L 2
            D 6
            L 1
            R 1
            U 3
            L 4
            D 4
            U 5
            L 3
            D 2
            U 2
            L 1
            R 3
            L 4
            U 6
            L 2
            U 2
            D 3
            L 5
            R 1
            D 1
            U 1
            D 6
            L 6
            D 6
            U 2
            D 6
            L 3
            U 2
            L 6
            D 2
            L 4
            R 5
            D 2
            U 3
            R 1
            D 4
            U 2
            R 5
            D 6
            R 7
            U 5
            L 6
            U 5
            L 2
            R 1
            L 3
            R 6
            U 2
            L 3
            U 7
            R 1
            D 2
            U 4
            R 2
            L 3
            D 2
            U 3
            D 7
            U 2
            L 4
            R 6
            D 5
            R 7
            U 1
            D 3
            U 7
            R 2
            U 4
            D 2
            L 7
            D 2
            U 4
            D 3
            R 4
            U 6
            L 7
            R 7
            L 3
            D 3
            U 1
            L 5
            U 5
            R 2
            U 7
            L 2
            U 2
            D 1
            R 3
            U 1
            L 4
            U 4
            D 4
            U 1
            L 2
            R 5
            D 4
            L 4
            U 3
            R 1
            D 2
            R 7
            D 2
            U 5
            D 1
            U 4
            R 7
            L 4
            R 6
            L 7
            R 2
            D 6
            U 7
            R 1
            D 7
            L 3
            D 2
            L 7
            R 4
            L 2
            D 3
            R 2
            U 6
            L 6
            U 2
            R 2
            U 7
            R 7
            D 5
            U 6
            D 7
            R 6
            D 7
            R 2
            U 7
            L 6
            R 6
            U 1
            D 2
            L 1
            R 3
            D 4
            U 3
            R 6
            D 3
            U 3
            D 5
            L 5
            U 4
            R 6
            D 4
            U 7
            L 3
            U 6
            R 7
            D 8
            R 5
            L 4
            D 2
            L 4
            U 8
            R 2
            D 6
            U 4
            D 6
            U 1
            D 7
            U 7
            L 4
            R 2
            L 7
            D 8
            L 2
            D 7
            R 4
            L 3
            D 8
            R 7
            D 8
            U 7
            D 4
            L 1
            U 1
            D 1
            L 3
            D 4
            L 7
            U 8
            D 2
            R 8
            L 1
            D 8
            L 1
            D 4
            U 1
            R 8
            D 2
            L 6
            D 4
            U 4
            R 1
            U 8
            D 1
            U 8
            R 5
            D 8
            L 7
            D 8
            U 6
            D 2
            R 6
            U 8
            L 5
            U 2
            R 4
            L 2
            D 4
            L 5
            D 4
            R 7
            D 5
            L 4
            R 5
            L 4
            D 6
            L 2
            R 1
            U 8
            R 6
            D 8
            U 2
            R 3
            U 5
            R 2
            D 2
            R 2
            D 4
            U 5
            D 2
            L 2
            U 6
            D 3
            R 8
            U 7
            L 7
            D 2
            U 2
            L 8
            D 5
            U 1
            D 7
            L 6
            D 3
            U 3
            D 5
            R 2
            U 7
            L 3
            U 8
            R 9
            D 9
            U 2
            D 7
            L 1
            R 7
            L 8
            U 3
            D 4
            L 2
            R 2
            D 6
            U 6
            R 5
            U 4
            D 6
            R 7
            D 4
            U 1
            D 6
            R 8
            L 6
            R 7
            D 4
            U 5
            D 2
            R 9
            U 5
            L 9
            D 8
            U 1
            L 7
            R 4
            L 8
            R 6
            U 8
            D 9
            U 8
            D 1
            U 6
            L 2
            R 2
            L 9
            D 2
            R 8
            L 1
            U 1
            L 1
            D 8
            U 7
            L 9
            U 4
            R 2
            U 6
            D 5
            R 1
            L 2
            R 1
            L 7
            R 4
            D 2
            L 1
            U 1
            D 3
            U 4
            R 2
            D 7
            L 4
            U 1
            L 1
            D 8
            U 7
            D 6
            U 8
            L 3
            D 2
            R 8
            U 3
            D 5
            U 5
            D 3
            U 2
            L 1
            R 8
            D 2
            L 4
            U 6
            D 2
            L 7
            U 9
            L 3
            D 1
            U 7
            L 4
            U 3
            L 8
            R 9
            D 2
            L 8
            U 9
            R 3
            D 3
            U 7
            D 9
            R 1
            U 8
            R 4
            L 1
            D 9
            L 6
            U 6
            R 3
            D 4
            U 5
            R 5
            L 3
            R 3
            L 7
            U 7
            R 3
            D 4
            R 3
            L 9
            D 2
            U 1
            L 2
            D 10
            R 4
            D 5
            U 1
            R 9
            L 4
            R 7
            D 10
            U 8
            L 8
            R 7
            L 3
            D 6
            L 8
            D 3
            U 7
            D 2
            L 6
            U 1
            R 5
            D 2
            L 7
            D 3
            L 5
            U 10
            R 2
            U 7
            R 7
            L 3
            U 4
            L 5
            D 9
            L 10
            U 5
            L 8
            R 4
            D 6
            U 9
            R 3
            L 4
            R 10
            L 8
            U 5
            D 10
            L 10
            U 7
            L 7
            R 6
            U 2
            D 10
            R 1
            L 9
            U 2
            R 9
            U 10
            D 5
            U 3
            L 3
            D 9
            R 6
            U 9
            R 3
            L 4
            D 2
            R 6
            D 3
            U 7
            D 6
            U 6
            L 5
            D 5
            R 3
            D 5
            R 5
            D 6
            R 9
            L 9
            D 3
            L 3
            U 4
            L 9
            D 8
            L 1
            D 7
            L 6
            U 9
            R 5
            L 8
            D 4
            R 4
            D 9
            R 7
            D 2
            L 4
            U 10
            R 6
            D 2
            R 9
            U 6
            D 2
            R 7
            L 6
            U 8
            D 6
            U 5
            L 1
            R 3
            D 9
            U 2
            D 9
            L 2
            R 6
            L 4
            U 8
            L 10
            D 11
            L 2
            R 6
            U 9
            L 7
            D 1
            U 10
            R 3
            L 10
            U 1
            R 7
            L 2
            U 3
            D 4
            U 10
            D 8
            R 6
            D 2
            U 7
            L 1
            U 5
            D 3
            U 11
            D 1
            R 9
            U 7
            R 5
            L 6
            U 10
            D 7
            U 2
            D 8
            R 10
            D 10
            U 5
            D 2
            U 4
            R 2
            L 10
            U 8
            L 5
            R 3
            U 6
            R 6
            U 2
            R 8
            L 2
            D 6
            R 11
            D 3
            U 6
            D 6
            R 1
            U 4
            D 8
            L 5
            R 11
            D 3
            U 6
            R 1
            L 7
            D 8
            R 7
            L 6
            R 4
            L 1
            U 4
            R 2
            L 3
            R 4
            U 2
            R 8
            L 7
            U 1
            D 11
            L 5
            U 10
            D 3
            L 4
            D 9
            U 8
            R 10
            L 10
            R 4
            D 1
            U 1
            L 6
            D 11
            L 9
            U 1
            D 1
            L 10
            U 11
            R 4
            L 9
            D 5
            U 6
            L 3
            R 5
            U 4
            R 9
            D 11
            L 5
            U 6
            L 2
            D 8
            R 2
            L 10
            U 9
            D 8
            R 10
            D 5
            U 6
            R 2
            L 11
            D 1
            R 4
            D 6
            U 3
            D 12
            L 3
            D 9
            R 2
            L 9
            U 2
            D 3
            L 2
            D 3
            L 8
            D 9
            U 10
            D 8
            R 11
            U 9
            L 4
            U 8
            L 6
            D 12
            L 5
            U 2
            L 5
            R 5
            U 7
            L 4
            U 1
            L 10
            D 6
            R 3
            L 4
            U 1
            L 3
            D 8
            U 1
            D 6
            L 6
            R 9
            D 7
            U 12
            R 12
            U 12
            L 3
            R 4
            L 3
            D 7
            U 3
            D 12
            U 8
            L 10
            D 11
            R 3
            U 3
            L 11
            U 3
            R 11
            U 6
            R 10
            U 11
            D 4
            R 8
            L 2
            U 3
            D 9
            L 3
            R 7
            D 10
            L 11
            R 9
            L 1
            D 3
            R 1
            D 2
            L 4
            R 4
            L 11
            D 7
            L 7
            U 6
            L 12
            R 2
            L 8
            D 9
            U 5
            L 11
            R 1
            U 12
            R 5
            L 5
            D 11
            R 12
            L 10
            R 8
            D 3
            U 9
            R 6
            L 3
            U 13
            D 13
            L 9
            U 6
            D 6
            U 9
            L 9
            R 4
            L 13
            R 2
            U 10
            L 4
            U 7
            D 8
            U 8
            L 3
            U 10
            L 6
            D 1
            R 10
            U 2
            R 12
            L 5
            R 7
            L 11
            D 1
            R 2
            D 4
            R 5
            L 5
            U 2
            D 10
            U 5
            R 6
            U 10
            R 3
            U 13
            R 9
            D 2
            L 4
            R 11
            U 3
            D 6
            R 10
            D 4
            L 1
            U 4
            D 1
            U 12
            D 5
            L 8
            U 3
            R 11
            U 12
            L 11
            R 8
            L 4
            R 12
            D 3
            L 11
            R 1
            L 12
            R 2
            D 10
            R 10
            L 4
            U 4
            D 4
            U 7
            D 6
            L 9
            R 12
            L 7
            D 2
            R 11
            L 5
            D 8
            L 3
            D 1
            L 5
            R 7
            L 10
            U 9
            R 11
            D 13
            L 12
            R 9
            D 1
            L 2
            D 13
            L 5
            R 10
            D 12
            R 10
            L 13
            R 8
            L 5
            R 9
            U 1
            R 3
            D 4
            U 6
            D 2
            L 6
            U 1
            D 8
            U 9
            D 2
            R 9
            D 10
            U 12
            L 14
            U 4
            L 6
            D 3
            U 7
            R 5
            D 13
            R 1
            D 11
            U 10
            L 1
            U 3
            L 9
            U 2
            L 14
            D 14
            L 11
            R 9
            L 12
            R 10
            D 14
            R 3
            D 10
            R 3
            U 3
            D 13
            L 6
            D 5
            L 7
            U 14
            D 7
            U 13
            L 12
            U 13
            R 7
            L 4
            D 8
            R 3
            U 7
            L 1
            D 14
            U 7
            D 12
            U 12
            D 5
            L 3
            U 5
            D 13
            U 12
            L 9
            R 8
            D 8
            R 4
            U 11
            R 10
            D 8
            L 6
            R 7
            D 12
            U 10
            L 10
            D 8
            L 9
            R 11
            D 8
            L 10
            D 14
            L 6
            R 6
            L 10
            R 10
            U 14
            R 4
            U 1
            R 3
            U 11
            L 3
            R 4
            D 11
            U 12
            D 6
            L 5
            R 3
            D 4
            U 4
            D 10
            R 11
            D 10
            L 2
            D 7
            L 6
            D 2
            R 9
            L 1
            R 3
            D 1
            U 10
            D 14
            L 9
            D 8
            U 7
            D 12
            R 2
            U 3
            D 9
            L 5
            D 8
            R 15
            U 6
            L 10
            R 1
            D 3
            U 5
            R 10
            U 5
            L 1
            U 9
            D 9
            R 8
            D 7
            U 1
            R 12
            U 15
            D 2
            U 9
            L 7
            D 11
            R 10
            U 8
            L 8
            D 2
            L 1
            R 2
            L 11
            D 1
            R 8
            D 3
            L 3
            D 15
            R 9
            U 3
            L 13
            U 3
            D 6
            L 7
            R 8
            D 10
            U 6
            R 15
            D 8
            U 1
            D 2
            R 6
            U 2
            R 5
            L 8
            D 12
            U 1
            L 4
            D 1
            R 5
            L 14
            R 9
            L 9
            U 9
            L 11
            U 8
            R 2
            U 4
            D 2
            R 12
            U 13
            D 10
            L 10
            D 5
            L 9
            R 10
            L 10
            R 14
            L 6
            D 8
            R 4
            D 2
            L 11
            R 1
            U 11
            R 9
            L 13
            D 9
            L 14
            R 15
            U 15
            L 6
            U 3
            D 15
            L 5
            D 4
            U 2
            L 4
            D 7
            L 14
            R 2
            L 5
            U 8
            L 3
            U 10
            R 7
            L 12
            U 13
            L 14
            R 3
            U 13
            L 13
            U 16
            D 10
            R 10
            U 8
            L 4
            R 9
            D 4
            L 4
            U 4
            D 10
            L 11
            R 1
            L 11
            U 11
            R 2
            U 11
            R 7
            L 6
            D 6
            U 11
            L 5
            U 8
            R 8
            L 7
            R 11
            D 2
            R 4
            L 16
            U 10
            D 2
            U 2
            R 13
            U 7
            L 2
            R 7
            U 13
            R 3
            L 7
            R 10
            D 10
            L 3
            R 13
            L 10
            U 11
            L 8
            R 14
            U 7
            D 15
            L 9
            R 6
            L 6
            R 16
            D 10
            L 13
            R 5
            L 7
            D 1
            R 3
            D 16
            U 11
            R 16
            L 15
            U 10
            R 6
            D 7
            R 3
            D 4
            L 1
            D 11
            R 14
            U 16
            L 14
            U 11
            L 16
            R 10
            L 10
            U 16
            R 12
            L 6
            U 3
            R 5
            L 10
            U 3
            D 16
            L 15
            U 8
            L 7
            R 12
            L 2
            U 15
            L 1
            D 9
            U 7
            D 8
            L 2
            R 14
            L 9
            D 2
            U 7
            R 2
            D 8
            U 9
            L 4
            D 9
            U 6
            L 13
            D 15
            L 2
            D 15
            L 10
            R 7
            D 10
            L 4
            U 16
            D 7
            R 8
            D 13
            R 4
            L 5
            U 8
            R 15
            U 10
            R 17
            U 8
            L 5
            D 11
            L 2
            U 13
            D 12
            L 3
            U 4
            R 16
            D 4
            L 5
            D 3
            L 16
            R 16
            L 16
            U 10
            L 13
            R 14
            L 7
            U 3
            D 15
            U 11
            D 8
            L 3
            D 3
            U 6
            D 14
            U 1
            L 3
            D 7
            U 14
            R 17
            U 1
            R 16
            U 11
            R 17
            D 10
            R 8
            D 5
            L 14
            R 1
            L 3
            D 17
            R 4
            U 9
            D 1
            U 13
            R 4
            L 3
            U 9
            R 11
            U 5
            R 5
            D 14
            U 12
            L 7
            R 2
            L 15
            D 17
            R 16
            D 3
            L 8
            D 11
            L 1
            U 2
            D 7
            L 11
            R 14
            L 5
            R 17
            U 11
            L 12
            D 14
            L 11
            D 13
            L 12
            R 1
            D 11
            R 2
            L 2
            D 17
            U 5
            R 4
            D 14
            L 14
            D 9
            L 13
            D 12
            R 2
            L 10
            R 7
            U 11
            L 16
            U 12
            R 9
            U 1
            R 17
            U 4
            L 7
            U 1
            L 7
            R 1
            D 5
            L 8
            U 11
            D 4
            U 5
            L 15
            D 3
            L 6
            R 4
            D 1
            R 9
            L 18
            R 6
            L 6
            U 16
            R 16
            D 16
            L 1
            U 13
            R 16
            D 6
            R 15
            U 8
            D 14
            U 5
            D 16
            U 14
            L 13
            R 18
            L 6
            U 5
            R 14
            U 18
            L 10
            D 3
            U 5
            D 15
            R 1
            L 12
            R 1
            L 9
            U 8
            L 14
            U 9
            L 9
            D 5
            R 3
            L 8
            D 18
            L 13
            D 15
            R 15
            U 4
            D 17
            L 17
            U 9
            R 1
            L 13
            R 8
            D 9
            U 15
            L 11
            D 6
            L 14
            D 6
            L 6
            U 8
            D 18
            U 3
            R 1
            L 18
            U 16
            L 11
            D 6
            L 16
            U 13
            R 15
            U 10
            D 4
            L 3
            D 1
            U 1
            L 9
            U 16
            L 8
            R 8
            D 2
            U 13
            R 15
            U 9
            L 7
            D 11
            R 17
            D 8
            U 9
            R 7
            D 7
            R 6
            L 10
            U 5
            L 3
            D 4
            L 1
            U 15
            R 8
            U 17
            L 2
            R 9
            U 15
            D 7
            R 3
            L 10
            U 18
            L 16
            R 15
            L 1
            R 18
            L 8
            D 15
            U 6
            D 11
            R 11
            U 7
            R 9
            L 10
            D 7
            L 7
            U 13
            R 14
            U 9
            D 13
            R 11
            U 17
            D 13
            R 17
            D 19
            L 9
            U 12
            L 16
            D 9
            U 15
            R 5
            D 13
            L 17
            D 3
            R 18
            D 12
            U 9
            D 13
            R 7
            U 18
            R 1
            U 10
            R 11
            U 15
            L 5
            D 15
            R 10
            D 18
            L 8
            U 4
            D 15
            R 11
            U 11
            D 17
            U 2
            R 6
            U 13
            R 8
            D 9
            U 19
            D 8
            U 5
            D 10
            U 18
            L 7
            D 2
            R 13
            D 11
            R 14
            L 14
            R 11
            U 11
            D 13
            L 4
            R 2
            U 18
            L 4
            D 3
            L 15
            U 6
            R 16
            L 13
            D 3
            U 14
            R 5
            U 15
            L 7
            R 5
            U 11
            L 16
            R 5
            L 1
            U 9
            D 7
            R 8
            L 11
            R 6
            L 16
            U 19
            R 2
            D 10
            L 15
            D 7
            U 19
            D 1
            U 5
            L 3
        """.trimIndent()
    }
}