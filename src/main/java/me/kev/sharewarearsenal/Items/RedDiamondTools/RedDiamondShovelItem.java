package me.kev.sharewarearsenal.Items.RedDiamondTools;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RedDiamondShovelItem extends ShovelItem {

    public RedDiamondShovelItem(Tier p_43114_, float p_43115_, float p_43116_, Properties p_43117_) {
        super(p_43114_, p_43115_, p_43116_, p_43117_);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.red_diamond_tool_strike").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.red_diamond_tool_mine").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        super.appendHoverText(item, level, tooltipComponents, tooltipFlag);
    }

}
