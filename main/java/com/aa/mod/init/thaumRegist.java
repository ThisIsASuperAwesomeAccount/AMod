package com.aa.mod.init;

import java.util.HashMap;

import com.aa.mod.blocks.blockRegist;
import com.aa.mod.config.ConfigFile;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionEnchantmentRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class thaumRegist {
	public static HashMap recipes = new HashMap();
	public static Item dagger = (Item) Item.itemRegistry.getObject("AWWayofTime:sacrificialKnife");
	
	 public static void Register(FMLPostInitializationEvent event) {
		 
		 ResearchCategories.registerCategory("ZARTERIES", new ResourceLocation("arcanearteries", "textures/items/thaumicKnife.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));


		 
		 if(ConfigFile.thaumcraftDagger){
			   recipes.put("Dagger", ThaumcraftApi.addInfusionCraftingRecipe("DAGGER", new ItemStack(itemRegist.thaumicKnife, 1), 2, (new AspectList()).add(Aspect.MAGIC, 10).add(Aspect.LIFE, 6), new ItemStack(dagger), new ItemStack[] { ItemApi.getItem("itemResource", 2),  ItemApi.getItem("itemResource", 2)}));                                                                                               
				 (new ResearchItem("DAGGER", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 4).add(Aspect.LIFE, 3).add(Aspect.MAGIC, 1), 0, 0, 2, new ResourceLocation("arcanearteries", "textures/items/thaumicKnife.png"))).setPages(new ResearchPage[] { new ResearchPage("aa.research_page.DAGGER"), new ResearchPage((InfusionRecipe) recipes.get("Dagger")) }).setParents(new String[] {}).registerResearchItem();
			 } 
		 
		 recipes.put("Slate", ThaumcraftApi.addInfusionCraftingRecipe("SLATE", new ItemStack(itemRegist.thaumicSlate, 3), 2, (new AspectList()).add(Aspect.MAGIC, 4).add(Aspect.LIFE, 2), new ItemStack(Blocks.stone), new ItemStack[] { ItemApi.getItem("itemResource", 2), new ItemStack(Blocks.stone), ItemApi.getItem("itemResource", 2), new ItemStack(Blocks.stone)}));                                                                                               
		 (new ResearchItem("SLATE", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 3).add(Aspect.LIFE, 2).add(Aspect.MAGIC, 1), 2, 1, 1, new ResourceLocation("arcanearteries", "textures/items/thaumicSlate.png"))).setPages(new ResearchPage[] { new ResearchPage("aa.research_page.SLATE"), new ResearchPage((InfusionRecipe) recipes.get("Slate")) }).setParents(new String[] {}).registerResearchItem();
		
			   recipes.put("Rune", ThaumcraftApi.addInfusionCraftingRecipe("RUNE", new ItemStack(blockRegist.thaumicRune, 1), 2, (new AspectList()).add(Aspect.MAGIC, 6).add(Aspect.LIFE, 7).add(Aspect.ORDER, 6), new ItemStack(Blocks.stone), new ItemStack[] { ItemApi.getItem("itemResource", 2), new ItemStack(itemRegist.thaumicSlate),  ItemApi.getItem("itemResource", 2), new ItemStack(itemRegist.thaumicSlate)}));                                                                                               
				 (new ResearchItem("RUNE", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 6).add(Aspect.LIFE, 10).add(Aspect.MAGIC, 4).add(Aspect.ORDER, 6), -3, -1, 1, new ResourceLocation("arcanearteries", "textures/blocks/thaumicRune.png"))).setPages(new ResearchPage[] { new ResearchPage("aa.research_page.Rune"), new ResearchPage((InfusionRecipe) recipes.get("Rune")) }).setParents(new String[] {}).registerResearchItem();
				 
			 
		 
	 }

}
