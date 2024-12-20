fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { sumMul(it) }
    }

    fun part2(input: List<String>): Int {
//        return input.map { it ->
//            it.split("do()").joinToString("") {
//                    it.substringBefore("don't()")
//                }
//        }.sumOf { sumMul(it) }
        return executeDisabled(input.joinToString { it })
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

private fun executeDisabled(instructions: String): Int =
    """(^|do\(\)).*?($|don't\(\))"""
        .toRegex()
        .findAll(instructions)
        .sumOf { executeMuls(it.value) }

private fun executeMuls(instructions: String): Int =
    """mul\((\d{1,3}),(\d{1,3})\)"""
        .toRegex()
        .findAll(instructions)
        .sumOf { match ->
            match.groupValues
                .drop(1)
                .map { it.toInt() }
                .reduce(Int::times)
        }

fun sumMul(line: String): Int {
    val regex = "mul\\(\\d*,\\d*\\)".toRegex()
    return regex.findAll(line).sumOf { matcher ->
        matcher.value.replace("mul(", "").replace(")", "").split(",").map { it.toInt() }.multiply()
    }
}