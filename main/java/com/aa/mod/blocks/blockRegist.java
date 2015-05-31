package com.aa.mod.blocks;


import com.aa.mod.helpers.RegisterHelper;

import WayofTime.alchemicalWizardry.ModBlocks;
import WayofTime.alchemicalWizardry.common.block.BloodRune;
import WayofTime.alchemicalWizardry.common.items.ItemBloodRuneBlock;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class blockRegist {
	  
	
	public static BloodRune manaRune; 
	public static BloodRune thaumicRune; 
	
	    public static void Register(FMLPreInitializationEvent event) {
	    	
	    	manaRune = new manaRune();
	    	RegisterHelper.registerBlock(manaRune);
	    	
	    	thaumicRune = new thaumicRune();
	    	RegisterHelper.registerBlock(thaumicRune);
	 
	    
	    }

}
