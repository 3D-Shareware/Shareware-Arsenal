package me.kev.sharewarearsenal.Items.RedDiamondTools;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class RedDiamondSwordItem extends SwordItem {

    public RedDiamondSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.red_diamond_tool_strike").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.red_diamond_tool_mine").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        super.appendHoverText(item, level, tooltipComponents, tooltipFlag);
    }

}
