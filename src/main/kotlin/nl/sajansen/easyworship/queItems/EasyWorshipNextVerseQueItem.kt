package nl.sajansen.easyworship.queItems

import GUI
import nl.sajansen.easyworship.EasyWorshipPlugin
import nl.sajansen.easyworship.EasyWorship

class EasyWorshipNextVerseQueItem(plugin: EasyWorshipPlugin) : EasyWorshipQueItem(plugin, "Next verse") {

    override fun activateAsPrevious() {
        EasyWorship.doPreviousVerse()
        GUI.currentFrame?.toFront()
    }

    override fun activate() {
        EasyWorship.doNextVerse()
        GUI.currentFrame?.toFront()
    }

    override fun deactivate() {}
}