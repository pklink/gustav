package net.einself.gustav.command

import net.einself.gustav.calculator.Calculator
import java.io.File

class Create(private val calculator: Calculator) : Command() {
    override fun run() {
        files(path).forEach { rename(it) }
    }

    private fun rename(file: File) {
        val checksum = calculator.calculate(file)
        val newFilename = "${file.nameWithoutExtension}-$checksum.${file.extension}"
        val newName = "${file.parentFile.absolutePath}/$newFilename"
        println("${file.name} -> $newFilename")
        file.renameTo(File(newName))
    }
}