package xyz567.extras;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.event.Event;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "Extras", name = "Extras", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class Extras_Main {

	@SidedProxy(clientSide = "xyz567.extras.ClientSide", serverSide = "xyz567.extras.ServerSide")
	
	public static ServerSide proxy;
	
	// Declare blocks
	public static Block BedrockFence;
	public static Block DiamondFence;
	public static Block EmeraldFence;
	public static Block GoldFence;
	public static Block IronFence;
		
	// Declare ID's
	public int BedrockFenceID;
	public int DiamondFenceID;
	public int EmeraldFenceID;
	public int GoldFenceID;
	public int IronFenceID;
	
	
	// Declare creative tab
	public static CreativeTabs ExtrasTab = new ExtrasTab(CreativeTabs.getNextID(), "ExtrasTab");	
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent PreEvent){

		// Declare config
		Configuration config = new Configuration(PreEvent.getSuggestedConfigurationFile());
		
		// Load config
		config.load();
		
		// Set config ID's
		BedrockFenceID = config.getBlock("BedrockFence", 3465).getInt();
		DiamondFenceID = config.getBlock("DiamondFence", 3466).getInt();		
		EmeraldFenceID = config.getBlock("EmeraldFence", 3467).getInt();
		GoldFenceID = config.getBlock("GoldFence", 3468).getInt();
		IronFenceID = config.getBlock("IronFence", 3469).getInt();
		
		
		// Save config
		config.save();
		
	}

	@Init
	public void load(FMLInitializationEvent event){
		
		// Proxy
		proxy.registerRenderThings();
		
		// Declaration
		BedrockFence = new BlockFence(BedrockFenceID, "bedrock", Material.air).setUnlocalizedName("bedrock").setCreativeTab(ExtrasTab).setBlockUnbreakable();
		DiamondFence = new BlockFence(DiamondFenceID, "blockDiamond", Material.iron).setUnlocalizedName("blockDiamond").setCreativeTab(ExtrasTab).setHardness(5.0F).setResistance(10.0F);
		EmeraldFence = new BlockFence(EmeraldFenceID, "blockEmerald", Material.iron).setUnlocalizedName("blockEmerald").setCreativeTab(ExtrasTab).setHardness(5.0F).setResistance(10.0F);
		GoldFence = new BlockFence(GoldFenceID, "blockGold", Material.iron).setUnlocalizedName("blockGold").setCreativeTab(ExtrasTab).setHardness(3.0F).setResistance(10.0F);
		IronFence = new BlockFence(IronFenceID, "blockIron", Material.iron).setUnlocalizedName("blockIron").setCreativeTab(ExtrasTab).setHardness(5.0F).setResistance(10.0F);;
		
		
		// Game registry
		GameRegistry.registerBlock(BedrockFence, "BedrockFence");
		GameRegistry.registerBlock(DiamondFence, "DiamondFence");
		GameRegistry.registerBlock(EmeraldFence, "EmeraldFence");
		GameRegistry.registerBlock(GoldFence, "GoldFence");
		GameRegistry.registerBlock(IronFence, "IronFence");
		
		
	}
	
	@PostInit
	public void PostLoad(FMLPostInitializationEvent PostEvent){
		
		// Language registry
		LanguageRegistry.addName(BedrockFence, "Bedrock Fence");
		LanguageRegistry.addName(DiamondFence, "Diamond Fence");
		LanguageRegistry.addName(EmeraldFence, "Emerald Fence");
		LanguageRegistry.addName(GoldFence, "Gold Fence");
		LanguageRegistry.addName(IronFence, "Iron Fence");
		
		
	}
}
