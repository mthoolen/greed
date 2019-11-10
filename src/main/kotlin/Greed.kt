import kotlin.math.pow

class Greed {
    fun score(dies: List<Int>): Int {
        val groupedDies = (1..6).map { number -> DieGrouping(number, dies.count { it == number }) }
        return when {
            groupedDies.straight() -> 1200
            groupedDies.threePairs() -> 800
            else -> groupedDies.map { it.scoreDies() }.sum()
        }
    }

    private fun List<DieGrouping>.threePairs() = this.filter { it.count == 2 }.count() == 3
    private fun List<DieGrouping>.straight() = this.all { it.count == 1 }

    private data class DieGrouping(val eyes: Int, val count: Int) {
        internal fun scoreDies(): Int =
            when {
                threeOnes() -> 1000
                singleOne() -> 100
                singleFive() -> 50
                count in 3..6 -> scoreMultiple()
                else -> 0
            }

        private fun scoreMultiple(): Int = (2.toDouble().pow(-3 + count) * eyes * 100).toInt()
        private fun threeOnes() = count == 3 && eyes == 1
        private fun singleOne() = eyes == 1 && count == 1
        private fun singleFive() = eyes == 5 && count == 1
    }
}