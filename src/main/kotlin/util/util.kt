package util

import java.io.File
import java.util.zip.CRC32

fun calculateChecksum(file: File): String {
    return CRC32()
        .apply { update(file.readBytes()) }
        .value.toString(16)
}


fun parseChecksum(name: String): String? {
    val regex = "-([a-z0-9_]+)".toRegex()
    return regex.find(name)?.groupValues
        ?.filter { it.length >= 2 }
        ?.let { it[1] }
}