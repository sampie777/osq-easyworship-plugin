package nl.sajansen.easyworship.queItems

import GUI
import plugins.common.BasePlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipNextSongQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Next song") {
    override fun activate() {
        EasyWorship.doNextSong()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}