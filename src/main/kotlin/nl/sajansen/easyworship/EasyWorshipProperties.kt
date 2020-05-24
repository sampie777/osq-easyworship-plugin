package nl.sajansen.easyworship

import getCurrentJarDirectory
import java.awt.event.KeyEvent
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*
import java.util.logging.Logger

object EasyWorshipProperties {
    private val logger = Logger.getLogger(EasyWorshipProperties.toString())

    // En-/disables the creation of a properties file and writing to a properties file.
    // Leave disabled when running tests.
    var writeToFile: Boolean = false

    private val propertiesFilePath =
            getCurrentJarDirectory(this).absolutePath + File.separatorChar + "osq-easyworship.properties"
    private val properties = Properties()

    var previousVerseKey: String = ""
    var nextVerseKey: String = ""
    var previousSongKey: String = ""
    var nextSongKey: String = ""
    var logoScreenKey: String = ""
    var blackScreenKey: String = ""
    var clearScreenKey: String = ""

    fun load() {
        logger.info("Loading easyworship properties")

        if (File(propertiesFilePath).exists()) {
            FileInputStream(propertiesFilePath).use { properties.load(it) }
        } else {
            logger.info("No easyworship properties file found, using defaults")
        }

        previousVerseKey =
            getFirstKeyCode(
                properties.getProperty(
                    "SlidePrevKeys",
                    KeyEvent.VK_UP.toString()
                )
            )
        nextVerseKey =
            getFirstKeyCode(
                properties.getProperty(
                    "SlideNextKeys",
                    KeyEvent.VK_DOWN.toString()
                )
            )
        previousSongKey =
            getFirstKeyCode(
                properties.getProperty(
                    "SchedulePrevKeys",
                    KeyEvent.VK_PAGE_UP.toString()
                )
            )
        nextSongKey =
            getFirstKeyCode(
                properties.getProperty(
                    "GoLiveNextKeys",
                    KeyEvent.VK_PAGE_DOWN.toString()
                )
            )
        logoScreenKey =
            getFirstKeyCode(
                properties.getProperty(
                    "LogoScreenKeys",
                    "C-" + KeyEvent.VK_L.toString()
                )
            )
        blackScreenKey =
            getFirstKeyCode(
                properties.getProperty(
                    "BlackScreenKeys",
                    "C-" + KeyEvent.VK_B.toString()
                )
            )
        clearScreenKey =
            getFirstKeyCode(
                properties.getProperty(
                    "ClearScreenKeys",
                    "C-" + KeyEvent.VK_C.toString()
                )
            )

        if (!File(propertiesFilePath).exists()) {
            save()
        }
    }

    fun save() {
        logger.info("Saving easyworship properties")
        properties.setProperty("SlidePrevKeys",
            previousVerseKey
        )
        properties.setProperty("SlideNextKeys",
            nextVerseKey
        )
        properties.setProperty("SchedulePrevKeys",
            previousSongKey
        )
        properties.setProperty("GoLiveNextKeys",
            nextSongKey
        )
        properties.setProperty("LogoScreenKeys",
            logoScreenKey
        )
        properties.setProperty("BlackScreenKeys",
            blackScreenKey
        )
        properties.setProperty("ClearScreenKeys",
            clearScreenKey
        )

        if (!writeToFile) {
            return
        }

        logger.info("Creating easyworship properties file")

        FileOutputStream(propertiesFilePath).use { fileOutputStream ->
            properties.store(
                    fileOutputStream,
                    "User properties for EasyWorship plugin"
            )
        }
    }

    fun getFirstKeyCode(value: String): String = value.split(",").first().trim()
}