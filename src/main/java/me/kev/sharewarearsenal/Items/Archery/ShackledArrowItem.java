package me.kev.sharewarearsenal.Items.Archery;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TippedArrowItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShackledArrowItem extends ArrowItem {

    public ShackledArrowItem(Properties p_40512_) {
        super(p_40512_);
    }

    public AbstractArrow createArrow(Level p_43237_, ItemStack p_43238_, LivingEntity p_43239_) {
        return new SpectralArrow(p_43237_, p_43239_);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.empty());
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.generic_arrow").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.shackled_arrow").setStyle(Style.EMPTY.withColor(ChatFormatting.BLUE)));
        super.appendHoverText(item, level, tooltipComponents, tooltipFlag);
    }

}
