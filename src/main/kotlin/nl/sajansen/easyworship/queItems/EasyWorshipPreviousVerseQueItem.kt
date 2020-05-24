package nl.sajansen.easyworship.queItems

import GUI
import plugins.common.BasePlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipPreviousVerseQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Previous verse") {
    override fun activate() {
        EasyWorship.doPreviousVerse()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}