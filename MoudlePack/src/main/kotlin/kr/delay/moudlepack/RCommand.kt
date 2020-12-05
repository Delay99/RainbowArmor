package kr.delay.moudlepack

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class RCommand(private val main: Main) : CommandExecutor {
    private val rgb: RGB?

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("플레이어만 사용할 수 있습니다.")
            return true
        }
        val p = sender
        if (!p.isOp) {
            sender.sendMessage("당신은 권한이 없습니다.")
            return true
        } else {
            if (!main.eP.contains(p.uniqueId)) {
                main.eP.add(p.uniqueId)
                main.pA[p.uniqueId] = p.equipment!!.armorContents
                val pInv = p.inventory
                pInv.helmet = rgb!!.getIs(Material.LEATHER_HELMET)
                pInv.chestplate = rgb.getIs(Material.LEATHER_CHESTPLATE)
                pInv.leggings = rgb.getIs(Material.LEATHER_LEGGINGS)
                pInv.boots = rgb.getIs(Material.LEATHER_BOOTS)
                rgb.sAC(p)
                p.sendMessage("레인보우 갑옷 활성화")
            } else {
                main.eP.remove(p.uniqueId)
                rgb!!.rCA(p)
                rgb.rSPA(p)
                p.sendMessage("레인보우 갑옷 비활성화")
            }
        }
        return true
    }

    init {
        rgb = main.rGB
        Bukkit.getPluginCommand("레인보우갑옷")!!.setExecutor(this)
    }
}
