fun main() {
    fun part1(input: List<String>): Int {
        val processedInput = input.map { it ->
            it.split(" ").map { it.toInt() }
        }
        return processedInput.count(::isSafe)
    }

    fun part2(input: List<String>): Int {
        val processedInput = input.map { it ->
            it.split(" ").map { it.toInt() }
        }
        return processedInput.count { item ->
            item.indices.any { indexToRemoved ->
                val damped = item.filterIndexed { index, _ -> index != indexToRemoved }
                isSafe(damped)
            }
        }
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

private fun isSafe(report: List<Int>): Boolean {
    val diff = report.zipWithNext { a, b -> a - b }
    return diff.all { it in -3..3 } && (diff.all { it > 0 } || diff.all { it < 0 })
}