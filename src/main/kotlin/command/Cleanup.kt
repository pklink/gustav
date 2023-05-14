package command

import util.parseChecksum
import java.io.File

class Cleanup : Command() {
    override fun run() {
        files(path).forEach { rename(it) }
    }
    private fun rename(file: File) {
        val checksum = parseChecksum(file.nameWithoutExtension)
        val nameWithoutExtension = file.nameWithoutExtension.replace("-$checksum", "", true)
        val newName = "${file.parentFile.absolutePath}/$nameWithoutExtension.${file.extension}"
        file.renameTo(File(newName))
    }
}