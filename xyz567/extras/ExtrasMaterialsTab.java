package xyz567.extras;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ExtrasMaterialsTab extends CreativeTabs {

	public ExtrasMaterialsTab(int par1, String par2Str) {
		super(par1, par2Str);
		// TODO Auto-generated constructor stub
	}

	   @SideOnly(Side.CLIENT)

	    /**
	     * the itemID for the item to be displayed on the tab
	     */
	    public int getTabIconItemIndex()
	    {
		   // The item shown on tab
	        return Extras_Main.DiamondStick.itemID;
	    }
	   
	   public String getTranslatedTabLabel(){
		   // Name shown when hovered over
		   return "Extras Materials";
	   }
	
}
