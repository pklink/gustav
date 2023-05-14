package net.einself.gustav.parser

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CRC32ParserTest {

    private val underTest = CRC32Parser()

    @ParameterizedTest
    @DisplayName("Should find CRC32 hash in filename")
    @CsvSource(value = [
        "foo-12345678,12345678",
        "foo-abcdefgh,abcdefgh",
        "foo-1a2b3c4d,1a2b3c4d"
    ])
    fun happy(filename: String, expected: String) {
        val result = underTest.parse(filename)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @DisplayName("Should not find CRC32 hash in filename")
    @ValueSource(
        strings = [
            "foo-123456789",
            "foo12345678",
            "foo",
            "foo",
            "foo-ABCDEFGH",
            "foo-äääääääµ",
        ]
    )
    fun notSoHappy(filename: String) {
        val result = underTest.parse(filename)
        assertNull(result)
    }
}