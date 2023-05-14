package net.einself.gustav

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import net.einself.gustav.calculator.CRC32Calculator
import net.einself.gustav.command.Cleanup
import net.einself.gustav.command.Create
import net.einself.gustav.command.Verify
import net.einself.gustav.parser.CRC32Parser

class App : CliktCommand(name = "gustav") {
    override fun run() = Unit
}

fun main(args: Array<String>) {
    val crC32Parser = CRC32Parser()
    val crC32Calculator = CRC32Calculator()
    App().subcommands(
        Cleanup(crC32Parser),
        Create(crC32Calculator),
        Verify(crC32Calculator, crC32Parser)
    ).main(args)
}



