package behavioralpatterns.observer

import kotlin.properties.Delegates

interface TextChangeListener {
    fun onTextChanged(oldText: String, newText: String)
}

class PrintingTextChangeListener : TextChangeListener {

    private var text = ""

    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text changed from $oldText to $newText"
        println(text)
    }
}

class TextView {
    val listeners = mutableListOf<TextChangeListener>()

    var text : String by Delegates.observable("") { prop, old, new ->
        listeners.forEach {
            it.onTextChanged(old,new)
        }
    }
}

fun main() {

    val textView = TextView().apply {
        listeners.add(PrintingTextChangeListener())
    }

    with(textView){
        text = "Lorem ipsum dolor sit amet"
        text = "sit amet"
    }

}