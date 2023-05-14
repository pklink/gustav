import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import command.Cleanup
import command.Create
import command.Verify
import parser.CRC32Parser

class App : CliktCommand(name = "gustav") {
    override fun run()= Unit
}

fun main(args: Array<String>) {
    val crC32Parser = CRC32Parser()
    App().subcommands(Cleanup(crC32Parser), Create(), Verify(crC32Parser)).main(args)
}



