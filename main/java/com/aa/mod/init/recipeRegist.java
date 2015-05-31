package com.aa.mod.init;

import thaumcraft.api.ItemApi;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.api.recipe.RecipeRuneAltar;
import vazkii.botania.common.lib.LibOreDict;
import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;

import com.aa.mod.Reference;
import com.aa.mod.blocks.blockRegist;
import com.aa.mod.config.ConfigFile;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class recipeRegist {
	
	public static RecipeRuneAltar botaniaDaggerRecipe;
	public static RecipeManaInfusion manaSlateRecipe;

    public static void Register() {
      /*
        if(!ConfigFile.visViewer){
        if(Loader.isModLoaded("Thaumcraft")){
        	Item goggles = (Item) Item.itemRegistry.getObject("Thaumcraft:ItemGoggles");
        	GameRegistry.addShapelessRecipe(new ItemStack(itemRegist.visViewerS),
        	new ItemStack(itemRegist.superHelmet),new ItemStack(goggles)
        	);
        	GameRegistry.addShapelessRecipe(new ItemStack(itemRegist.visViewerU),
        	new ItemStack(itemRegist.uberHelmet),new ItemStack(goggles)
        	);
        }
        }
        */
    	if(Loader.isModLoaded("Botania")){
    	if(ConfigFile.botaniaDagger){
    		Item dagger = (Item) Item.itemRegistry.getObject("AWWayofTime:sacrificialKnife");
    		botaniaDaggerRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(itemRegist.knife), 2000, LibOreDict.ELEMENTIUM, LibOreDict.ELEMENTIUM, new ItemStack(dagger));	
    	}
    	manaSlateRecipe = BotaniaAPI.registerManaInfusionRecipe(new ItemStack(itemRegist.manaSlate, 1), new ItemStack(Blocks.stone), 3000);
    		GameRegistry.addRecipe(new ItemStack(blockRegist.manaRune), 
    			" S ","RGR"," S ",'S',itemRegist.manaSlate,'R',Blocks.stone,'G',Items.gold_ingot
    		);
    	}
    	
    	AltarRecipeRegistry.registerAltarRecipe(new ItemStack(ModItems.reinforcedSlate), new ItemStack(itemRegist.thaumicSlate), 2, 1500, 20, 20, false);
    	AltarRecipeRegistry.registerAltarRecipe(new ItemStack(ModItems.reinforcedSlate), new ItemStack(itemRegist.manaSlate), 2, 1500, 20, 20, false);
    	
    	
    	
    }
    
}
