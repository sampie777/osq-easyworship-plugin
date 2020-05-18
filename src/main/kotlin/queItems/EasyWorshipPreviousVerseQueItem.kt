package queItems

import GUI
import plugins.common.BasePlugin
import EasyWorship

class EasyWorshipPreviousVerseQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Previous verse") {
    override fun activate() {
        EasyWorship.doPreviousVerse()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}