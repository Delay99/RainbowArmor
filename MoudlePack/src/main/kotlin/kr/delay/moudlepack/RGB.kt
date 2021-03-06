package kr.delay.moudlepack

import org.bukkit.Bukkit
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.plugin.Plugin

class RGB(private val main: Main) {
    var r = 255
    var g = 0
    var b = 0
    var rR = 0
    var rrR = 0
    var gG = 0
    var ggG = 0
    var bB = 0
    var bbB = 0

    fun sAC(p: Player) {
        Bukkit.getScheduler().runTaskTimer((main as Plugin), Runnable { if (main.eP.contains(p.uniqueId)) nC(p) }, 1L, 1L)
    }

    fun rrRGB(): Color {
        val i = 15
        val x = 255 / i
        if (gG <= x) {
            gG++
            g = (gG - 1) * i
        } else if (rrR <= x) {
            rrR++
            r = 255 - i * (rrR - 1)
        } else if (bB <= x) {
            bB++
            b = (bB - 1) * i
        } else if (ggG <= x) {
            ggG++
            g = 255 - i * (ggG - 1)
        } else if (rR <= x) {
            rR++
            r = (rR - 1) * i
        } else if (bbB <= x) {
            bbB++
            b = 255 - i * (bbB - 1)
        } else {
            rR = 0
            rrR = 0
            gG = 0
            ggG = 0
            bB = 0
            bbB = 0
        }
        return Color.fromRGB(r, g, b)
    }

    fun getIS(material: Material, color: Color): ItemStack {
        val itemStack = ItemStack(material, 1, 0.toShort())
        val itemMeta = itemStack.itemMeta
        (itemMeta as LeatherArmorMeta).setColor(color)
        itemMeta.setDisplayName("레인보우갑옷")
        itemMeta.addItemFlags(*ItemFlag.values())
        itemStack.itemMeta = itemMeta
        return itemStack
    }

    fun getIs(material: Material): ItemStack {
        return getIS(material, Color.fromRGB(r, g, b))
    }

    fun rCA(p: Player) {
        val pInv = p.inventory
        pInv.helmet = null
        pInv.chestplate = null
        pInv.leggings = null
        pInv.boots = null
    }

    fun rSPA(p: Player) {
        p.inventory.setArmorContents(main.pA[p.uniqueId] as Array<ItemStack>)
    }

    fun nC(p: Player) {
        val pInv = p.inventory
        val c = rrRGB()
        pInv.helmet = getIS(Material.LEATHER_HELMET, c)
        pInv.chestplate = getIS(Material.LEATHER_CHESTPLATE, c)
        pInv.leggings = getIS(Material.LEATHER_LEGGINGS, c)
        pInv.boots = getIS(Material.LEATHER_BOOTS, c)
    }
}