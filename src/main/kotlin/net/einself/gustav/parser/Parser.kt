package net.einself.gustav.parser

interface Parser {

    fun parse(filename: String): String?

}