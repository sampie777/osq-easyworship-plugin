package nl.sajansen.easyworship.queItems

import GUI
import plugins.common.BasePlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipBlackScreenQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Toggle black screen") {
    override fun activate() {
        EasyWorship.doBlackScreen()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}