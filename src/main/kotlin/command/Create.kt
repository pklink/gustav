package command

import util.calculateChecksum
import java.io.File

class Create : Command() {
    override fun run() {
        files(path).forEach { rename(it) }
    }

    private fun rename(file: File) {
        val checksum = calculateChecksum(file)
        val newName = "${file.parentFile.absolutePath}/${file.nameWithoutExtension}-$checksum.${file.extension}"
        file.renameTo(File(newName))
    }
}