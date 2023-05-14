package net.einself.gustav.parser

class CRC32Parser: Parser {

    override fun parse(filename: String): String? {
        return REGEX.find(filename)?.groupValues
            ?.filter { it.length >= 2 }
            ?.let { it[1] }
    }

    companion object {
        val REGEX = "-([a-z0-9_]{8}$)".toRegex()
    }
}