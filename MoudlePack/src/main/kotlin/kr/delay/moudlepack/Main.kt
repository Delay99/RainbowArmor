package kr.delay.moudlepack

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class Main : JavaPlugin() {
    var rGB: RGB? = null
    @JvmField
    var eP = ArrayList<UUID>()
    @JvmField
    var pA = HashMap<UUID, Array<ItemStack>>()


    override fun onEnable() {
        initC()
        rC()
        rL()
        Bukkit.getConsoleSender().sendMessage("플러그인 활성화")
    }

    private fun initC() {
        rGB = RGB(this)
    }

    private fun rC() {
        RCommand(this)
    }

    private fun rL() {
        RListener(this)
    }

    override fun onDisable() {
        Bukkit.getOnlinePlayers().forEach { player: Player? ->
            if (pA.containsKey(player!!.uniqueId)) {
                rGB!!.rCA(player)
                rGB!!.rSPA(player)
            }
        }
        Bukkit.getConsoleSender().sendMessage("플러그인 비활성화")
    }
}