import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import command.Cleanup
import command.Create
import command.Verify

class App : CliktCommand(name = "gustav") {
    override fun run()= Unit
}

fun main(args: Array<String>) {
    App().subcommands(Cleanup(), Create(), Verify()).main(args)
}



