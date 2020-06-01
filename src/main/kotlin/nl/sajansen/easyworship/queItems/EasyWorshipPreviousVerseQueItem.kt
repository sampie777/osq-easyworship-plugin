package nl.sajansen.easyworship.queItems

import GUI
import nl.sajansen.easyworship.EasyWorshipPlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipPreviousVerseQueItem(plugin: EasyWorshipPlugin) : EasyWorshipQueItem(plugin, "Previous verse") {

    override fun activateAsPrevious() {
        EasyWorship.doNextVerse()
        GUI.currentFrame?.toFront()
    }

    override fun activate() {
        EasyWorship.doPreviousVerse()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}