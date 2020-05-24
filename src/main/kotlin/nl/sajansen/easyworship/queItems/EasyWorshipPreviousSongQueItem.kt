package nl.sajansen.easyworship.queItems

import GUI
import plugins.common.BasePlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipPreviousSongQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Previous song") {
    override fun activate() {
        EasyWorship.doPreviousSong()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}