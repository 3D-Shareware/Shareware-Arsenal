package me.kev.sharewarearsenal.Items.Archery;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpectralArrowItem;

import java.util.function.Predicate;

import static me.kev.sharewarearsenal.Items.Items.SPIRIT_BOW_ARROWS;

public class SpiritBowItem extends BowItem {

    public SpiritBowItem(Properties p_40660_) {
        super(p_40660_);
    }

    private static final Predicate<ItemStack> SPIRIT_BOW_ARROWS_STACK = (p_43017_) -> p_43017_.is(SPIRIT_BOW_ARROWS);

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return SPIRIT_BOW_ARROWS_STACK;
    }

}
