package net.einself.gustav.command

import net.einself.gustav.parser.Parser
import java.io.File

class Cleanup(private val parser: Parser) : Command() {

    override fun run() {
        files(path).forEach { rename(it) }
    }
    private fun rename(file: File) {
        val checksum = parser.parse(file.nameWithoutExtension)
        val nameWithoutExtension = file.nameWithoutExtension.replace("-$checksum", "", true)
        val newName = "${file.parentFile.absolutePath}/$nameWithoutExtension.${file.extension}"
        println("${file.name} -> $nameWithoutExtension.${file.extension}")
        file.renameTo(File(newName))
    }
}