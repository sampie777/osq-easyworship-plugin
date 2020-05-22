import objects.que.JsonQue
import queItems.EasyWorshipNextSongQueItem
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class EasyWorshipPluginTest {

    @Test
    fun testJsonToQueItem() {
        val plugin = EasyWorshipPlugin()
        val jsonQueItem = JsonQue.QueItem("", "EasyWorshipNextSongQueItem", "", false, HashMap())

        val queItem = plugin.jsonToQueItem(jsonQueItem)

        assertTrue(queItem is EasyWorshipNextSongQueItem)
        assertEquals(plugin, queItem.plugin)
    }

    @Test
    fun testEnable() {
        EasyWorshipProperties.writeToFile = false
        val plugin = EasyWorshipPlugin()

        plugin.enable()

        assertTrue(EasyWorshipProperties.writeToFile)
    }
}