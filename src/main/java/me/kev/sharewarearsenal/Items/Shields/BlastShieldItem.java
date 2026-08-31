package me.kev.sharewarearsenal.Items.Shields;

import me.kev.sharewarearsenal.Renderers.BlastShieldRenderer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class BlastShieldItem extends ShieldItem {

    public BlastShieldItem(Properties p_43089_) {
        super(p_43089_);
    }

    @Override
    public boolean isValidRepairItem(ItemStack p_43091_, ItemStack p_43092_) {
        return p_43092_.is(Items.TNT) || super.isValidRepairItem(p_43091_, p_43092_);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.blast_shield").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        super.appendHoverText(item, level, tooltipComponents, tooltipFlag);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return BlastShieldRenderer.INSTANCE;
            }
        });
    }

}
