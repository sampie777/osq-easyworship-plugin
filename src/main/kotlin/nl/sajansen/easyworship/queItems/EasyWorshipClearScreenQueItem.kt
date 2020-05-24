package nl.sajansen.easyworship.queItems

import GUI
import plugins.common.BasePlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipClearScreenQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Toggle clear screen") {
    override fun activate() {
        EasyWorship.doClearScreen()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}