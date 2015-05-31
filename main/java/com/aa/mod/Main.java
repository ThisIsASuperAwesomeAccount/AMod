package com.aa.mod;


import com.aa.mod.blocks.blockRegist;
import com.aa.mod.config.ConfigFile;
import com.aa.mod.init.itemRegist;
import com.aa.mod.init.recipeRegist;
import com.aa.mod.init.thaumRegist;
import com.aa.mod.proxies.CommonProxy;
import com.aa.mod.proxies.ClientProxy;
import com.aa.mod.updateChecker.CheckVersion;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;


@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Main {

	
	public static Configuration config;
	public static Logger logger;
	@Mod.Instance(Reference.MODID)
	public static Main instance;
	

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	
	public static CheckVersion versionChecker;
	public static boolean haveWarnedVersionOutOfDate = false;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){

		//Config
		config = new Configuration(event.getSuggestedConfigurationFile());
		logger = event.getModLog();
		MinecraftForge.EVENT_BUS.register(this);
		ConfigFile.INSTANCE.syncConfig();
		
		//Register items
		itemRegist.Register(event);

    	//Register Blocks
		blockRegist.Register(event);
		

    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event){
    	//Recipes
		recipeRegist.Register();
		

    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event){
		//Thaumcraft Shit
		if(Loader.isModLoaded("Thaumcraft")){
			thaumRegist.Register(event);
		}
		

		
    

    }
    

    
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(PlayerTickEvent event1)
	{
	  
	    if (!Main.haveWarnedVersionOutOfDate && event1.player.worldObj.isRemote 
	          && !Main.versionChecker.isLatestVersion())
	    {
	        ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, 
	              "http://jabelarminecraft.blogspot.com");
	        ChatStyle clickableChatStyle = new ChatStyle().setChatClickEvent(versionCheckChatClickEvent);
	        ChatComponentText versionWarningChatComponent = 
	              new ChatComponentText("Your Magic Beans Mod is not latest version!  Click here to update.");
	        versionWarningChatComponent.setChatStyle(clickableChatStyle);
	        event1.player.addChatMessage(versionWarningChatComponent);
	        Main.haveWarnedVersionOutOfDate = true;
	    }
	}
    
    
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
    	if(event.modID.equals(Reference.MODID)){
    		ConfigFile.INSTANCE.syncConfig();
    	}
    }
    

    
    

}
