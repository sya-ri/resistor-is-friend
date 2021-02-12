sealed class Resistor {
    data class Simple(val value: Double) : Resistor() {
        override fun toString() = value.toString()
    }

    data class Combined(val pair: Pair<Resistor, Resistor>) : Resistor() {
        override fun toString() = pair.first.toString() + ", " + pair.second.toString()
    }

    companion object {
        fun fromValues(vararg value: Double): Map<Double, Set<Simple>> {
            return value.associate { it to setOf(Simple(it)) }
        }
    }
}
