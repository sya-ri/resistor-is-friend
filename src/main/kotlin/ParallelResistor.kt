object ParallelResistor {
    fun find(list: Map<Double, Set<Resistor>>): Map<Double, Set<Resistor>> {
        val result = mutableMapOf<Double, MutableSet<Resistor>>()
        result.putAll(list.map { it.key to it.value.toMutableSet() })
        list.forEach { r1 ->
            list.forEach { r2 ->
                val combined = (r1.key * r2.key) / (r1.key + r2.key)
                result[combined] = result.getOrElse(combined) { mutableSetOf() }.apply {
                    r1.value.forEach { r1r ->
                        r2.value.forEach { r2r ->
                            val combinedPattern = r1r.resistors.toMutableMap()
                            r2r.resistors.forEach {
                                combinedPattern[it.key] = combinedPattern.getOrElse(it.key) { 0 } + 1
                            }
                            add(Resistor.Combined(combinedPattern))
                        }
                    }
                }
            }
        }
        return result
    }
}
