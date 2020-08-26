package nl.sajansen.easyworship

import java.util.*

object PluginInfo {
    private val properties = Properties()
    val version: String
    val author: String

    init {
        properties.load(EasyWorshipPlugin::class.java.getResourceAsStream("/nl/sajansen/easyworship/easyworshipplugin.properties"))
        version = properties.getProperty("version")
        author = properties.getProperty("author")
    }

}