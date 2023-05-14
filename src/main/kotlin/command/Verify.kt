package command

import util.calculateChecksum
import util.parseChecksum
import java.io.File

class Verify : Command() {
    override fun run() {
        files(path).forEach { verify(it) }
    }

    private fun verify(file: File) {
        val givenChecksum = parseChecksum(file.nameWithoutExtension)
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