package net.einself.gustav.command

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import java.io.File

abstract class Command() : CliktCommand() {
    protected val path by argument()
    protected fun files(path : String) = File(path).walk()
        .filter { it.isFile }
        .filter { !it.isHidden }
        .sortedBy { it.name }
}