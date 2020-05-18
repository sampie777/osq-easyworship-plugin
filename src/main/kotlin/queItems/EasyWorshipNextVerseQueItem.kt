package queItems

import GUI
import plugins.common.BasePlugin
import EasyWorship

class EasyWorshipNextVerseQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Next verse") {
    override fun activate() {
        EasyWorship.doNextVerse()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}