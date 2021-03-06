package nl.sajansen.easyworship

import com.sun.jna.Native
import com.sun.jna.Pointer
import com.sun.jna.platform.win32.User32
import com.sun.jna.platform.win32.WinDef
import com.sun.jna.platform.win32.WinUser
import objects.notifications.Notifications
import java.awt.AWTException
import java.awt.Robot
import java.awt.event.KeyEvent
import java.util.logging.Logger

class WindowFinder(private val windowTitle: String) : WinUser.WNDENUMPROC {
    private val logger = Logger.getLogger(WindowFinder::class.java.name)

    var windowHandle: WinDef.HWND? = null
    var count: Int = 0

    override fun callback(hWnd: WinDef.HWND, arg1: Pointer?): Boolean {
        val windowText = CharArray(512)
        User32.INSTANCE.GetWindowText(hWnd, windowText, 512)
        val wText = Native.toString(windowText)

        if (wText.isEmpty()) {
            return true
        }

        if (wText.toLowerCase().contains(windowTitle)) {
            windowHandle = hWnd
            return false
        }
        return true
    }
}

object EasyWorship {
    private val logger = Logger.getLogger(EasyWorship::class.java.name)

    private const val windowContainsText = "EasyWorship 2009"

    private var windowHandle: WinDef.HWND? = null
    private val robot = Robot()

    private fun findWindowHandle(windowTitle: String): Boolean {
        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            logger.warning("Must run on Windows to find the window")
            Notifications.add("Plugin must run on Windows operating system", "EasyWorship")
            return false
        }

        val windowFinder = WindowFinder(windowTitle.toLowerCase())
        User32.INSTANCE.EnumWindows(windowFinder, null)
        windowHandle = windowFinder.windowHandle

        if (windowHandle != null) {
            return true
        }

        logger.warning("Failed to find window: $windowTitle")
        Notifications.add("Could not find '$windowTitle' window", "EasyWorship")
        return false
    }

    fun doPreviousVerse(amount: Int = 1) {
        if (!focus()) {
            return
        }

        for (step in 1..amount) {
            previousVerse()
        }
    }

    fun doNextVerse(amount: Int = 1) {
        if (!focus()) {
            return
        }

        for (step in 1..amount) {
            nextVerse()
        }
    }

    fun doPreviousSong(amount: Int = 1) {
        if (!focus()) {
            return
        }

        for (step in 1..amount) {
            previousSong()
        }
    }

    fun doNextSong(amount: Int = 1) {
        if (!focus()) {
            return
        }

        for (step in 1..amount) {
            nextSong()
        }
    }

    fun doLogoScreen() {
        if (!focus()) {
            return
        }

        logoScreen()
    }

    fun doBlackScreen() {
        if (!focus()) {
            return
        }

        blackScreen()
    }

    fun doClearScreen() {
        if (!focus()) {
            return
        }

        clearScreen()
    }

    private fun focus(): Boolean {
        logger.info("Focus window")
        if (!findWindowHandle(windowContainsText) || windowHandle == null) {
            return false
        }

        User32.INSTANCE.SetForegroundWindow(windowHandle)
        User32.INSTANCE.SetFocus(windowHandle)
        return true
    }

    private fun previousVerse() {
        logger.info("Set previous verse")
        keyPressString(EasyWorshipProperties.previousVerseKey)
    }

    private fun nextVerse() {
        logger.info("Set next verse")
        keyPressString(EasyWorshipProperties.nextVerseKey)
    }

    private fun previousSong() {
        logger.info("Set previous song")
        keyPressString(EasyWorshipProperties.previousSongKey)
        keyPressString(EasyWorshipProperties.previousSongKey)
        keyPressString(EasyWorshipProperties.nextSongKey)
    }

    private fun nextSong() {
        logger.info("Set next song")
        keyPressString(EasyWorshipProperties.nextSongKey)
    }

    private fun logoScreen() {
        logger.info("Toggle logo screen")
        keyPressString(EasyWorshipProperties.logoScreenKey)
    }

    private fun blackScreen() {
        logger.info("Toggle black scree")
        keyPressString(EasyWorshipProperties.blackScreenKey)
    }

    private fun clearScreen() {
        logger.info("Toggle clear scree")
        keyPressString(EasyWorshipProperties.clearScreenKey)
    }

    private fun keyPressString(key: String, sleepTime: Int = 50) {
        if (key.isBlank()) {
            logger.info("Empty key; not executing keypress")
            return
        }

        keyPress(
            key.substringAfter("-").toInt(),
            sleepTime,
            ctrl = key.startsWith("C-")
        )
    }

    private fun keyPress(key: Int, sleepTime: Int = 50, ctrl: Boolean = false) {
        try {
            if (ctrl) {
                robot.keyPress(KeyEvent.VK_CONTROL)
            }
            robot.keyPress(key)
            robot.delay(sleepTime)
            robot.keyRelease(key)
            if (ctrl) {
                robot.keyRelease(KeyEvent.VK_CONTROL)
            }
        } catch (e: AWTException) {
            e.printStackTrace()
        }
    }
}