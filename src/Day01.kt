import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Long {
        val (firstList, secondList) = input.map { line ->
            line.split("   ").map { it.toLong() }
        }.map { Pair(it[0], it[1]) }.unzip()
        val sortedFirstList = firstList.sorted()
        val sortedSecondList = secondList.sorted()
        return sortedFirstList.zip(sortedSecondList).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Long {
        val (firstList, secondList) = input.map { line ->
            line.split("   ").map { it.toLong() }
        }.map { Pair(it[0], it[1]) }.unzip()
        return firstList.sumOf {
            it * secondList.filter { secondListMember -> secondListMember == it }.size
        }
    }

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
