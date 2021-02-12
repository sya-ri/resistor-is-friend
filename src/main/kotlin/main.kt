import kotlinx.browser.document

fun main() {
    document.write("Hello, world!")

    val resistors = Resistor.fromValues(10.0, 30.0, 68.0, 100.0, 300.0, 1.0 * 1000, 2.2 * 1000, 10.0 * 1000)
    printResistors(resistors)
    printResistors(ParallelResistor.find(resistors))
}

fun printResistors(resistors: Map<Double, Set<Resistor>>) {
    resistors.map { (key, value) ->
        "$key: ${value.joinToString(" ") { "[$it]" }}"
    }.joinToString("\n").let(::println)
}
