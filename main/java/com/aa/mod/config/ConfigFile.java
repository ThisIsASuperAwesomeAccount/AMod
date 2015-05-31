package com.aa.mod.config;

import com.aa.mod.Main;

public class ConfigFile {

	public static ConfigFile INSTANCE = new ConfigFile();

	//Register
	public static boolean thaumcraftDagger;
	public static boolean botaniaDagger;
	public static boolean razorBlade;
	public static int rbDamage;
	public static int rbDamageSF;
	public static int rbDamageH;
	public static String rbDesc;
	public static String rbNameOrb;
	public static String rbNameKnife;
	public static final boolean enable = true;
	
	
	

	
	
	public void syncConfig(){
		//Disable Thaumcraft Dagger
		final String THAUM = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Daggers";
		Main.config.addCustomCategoryComment(THAUM, "Disable different dagger types here");
		this.thaumcraftDagger = Main.config.get(THAUM, "Enable Thaumic Dagger", enable).getBoolean(enable);
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		
		//Disable Botania Dagger
		final String BOT = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Daggers";
		Main.config.addCustomCategoryComment(BOT, "Disable different dagger types here");
		this.botaniaDagger = Main.config.get(BOT, "Enable Botania Dagger", enable).getBoolean(enable);
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		
		//Enable Razor Blade
		final String RAZ = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Daggers";
		this.razorBlade = Main.config.get(RAZ, "Do you want the configurable 'dagger' to be disabled?", enable).getBoolean(enable);
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		
		
		//Config Dagger Main
		final String RAZMAIN = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Custom Dagger";
		Main.config.addCustomCategoryComment(RAZMAIN, "Configure the custom dagger here");
		this.rbDamage = Main.config.get(RAZMAIN, "How much LP should you get without Soul Fray?", 100).getInt();
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		
		//Config Dagger SoulFray
		final String RAZSF = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Custom Dagger";
		this.rbDamageSF = Main.config.get(RAZSF, "How much LP should you get with Soul Fray?", 10).getInt();
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		
		//Config Dagger Hearts
		final String RAZD = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Custom Dagger";
		this.rbDamageH = Main.config.get(RAZD, "How many half hearts should a prick damge the player by?", 2).getInt();
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		
		//Config Dagger Description
		final String RAZI = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Custom Dagger";
		this.rbDesc = Main.config.get(RAZI, "What should the blade info be?", "Slice 'n' Dice!").getString();
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		//Config Orb Name
		final String RAZON = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Custom Dagger";
		this.rbNameOrb = Main.config.get(RAZON, "What should the blade be called, if Blood Magic is in Wimp-mode?", "Special Orb").getString();
		if(Main.config.hasChanged()){
			Main.config.save();
		}
		
		//Config Dagger Name
				final String RAZDN = Main.config.CATEGORY_GENERAL + Main.config.CATEGORY_SPLITTER + "Custom Dagger";
				this.rbNameKnife = Main.config.get(RAZDN, "What should the blade be called?", "Razor Blade").getString();
				if(Main.config.hasChanged()){
					Main.config.save();
				}
	}
}
		