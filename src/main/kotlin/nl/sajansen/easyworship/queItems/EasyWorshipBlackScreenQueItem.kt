package nl.sajansen.easyworship.queItems

import GUI
import nl.sajansen.easyworship.EasyWorship
import nl.sajansen.easyworship.EasyWorshipPlugin

class EasyWorshipBlackScreenQueItem(plugin: EasyWorshipPlugin) : EasyWorshipQueItem(plugin, "Toggle black screen") {
    override fun activate() {
        EasyWorship.doBlackScreen()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}