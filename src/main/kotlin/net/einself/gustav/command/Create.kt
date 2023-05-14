package net.einself.gustav.command

import net.einself.gustav.calculator.Calculator
import java.io.File

class Create(private val calculator: Calculator) : Command() {
    override fun run() {
        files(path).forEach { rename(it) }
    }

    private fun rename(file: File) {
        val checksum = calculator.calculate(file)
        val newName = "${file.parentFile.absolutePath}/${file.nameWithoutExtension}-$checksum.${file.extension}"
        file.renameTo(File(newName))
    }
}