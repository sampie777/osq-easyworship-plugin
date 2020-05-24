package nl.sajansen.easyworship.queItems

import GUI
import plugins.common.BasePlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipNextVerseQueItem(plugin: BasePlugin) : EasyWorshipQueItem(plugin, "Next verse") {
    override fun activate() {
        EasyWorship.doNextVerse()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}