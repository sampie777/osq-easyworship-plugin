package nl.sajansen.easyworship.queItems

import GUI
import plugins.common.BasePlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipLogoScreenQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Toggle logo screen") {
    override fun activate() {
        EasyWorship.doLogoScreen()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}