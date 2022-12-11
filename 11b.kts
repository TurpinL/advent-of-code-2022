val isTest = false

val monkeys = input()

val commonDivisor = monkeys.map { it.divisor }.reduce { a, b -> a * b }

repeat(10000) {
    monkeys.forEach { monkey ->
        monkey.items.forEach {
            monkey.inspectionCount++
            val item = monkey.operation(it) % commonDivisor

            if (item % monkey.divisor == 0L) {
                monkeys[monkey.ifTrue].items.add(item)
            } else {
                monkeys[monkey.ifFalse].items.add(item)
            }
        }

        monkey.items.clear()
    }
}

println("================= Part 2 =================")
monkeys.forEachIndexed { index, monkey ->
    println("$index - ${monkey.inspectionCount} - ${monkey.items}")
}

println("Answer:")
monkeys.map { it.inspectionCount }
    .sortedDescending()
    .take(2)
    .reduce { a, b -> a * b }

class Monkey(
    var items: MutableList<Long>,
    val operation: (Long) -> Long,
    val divisor: Long,
    val ifTrue: Int,
    val ifFalse: Int,
    var inspectionCount: Long = 0,
)

fun input(): List<Monkey> {
    return if (isTest) {
        listOf(
            Monkey(
                items = mutableListOf(79, 98),
                operation = { it * 19 },
                divisor = 23,
                ifTrue = 2,
                ifFalse = 3,
            ),
            Monkey(
                items = mutableListOf(54, 65, 75, 74),
                operation = { it + 6 },
                divisor = 19,
                ifTrue = 2,
                ifFalse = 0,
            ),
            Monkey(
                items = mutableListOf(79, 60, 97),
                operation = { it * it },
                divisor = 13,
                ifTrue = 1,
                ifFalse = 3,
            ),
            Monkey(
                items = mutableListOf(74),
                operation = { it + 3 },
                divisor = 17,
                ifTrue = 0,
                ifFalse = 1,
            )
        )
    } else {
        listOf(
            Monkey(
                items = mutableListOf(53, 89, 62, 57, 74, 51, 83, 97),
                operation = { it * 3 },
                divisor = 13,
                ifTrue = 1,
                ifFalse = 5,
            ),

            Monkey(
                items = mutableListOf(85, 94, 97, 92, 56),
                operation = { it + 2 },
                divisor = 19,
                ifTrue = 5,
                ifFalse = 2,
            ),

            Monkey(
                items = mutableListOf(86, 82, 82),
                operation = { it + 1 },
                divisor = 11,
                ifTrue = 3,
                ifFalse = 4,
            ),

            Monkey(
                items = mutableListOf(94, 68),
                operation = { it + 5 },
                divisor = 17,
                ifTrue = 7,
                ifFalse = 6,
            ),

            Monkey(
                items = mutableListOf(83, 62, 74, 58, 96, 68, 85),
                operation = { it + 4 },
                divisor = 3,
                ifTrue = 3,
                ifFalse = 6,
            ),

            Monkey(
                items = mutableListOf(50, 68, 95, 82),
                operation = { it + 8 },
                divisor = 7,
                ifTrue = 2,
                ifFalse = 4,
            ),

            Monkey(
                items = mutableListOf(75),
                operation = { it * 7 },
                divisor = 5,
                ifTrue = 7,
                ifFalse = 0,
            ),

            Monkey(
                items = mutableListOf(92, 52, 85, 89, 68, 82),
                operation = { it * it },
                divisor = 2,
                ifTrue = 0,
                ifFalse = 1,
            ),
        )
    }
}