package me.kev.sharewarearsenal.Items.Alloys;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BrassUpgradeSmithingTemplateItem extends Item {

    public BrassUpgradeSmithingTemplateItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.brass_upgrade").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.empty());
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.generic_alloy").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.brass_alloy").setStyle(Style.EMPTY.withColor(ChatFormatting.BLUE)));
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.generic_smithing").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.brass_smithing").setStyle(Style.EMPTY.withColor(ChatFormatting.BLUE)));
        super.appendHoverText(item, level, tooltipComponents, tooltipFlag);
    }

}
