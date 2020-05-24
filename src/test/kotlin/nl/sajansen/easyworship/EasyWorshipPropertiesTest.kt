package nl.sajansen.easyworship

import kotlin.test.Test
import kotlin.test.assertEquals

class EasyWorshipPropertiesTest {
    @Test
    fun testGetFirstKeyCode() {
        assertEquals("13", EasyWorshipProperties.getFirstKeyCode("13, 12, 23"))
        assertEquals("13", EasyWorshipProperties.getFirstKeyCode(" 13  , 12, 23"))
        assertEquals("C-13", EasyWorshipProperties.getFirstKeyCode("C-13"))
        assertEquals("13", EasyWorshipProperties.getFirstKeyCode("13"))
        assertEquals("", EasyWorshipProperties.getFirstKeyCode(""))
    }
}