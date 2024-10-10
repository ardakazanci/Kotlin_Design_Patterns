package behavioralpatterns.observer

class Printer(private val stringFormatterStrategy: (String) -> String) {

    fun printString(string: String) {
        println(stringFormatterStrategy(string))
    }
}

val lowerCaseFormatter: (String) -> String = { it.lowercase() }
val upperCaseFormatter = { it: String -> it.uppercase() }

fun main(){
    val inputString = "LOREM ipsum DOLOR sit amet"

    val lowerCasePrinter = Printer(lowerCaseFormatter)
    lowerCasePrinter.printString(inputString)

    val upperCasePrinter = Printer(upperCaseFormatter)
    upperCasePrinter.printString(inputString)

    val prefixPrinter = Printer { "Prefix: $it" }
    prefixPrinter.printString(inputString)
}