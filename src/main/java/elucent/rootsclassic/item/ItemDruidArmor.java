package elucent.rootsclassic.item;

import java.util.List;
import elucent.rootsclassic.Const;
import elucent.rootsclassic.RegistryManager;
import elucent.rootsclassic.Roots;
import elucent.rootsclassic.Util;
import elucent.rootsclassic.model.ModelDruidArmor;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDruidArmor extends ItemArmor {

  public ItemDruidArmor(int reduction, EntityEquipmentSlot slot) {
    super(RegistryManager.druidArmorMaterial, reduction, slot);
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void addInformation(ItemStack stack, World player, List<String> tooltip, net.minecraft.client.util.ITooltipFlag advanced) {
    tooltip.add("");
    tooltip.add(TextFormatting.GRAY + Roots.lang("roots.attribute.equipped.name"));
    tooltip.add(TextFormatting.BLUE + " " + Roots.lang("roots.attribute.increasedregen.name"));
  }

  @SideOnly(Side.CLIENT)
  @Override
  public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
    return Const.MODID + ":textures/models/armor/druidarmor.png";
  }

  @SideOnly(Side.CLIENT)
  @Override
  public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot slot, ModelBiped _default) {
    return new ModelDruidArmor(slot);
  }

  @Override
  public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
    Util.randomlyRepair(world.rand, stack);
  }
}
