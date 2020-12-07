package kr.delay.moudlepack

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.plugin.Plugin

class RListener(private val main: Main) : Listener {
    private val rgb: RGB?
    @EventHandler
    fun onPlayerQuit(e: PlayerQuitEvent) {
        val p = e.player
        main.eP.remove(p.uniqueId)
        if (main.pA.containsKey(p.uniqueId)) {
            rgb!!.rCA(p)
            rgb.rSPA(p)
        }
    }

    @EventHandler
    fun onItemDrop(e: PlayerDropItemEvent) {
        val p = e.player
        if (!main.eP.contains(p.uniqueId)) return
        val `is` = e.itemDrop.itemStack
        val im = `is`.itemMeta
        if (im!!.hasDisplayName() && im!!.displayName == "레인보우 갑옷") e.isCancelled = true
    }

    @EventHandler
    fun onInventoryClick(e: InventoryClickEvent) {
        val p = e.whoClicked as Player
        if (main.eP.contains(p.uniqueId) && e.slotType == InventoryType.SlotType.ARMOR) e.isCancelled = true
    }

    init {
        rgb = main.rGB
        main.server.pluginManager.registerEvents(this, (main as Plugin))
    }
}

