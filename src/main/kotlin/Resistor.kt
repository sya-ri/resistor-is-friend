sealed class Resistor {
    abstract val resistors: Map<Simple, Int>

    data class Simple(val value: Double) : Resistor() {
        override val resistors = mapOf(this to 1)

        override fun toString() = value.toString()
    }

    data class Combined(override val resistors: Map<Simple, Int>) : Resistor() {
        override fun toString() = resistors.entries.joinToString { "${it.key}(${it.value})" }
    }

    companion object {
        fun fromValues(vararg value: Double): Map<Double, Set<Resistor>> {
            return value.associate { it to setOf(Simple(it)) }
        }
    }
}
