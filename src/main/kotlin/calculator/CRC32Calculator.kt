package calculator

import java.io.File
import java.util.zip.CRC32

class CRC32Calculator : Calculator {

    override fun calculate(file: File): String {
        return CRC32()
            .apply { update(file.readBytes()) }
            .value.toString(16)
    }
}