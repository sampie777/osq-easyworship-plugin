package nl.sajansen.easyworship

import handles.QueItemTransferHandler
import nl.sajansen.easyworship.queItems.*
import java.awt.datatransfer.Transferable
import javax.swing.JComponent
import javax.swing.JList

class EasyWorshipQueItemTransferHandler(private val plugin: EasyWorshipPlugin) : QueItemTransferHandler() {

    override fun createTransferable(component: JComponent): Transferable {
        val list = component as JList<*>
        val queItemClass = list.selectedValue as EasyWorshipQueItem

        queItem = when (queItemClass) {
            is EasyWorshipPreviousVerseQueItem -> EasyWorshipPreviousVerseQueItem(plugin)
            is EasyWorshipNextVerseQueItem -> EasyWorshipNextVerseQueItem(plugin)
            is EasyWorshipPreviousSongQueItem -> EasyWorshipPreviousSongQueItem(plugin)
            is EasyWorshipNextSongQueItem -> EasyWorshipNextSongQueItem(plugin)
            is EasyWorshipLogoScreenQueItem -> EasyWorshipLogoScreenQueItem(plugin)
            is EasyWorshipBlackScreenQueItem -> EasyWorshipBlackScreenQueItem(plugin)
            is EasyWorshipClearScreenQueItem -> EasyWorshipClearScreenQueItem(plugin)
            else -> null
        }

        return super.createTransferable(component)
    }
}