package queItems

import plugins.common.BasePlugin
import plugins.common.QueItem

abstract class EasyWorshipQueItem(override val plugin: BasePlugin, override val name: String) : QueItem {

    override var executeAfterPrevious = false

    override fun toString() = name

    override fun toConfigString(): String {
        return name
    }
}