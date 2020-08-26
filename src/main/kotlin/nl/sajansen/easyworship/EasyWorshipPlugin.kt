package nl.sajansen.easyworship

import gui.utils.createImageIcon
import gui.utils.DefaultSourcesList
import handles.QueItemTransferHandler
import objects.que.JsonQueue
import plugins.common.QueItemBasePlugin
import objects.que.QueItem
import nl.sajansen.easyworship.queItems.*
import java.awt.*
import java.net.URL
import java.util.logging.Logger
import javax.swing.*
import javax.swing.border.EmptyBorder

@Suppress("unused")
class EasyWorshipPlugin : QueItemBasePlugin {
    private val logger = Logger.getLogger(EasyWorshipPlugin::class.java.name)

    override val name = "EasyWorshipPlugin"
    override val description = "Queue items for integration with EasyWorship"
    override val version = PluginInfo.version

    override val icon: Icon? = createImageIcon("/nl/sajansen/easyworship/icon-14.png")

    override val tabName = "EasyWorship"
    internal val quickAccessColor = Color(239, 229, 255)

    override fun sourcePanel(): JComponent {
        val panel = JPanel(BorderLayout(10, 10))
        panel.border = EmptyBorder(10, 10, 0, 10)

        val titleLabel = JLabel("Actions")
        panel.add(titleLabel, BorderLayout.PAGE_START)

        val queItems = arrayOf(
            EasyWorshipPreviousSongQueItem(this),
            EasyWorshipNextSongQueItem(this),
            EasyWorshipPreviousVerseQueItem(this),
            EasyWorshipNextVerseQueItem(this),
            EasyWorshipLogoScreenQueItem(this),
            EasyWorshipBlackScreenQueItem(this),
            EasyWorshipClearScreenQueItem(this)
        )

        val list: JList<EasyWorshipQueItem> = DefaultSourcesList(queItems)
        list.transferHandler = EasyWorshipQueItemTransferHandler(this)

        val scrollPanel = JScrollPane(list)
        scrollPanel.preferredSize = Dimension(300, 500)
        scrollPanel.border = BorderFactory.createLineBorder(Color(180, 180, 180))
        panel.add(scrollPanel, BorderLayout.CENTER)

        return panel
    }

    override fun configStringToQueItem(value: String): QueItem {
        return when (value) {
            "Previous verse" -> EasyWorshipPreviousVerseQueItem(this)
            "Next verse" -> EasyWorshipNextVerseQueItem(this)
            "Previous song" -> EasyWorshipPreviousSongQueItem(this)
            "Next song" -> EasyWorshipNextSongQueItem(this)
            "Toggle logo screen" -> EasyWorshipLogoScreenQueItem(this)
            "Toggle black screen" -> EasyWorshipBlackScreenQueItem(this)
            "Toggle clear screen" -> EasyWorshipClearScreenQueItem(this)
            else -> throw IllegalArgumentException("Invalid EasyWorship queue item: $value")
        }
    }

    override fun jsonToQueItem(jsonQueItem: JsonQueue.QueueItem): QueItem {
        return when (jsonQueItem.className) {
            EasyWorshipPreviousVerseQueItem::class.java.simpleName -> EasyWorshipPreviousVerseQueItem(this)
            EasyWorshipNextVerseQueItem::class.java.simpleName -> EasyWorshipNextVerseQueItem(this)
            EasyWorshipPreviousSongQueItem::class.java.simpleName -> EasyWorshipPreviousSongQueItem(this)
            EasyWorshipNextSongQueItem::class.java.simpleName -> EasyWorshipNextSongQueItem(this)
            EasyWorshipLogoScreenQueItem::class.java.simpleName -> EasyWorshipLogoScreenQueItem(this)
            EasyWorshipBlackScreenQueItem::class.java.simpleName -> EasyWorshipBlackScreenQueItem(this)
            EasyWorshipClearScreenQueItem::class.java.simpleName -> EasyWorshipClearScreenQueItem(this)
            else -> throw IllegalArgumentException("Invalid EasyWorship queue item: ${jsonQueItem.className}")
        }
    }

    override fun enable() {
        super.enable()
        EasyWorshipProperties.writeToFile = true
        EasyWorshipProperties.load()
    }

    private fun createImageIcon(path: String): ImageIcon? {
        val imgURL: URL? = EasyWorshipPlugin::class.java.getResource(path)
        if (imgURL != null) {
            return ImageIcon(imgURL)
        }

        logger.severe("Couldn't find imageIcon: $path")
        return null
    }
}