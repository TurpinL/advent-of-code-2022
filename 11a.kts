val isTest = true

val monkeys = input()

repeat(20) {
    monkeys.forEach { monkey ->
        monkey.items.forEach {
            monkey.inspectionCount++
            val item = monkey.operation(it) / 3

            if (monkey.test(item)) {
                monkeys[monkey.ifTrue].items.add(item)
            } else {
                monkeys[monkey.ifFalse].items.add(item)
            }
        }

        monkey.items.clear()
    }
}

monkeys.forEachIndexed { index, monkey ->
    println("$index - ${monkey.items} - ${monkey.inspectionCount}")
}

println("================= Part 1 =================")
println("Answer:")
monkeys.map { it.inspectionCount }
    .sortedDescending()
    .take(2)
    .reduce { a, b -> a * b }

println("================= Part 2 =================")
println("Answer:")

class Monkey(
    var items: MutableList<Int>,
    val operation: (Int) -> Int,
    val test: (Int) -> Boolean,
    val ifTrue: Int,
    val ifFalse: Int,
    var inspectionCount: Int = 0,
)

fun input(): List<Monkey> {
    return if (isTest) {
        listOf(
            Monkey(
                items = mutableListOf(79, 98),
                operation = { it * 19 },
                test = { it % 23 == 0 },
                ifTrue = 2,
                ifFalse = 3,
            ),
            Monkey(
                items = mutableListOf(54, 65, 75, 74),
                operation = { it + 6 },
                test = { it % 19 == 0 },
                ifTrue = 2,
                ifFalse = 0,
            ),
            Monkey(
                items = mutableListOf(79, 60, 97),
                operation = { it * it },
                test = { it % 13 == 0 },
                ifTrue = 1,
                ifFalse = 3,
            ),
            Monkey(
                items = mutableListOf(74),
                operation = { it + 3 },
                test = { it % 17 == 0 },
                ifTrue = 0,
                ifFalse = 1,
            )
        )
    } else {
        listOf(
            Monkey(
                items = mutableListOf(53, 89, 62, 57, 74, 51, 83, 97),
                operation = { it * 3 },
                test = { it % 13 == 0},
                ifTrue = 1,
                ifFalse = 5,
            ),

            Monkey(
                items = mutableListOf(85, 94, 97, 92, 56),
                operation = { it + 2 },
                test = { it % 19 == 0},
                ifTrue = 5,
                ifFalse = 2,
            ),

            Monkey(
                items = mutableListOf(86, 82, 82),
                operation = { it + 1 },
                test = { it % 11 == 0},
                ifTrue = 3,
                ifFalse = 4,
            ),

            Monkey(
                items = mutableListOf(94, 68),
                operation = { it + 5 },
                test = { it % 17 == 0},
                ifTrue = 7,
                ifFalse = 6,
            ),

            Monkey(
                items = mutableListOf(83, 62, 74, 58, 96, 68, 85),
                operation = { it + 4 },
                test = { it % 3 == 0},
                ifTrue = 3,
                ifFalse = 6,
            ),

            Monkey(
                items = mutableListOf(50, 68, 95, 82),
                operation = { it + 8 },
                test = { it % 7 == 0},
                ifTrue = 2,
                ifFalse = 4,
            ),

            Monkey(
                items = mutableListOf(75),
                operation = { it * 7 },
                test = { it % 5 == 0},
                ifTrue = 7,
                ifFalse = 0,
            ),

            Monkey(
                items = mutableListOf(92, 52, 85, 89, 68, 82),
                operation = { it * it },
                test = { it % 2 == 0},
                ifTrue = 0,
                ifFalse = 1,
            ),
            )
    }
}