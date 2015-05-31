package com.aa.mod.blocks;

import com.aa.mod.JordTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.common.block.BloodRune;

public class manaRune extends BloodRune {
    public manaRune()
    {
        super();
        this.setBlockName("manaRune");
        setCreativeTab(JordTab.JordTab);
        setHardness(2.0F);
        setResistance(5.0F);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon("arcanearteries:manaRune");

    }
}
