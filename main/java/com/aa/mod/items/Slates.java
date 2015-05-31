package com.aa.mod.items;

import java.util.List;

import com.aa.mod.JordTab;
import com.aa.mod.init.itemRegist;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class Slates extends Item
{
    public Slates()
    {
        super();
        setMaxStackSize(64);
        setCreativeTab(JordTab.JordTab);
    }

    public void registerIcons(IIconRegister iconRegister)
    {
        if (this.equals(itemRegist.thaumicSlate))
        {
            this.itemIcon = iconRegister.registerIcon("arcanearteries:thaumicSlate");
        } else if (this.equals(itemRegist.manaSlate))
        {
            this.itemIcon = iconRegister.registerIcon("arcanearteries:manaSlate");
        }
    }

}
