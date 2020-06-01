package nl.sajansen.easyworship.queItems

import GUI
import nl.sajansen.easyworship.EasyWorshipPlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipPreviousSongQueItem(plugin: EasyWorshipPlugin) : EasyWorshipQueItem(plugin, "Previous song") {

    override fun activateAsPrevious() {
        EasyWorship.doNextSong()
        GUI.currentFrame?.toFront()
    }

    override fun activate() {
        EasyWorship.doPreviousSong()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}