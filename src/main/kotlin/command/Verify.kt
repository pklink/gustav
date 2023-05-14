package command

import parser.Parser
import util.calculateChecksum
import java.io.File

class Verify(private val parser: Parser) : Command() {
    override fun run() {
        files(path).forEach { verify(it) }
    }

    private fun verify(file: File) {
        val givenChecksum = parser.parse(file.nameWithoutExtension)
        if (givenChecksum.isNullOrBlank()) {
            println("Cannot find checksum")
            return
        }

        val checksum = calculateChecksum(file)
        if (checksum == givenChecksum) {
            println("${file.nameWithoutExtension} - OK")
        } else {
            println("${file.nameWithoutExtension} - NOK (given: $givenChecksum, current: $checksum)")
        }
    }


}