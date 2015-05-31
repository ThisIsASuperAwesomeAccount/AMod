package com.aa.mod.items;

import com.aa.mod.JordTab;
import com.aa.mod.Reference;
import com.aa.mod.config.ConfigFile;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.event.SacrificeKnifeUsedEvent;
import BloodStuff.PlayerSacrificeHandler;
import WayofTime.alchemicalWizardry.api.tile.IBloodAltar;
import WayofTime.alchemicalWizardry.common.items.SacrificialDagger;
import WayofTime.alchemicalWizardry.common.spell.complex.effect.SpellHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class configDagger extends SacrificialDagger
{
    public configDagger()
    {
        super();
        this.maxStackSize = 1;
        setCreativeTab(JordTab.JordTab);
        setFull3D();
        this.setUnlocalizedName("configDagger");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {

        if (AlchemicalWizardry.wimpySettings)
        {
            this.itemIcon = iconRegister.registerIcon("arcanearteries:configOrb");
           // this.itemIcon = iconRegister.registerIcon("arcanearteries:configOrb");
        } else 
        	this.itemIcon = iconRegister.registerIcon("arcanearteries:configDagger");
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
            par3List.add(ConfigFile.rbDesc);
    }
    
    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount)
    {
//        if(itemInUseCount < 32)
//        {
//        	return;
//        }

        PlayerSacrificeHandler.sacrificePlayerHealth(player);
    }
    
    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
    
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.bow;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
    	if (this.canUseForSacrifice(stack))
        {
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
            return stack;
        }
    	
        if (!player.capabilities.isCreativeMode)
        {
        	SacrificeKnifeUsedEvent evt = new SacrificeKnifeUsedEvent(player, true, true, 2);
        	if(MinecraftForge.EVENT_BUS.post(evt))
        	{
        		return stack;
        	}
        	
        	if(evt.shouldDrainHealth)
        	{
                player.setHealth(player.getHealth() - ConfigFile.rbDamageH);
        	}
        	
        	if(!evt.shouldFillAltar)
        	{
        		return stack;
        	}
        }

        if (player instanceof FakePlayer)
        {
            return stack;
        }

        double posX = player.posX;
        double posY = player.posY;
        double posZ = player.posZ;
        world.playSoundEffect((double) ((float) posX + 0.5F), (double) ((float) posY + 0.5F), (double) ((float) posZ + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
        float f = (float) 1.0F;
        float f1 = f * 0.6F + 0.4F;
        float f2 = f * f * 0.7F - 0.5F;
        float f3 = f * f * 0.6F - 0.7F;

        for (int l = 0; l < 8; ++l)
        {
            world.spawnParticle("reddust", posX + Math.random() - Math.random(), posY + Math.random() - Math.random(), posZ + Math.random() - Math.random(), f1, f2, f3);
        }

        if (!world.isRemote && SpellHelper.isFakePlayer(world, player))
        {
            return stack;
        }

        if (player.isPotionActive(AlchemicalWizardry.customPotionSoulFray))
        {
            findAndFillAltar(world, player, ConfigFile.rbDamageSF);
        } else
        {
            findAndFillAltar(world, player, ConfigFile.rbDamage);
        }

        if (player.getHealth() <= 0.001f)
        {
            player.onDeath(DamageSource.cactus);
        }

        return stack;
    }




    
    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
    	if(!world.isRemote && entity instanceof EntityPlayer)
    	{
    		this.setUseForSacrifice(stack, this.isPlayerPreparedForSacrifice(world, (EntityPlayer)entity));
    	}
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        if (AlchemicalWizardry.wimpySettings)
        {
            return ConfigFile.rbNameOrb;
        }
        return ConfigFile.rbNameKnife;
    }
    
    public boolean isPlayerPreparedForSacrifice(World world, EntityPlayer player)
    {
    	return !world.isRemote && (PlayerSacrificeHandler.getPlayerIncense(player) > 0);
    }
    
    public boolean canUseForSacrifice(ItemStack stack)
    {
    	NBTTagCompound tag = stack.getTagCompound();
    	if(tag == null)
    	{
    		return false;
    	}
    	
    	return tag.getBoolean("sacrifice");
    }
    
    public void setUseForSacrifice(ItemStack stack, boolean sacrifice)
    {
    	NBTTagCompound tag = stack.getTagCompound();
    	if(tag == null)
    	{
    		tag = new NBTTagCompound();
    		stack.setTagCompound(tag);
    	}
    	
    	tag.setBoolean("sacrifice", sacrifice);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack, int pass)
    {
        return this.canUseForSacrifice(stack) ? true : super.hasEffect(stack, pass);
    }
}