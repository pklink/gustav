package net.einself.gustav.command

import net.einself.gustav.calculator.Calculator
import net.einself.gustav.parser.Parser
import java.io.File

class Verify(
    private val calculator: Calculator,
    private val parser: Parser
) : Command() {
    override fun run() {
        files(path).forEach { verify(it) }
    }

    private fun verify(file: File) {
        val givenChecksum = parser.parse(file.nameWithoutExtension)
        if (givenChecksum.isNullOrBlank()) {
            println("Cannot find checksum")
            return
        }

        val checksum = calculator.calculate(file)
        if (checksum == givenChecksum) {
            println("${file.nameWithoutExtension} - OK")
        } else {
            println("${file.nameWithoutExtension} - NOK (given: $givenChecksum, current: $checksum)")
        }
    }


}