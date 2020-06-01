package nl.sajansen.easyworship.queItems

import GUI
import nl.sajansen.easyworship.EasyWorshipPlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipNextSongQueItem(plugin: EasyWorshipPlugin) : EasyWorshipQueItem(plugin, "Next song") {

    override fun activateAsPrevious() {
        EasyWorship.doPreviousSong()
        GUI.currentFrame?.toFront()
    }

    override fun activate() {
        EasyWorship.doNextSong()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}