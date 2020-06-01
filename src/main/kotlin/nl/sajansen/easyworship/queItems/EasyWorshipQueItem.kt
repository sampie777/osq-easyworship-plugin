package nl.sajansen.easyworship.queItems

import nl.sajansen.easyworship.EasyWorshipPlugin
import objects.que.QueItem
import java.awt.Color

abstract class EasyWorshipQueItem(override val plugin: EasyWorshipPlugin, override val name: String) : QueItem {

    override var executeAfterPrevious = false
    override var quickAccessColor: Color? = plugin.quickAccessColor

    override fun toString() = name

    override fun toConfigString(): String {
        return name
    }
}