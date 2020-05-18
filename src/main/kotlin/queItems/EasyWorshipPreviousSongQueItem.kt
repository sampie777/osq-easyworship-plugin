package queItems

import GUI
import plugins.common.BasePlugin
import EasyWorship

class EasyWorshipPreviousSongQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Previous song") {
    override fun activate() {
        EasyWorship.doPreviousSong()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}