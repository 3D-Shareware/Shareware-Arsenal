package me.kev.sharewarearsenal.Items.RedDiamondTools;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RedDiamondAxeItem extends AxeItem {

    public RedDiamondAxeItem(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
        super(p_40521_, p_40522_, p_40523_, p_40524_);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.red_diamond_tool_strike").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.red_diamond_tool_mine").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        super.appendHoverText(item, level, tooltipComponents, tooltipFlag);
    }

}
