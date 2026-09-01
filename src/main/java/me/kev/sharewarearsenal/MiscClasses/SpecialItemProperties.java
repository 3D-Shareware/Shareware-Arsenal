package me.kev.sharewarearsenal.MiscClasses;

import me.kev.sharewarearsenal.Items.Archery.SpiritBowItem;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static me.kev.sharewarearsenal.Items.Items.SCRAPPER_BOW;
import static me.kev.sharewarearsenal.Items.Items.SPIRIT_BOW;

// lowkey just for bows...for now?!?!
public class SpecialItemProperties {

    public static void addItemProperties() {
        makeSpecialBow(SPIRIT_BOW.get());
        makeSpecialBow(SCRAPPER_BOW.get());
    }

    private static void makeSpecialBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (ClampedItemPropertyFunction)((p_174635_, p_174636_, p_174637_, p_174638_) -> {
            if (p_174637_ == null) {
                return 0.0F;
            } else {
                return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float)(p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
            }
        }));
        ItemProperties.register(item, new ResourceLocation("pulling"), (ClampedItemPropertyFunction)((p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F));
    }

}
