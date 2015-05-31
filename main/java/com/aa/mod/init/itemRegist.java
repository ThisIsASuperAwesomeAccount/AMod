package com.aa.mod.init;

import com.aa.mod.JordTab;
import com.aa.mod.Main;
import com.aa.mod.Reference;
import com.aa.mod.config.ConfigFile;
import com.aa.mod.helpers.RegisterHelper;
import com.aa.mod.items.Slates;
import com.aa.mod.items.configDagger;
import com.aa.mod.items.knife;
import com.aa.mod.items.thaumicKnife;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;


public class itemRegist {


    static CreativeTabs Tab = JordTab.JordTab;

    //Daggers
    public static Item knife;
    public static Item thaumicKnife;
    public static Item configDagger;
    
    //Plates
    public static Item manaSlate;
    public static Item thaumicSlate;

  
    
    public static void Register(FMLPreInitializationEvent event) {
    	//Daggers
    	knife = new knife();
    	RegisterHelper.registerItem(knife);
    	
    	thaumicKnife = new thaumicKnife();
    	RegisterHelper.registerItem(thaumicKnife);
    	
    	if(!ConfigFile.razorBlade){
    	configDagger = new configDagger();
    	RegisterHelper.registerItem(configDagger);
    	}
    	
    	
    	//Slates
    	thaumicSlate = new Slates().setUnlocalizedName("thaumicSlate");
    	RegisterHelper.registerItem(thaumicSlate);
    	
    	manaSlate = new Slates().setUnlocalizedName("manaSlate");
    	RegisterHelper.registerItem(manaSlate);
    
    }
}
