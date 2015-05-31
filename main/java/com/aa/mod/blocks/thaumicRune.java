package com.aa.mod.blocks;

import net.minecraft.client.renderer.texture.IIconRegister;

import com.aa.mod.JordTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import WayofTime.alchemicalWizardry.common.block.BloodRune;

public class thaumicRune extends BloodRune {
    public thaumicRune()
    {
        super();
        this.setBlockName("thaumicRune");
        setCreativeTab(JordTab.JordTab);
        setHardness(2.0F);
        setResistance(5.0F);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("arcanearteries:thaumicRune");

    }
}
