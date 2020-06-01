package nl.sajansen.easyworship.queItems

import GUI
import nl.sajansen.easyworship.EasyWorshipPlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipLogoScreenQueItem(plugin: EasyWorshipPlugin) : EasyWorshipQueItem(plugin, "Toggle logo screen") {
    override fun activate() {
        EasyWorship.doLogoScreen()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}