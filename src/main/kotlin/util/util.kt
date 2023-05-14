package util

import java.io.File
import java.util.zip.CRC32

fun calculateChecksum(file: File): String {
    return CRC32()
        .apply { update(file.readBytes()) }
        .value.toString(16)
}

