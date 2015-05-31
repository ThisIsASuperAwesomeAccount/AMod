package com.aa.mod.proxies;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;

import com.aa.mod.Main;
import com.aa.mod.updateChecker.CheckVersion;
import com.aa.mod.updateChecker.VersionChecker;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;


public class ClientProxy extends CommonProxy {

	public void run(){
	System.out.println("Client Proxy Loaded");
	}
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event){

    	new VersionChecker().init();
    	

    	Main.versionChecker = new CheckVersion();
    	Thread versionCheckThread = new Thread(Main.versionChecker, "Version Check");
    	versionCheckThread.start();
    	
    	
    	
    }



}
