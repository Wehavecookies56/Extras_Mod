package xyz567.extras;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

@Mod(modid = "Extras", name = "Extras", version = "0.0.2.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class Extras_Main {

	@SidedProxy(clientSide = "xyz567.extras.ClientSide", serverSide = "xyz567.extras.ServerSide")
	
	public static ServerSide proxy;
	
	// Declare Blocks
	public static Block BedrockFence;
	public static Block DiamondFence;
	public static Block EmeraldFence;
	public static Block GoldFence;
	public static Block IronFence;
	
	// Declare Items
	public static Item BedrockStick;
	public static Item DiamondStick;
	public static Item EmeraldStick;
	public static Item GoldStick;
	public static Item IronStick;
	
	// Declare Fence ID's
	public int BedrockFenceID;
	public int DiamondFenceID;
	public int EmeraldFenceID;
	public int GoldFenceID;
	public int IronFenceID;
	
	// Declare Stick ID's
	public int BedrockStickID;
	public int DiamondStickID;
	public int EmeraldStickID;
	public int GoldStickID;
	public int IronStickID;
	
	
	// Declare creative tab
	public static CreativeTabs ExtrasFencesTab = new ExtrasFencesTab(CreativeTabs.getNextID(), "ExtrasFencesTab");	
	public static CreativeTabs ExtrasMaterialsTab = new ExtrasMaterialsTab(CreativeTabs.getNextID(),"ExtrasMaterialsTab");
	
	@PreInit
	public void PreLoad(FMLPreInitializationEvent PreEvent){

		// Declare config
		Configuration config = new Configuration(PreEvent.getSuggestedConfigurationFile());
		
		// Load config
		config.load();
		
		// Set Fence config ID's
		BedrockFenceID = config.getBlock("BedrockFence", 3465).getInt();
		DiamondFenceID = config.getBlock("DiamondFence", 3466).getInt();		
		EmeraldFenceID = config.getBlock("EmeraldFence", 3467).getInt();
		GoldFenceID = config.getBlock("GoldFence", 3468).getInt();
		IronFenceID = config.getBlock("IronFence", 3469).getInt();
		
		// Set Stick config ID's
		BedrockStickID = config.getItem("BedrockStick", 26200).getInt();
		DiamondStickID = config.getItem("DiamondStick", 26201).getInt();
		EmeraldStickID = config.getItem("EmeraldStick", 26202).getInt();
		GoldStickID = config.getItem("GoldStick", 26203).getInt();
		IronStickID = config.getItem("IronStick", 26204).getInt();
		
		// Save config
		config.save();
		
	}

	@Init
	public void load(FMLInitializationEvent event){
		
		// Proxy
		proxy.registerRenderThings();
		
		// Declaration of Fences
		BedrockFence = new BlockFence(BedrockFenceID, "bedrock", Material.air).setUnlocalizedName("bedrock").setCreativeTab(ExtrasFencesTab).setBlockUnbreakable();
		DiamondFence = new BlockFence(DiamondFenceID, "blockDiamond", Material.iron).setUnlocalizedName("blockDiamond").setCreativeTab(ExtrasFencesTab).setHardness(5.0F).setResistance(10.0F);
		EmeraldFence = new BlockFence(EmeraldFenceID, "blockEmerald", Material.iron).setUnlocalizedName("blockEmerald").setCreativeTab(ExtrasFencesTab).setHardness(5.0F).setResistance(10.0F);
		GoldFence = new BlockFence(GoldFenceID, "blockGold", Material.iron).setUnlocalizedName("blockGold").setCreativeTab(ExtrasFencesTab).setHardness(3.0F).setResistance(10.0F);
		IronFence = new BlockFence(IronFenceID, "blockIron", Material.iron).setUnlocalizedName("blockIron").setCreativeTab(ExtrasFencesTab).setHardness(5.0F).setResistance(10.0F);
		
		// Declaration of Sticks
		BedrockStick = new Item(BedrockStickID).setFull3D().setUnlocalizedName("BedrockStick").setCreativeTab(ExtrasMaterialsTab);
		DiamondStick = new Item(DiamondStickID).setFull3D().setUnlocalizedName("DiamondStick").setCreativeTab(ExtrasMaterialsTab);
		EmeraldStick = new Item(EmeraldStickID).setFull3D().setUnlocalizedName("EmeraldStick").setCreativeTab(ExtrasMaterialsTab);
		GoldStick = new Item(GoldStickID).setFull3D().setUnlocalizedName("GoldStick").setCreativeTab(ExtrasMaterialsTab);
		IronStick = new Item(IronStickID).setFull3D().setUnlocalizedName("IronStick").setCreativeTab(ExtrasMaterialsTab);
		
		// Game registry for Fences
		GameRegistry.registerBlock(BedrockFence, "BedrockFence");
		GameRegistry.registerBlock(DiamondFence, "DiamondFence");
		GameRegistry.registerBlock(EmeraldFence, "EmeraldFence");
		GameRegistry.registerBlock(GoldFence, "GoldFence");
		GameRegistry.registerBlock(IronFence, "IronFence");
		
		// Game registry for Sticks
		GameRegistry.registerItem(BedrockStick, "BedrockStick");
		GameRegistry.registerItem(DiamondStick, "DiamondStick");
		GameRegistry.registerItem(EmeraldStick, "EmeraldStick");
		GameRegistry.registerItem(GoldStick, "GoldStick");
		GameRegistry.registerItem(IronStick, "IronStick");
		
		// Game registry for crafting recipies
		
		// Bedrock Fence
		GameRegistry.addRecipe(new ItemStack(BedrockFence, 2), new Object[]{
			"BBB", 
			"BBB",
			'B', BedrockStick,
		});
		
		// Bedrock Stick
		GameRegistry.addRecipe(new ItemStack(BedrockStick, 2), new Object[]{
			"B",
			"B",
			'B', Block.bedrock,
		});
		
		// Diamond Fence
		GameRegistry.addRecipe(new ItemStack(DiamondFence, 2), new Object[]{
			"DDD",
			"DDD",
			'D', DiamondStick,
		});
		
		// Diamond Stick
		GameRegistry.addRecipe(new ItemStack(DiamondStick, 4), new Object[]{
			"D",
			"D",
			'D', Item.diamond,
		});
		
		// Emerald Fence
		GameRegistry.addRecipe(new ItemStack(EmeraldFence, 2), new Object[]{
			"EEE", 
			"EEE",
			'E', EmeraldStick,
		});
		
		//Emerald Stick
		GameRegistry.addRecipe(new ItemStack(EmeraldStick, 4), new Object[]{
			"E",
			"E",
			'E', Item.emerald,
		});
		
		// Gold Fence
		GameRegistry.addRecipe(new ItemStack(GoldFence, 2), new Object[]{
			"GGG",
			"GGG",
			'G', GoldStick,
		});
		
		// Gold Stick
		GameRegistry.addRecipe(new ItemStack(GoldStick, 4), new Object[]{
			"G",
			"G",
			'G', Item.ingotGold,
		});
		
		//Iron Fence
		GameRegistry.addRecipe(new ItemStack(IronFence, 2), new Object[]{
			"III",
			"III",
			'I', IronStick,
		});
		
		// Iron Stick
		GameRegistry.addRecipe(new ItemStack(IronStick, 4), new Object[]{
			"I",
			"I",
			'I', Item.ingotIron,
		});
	}
	
	@PostInit
	public void PostLoad(FMLPostInitializationEvent PostEvent){
		
		// Language registry for Fences
		LanguageRegistry.addName(BedrockFence, "Bedrock Fence");
		LanguageRegistry.addName(DiamondFence, "Diamond Fence");
		LanguageRegistry.addName(EmeraldFence, "Emerald Fence");
		LanguageRegistry.addName(GoldFence, "Gold Fence");
		LanguageRegistry.addName(IronFence, "Iron Fence");
		
		// Language registry for Sticks
		LanguageRegistry.addName(BedrockStick, "Bedrock Stick");
		LanguageRegistry.addName(DiamondStick, "Diamond Stick");
		LanguageRegistry.addName(EmeraldStick, "Emerald Stick");
		LanguageRegistry.addName(GoldStick, "Gold Stick");
		LanguageRegistry.addName(IronStick, "Iron Stick");
		
	}
}
