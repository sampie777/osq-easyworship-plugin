package nl.sajansen.easyworship.queItems

import GUI
import nl.sajansen.easyworship.EasyWorshipPlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipClearScreenQueItem(plugin: EasyWorshipPlugin) : EasyWorshipQueItem(plugin, "Toggle clear screen") {
    override fun activate() {
        EasyWorship.doClearScreen()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}