package behavioralpatterns.observer

// Command Interface
interface Command {
    fun execute()
}

// Receiver Class (TV)
class TV {
    fun turnOn() {
        println("TV is ON")
    }

    fun turnOff() {
        println("TV is OFF")
    }
}

// Concrete Commands
class TurnOnCommand(private val tv: TV) : Command {
    override fun execute() {
        tv.turnOn()
    }
}

class TurnOffCommand(private val tv: TV) : Command {
    override fun execute() {
        tv.turnOff()
    }
}

// Invoker Class (RemoteControl)
class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}

// Client Code
fun main() {
    val tv = TV()
    val remote = RemoteControl()

    val turnOnCommand = TurnOnCommand(tv)
    val turnOffCommand = TurnOffCommand(tv)

    remote.setCommand(turnOnCommand)
    remote.pressButton() // Output: TV is ON

    remote.setCommand(turnOffCommand)
    remote.pressButton() // Output: TV is OFF
}
