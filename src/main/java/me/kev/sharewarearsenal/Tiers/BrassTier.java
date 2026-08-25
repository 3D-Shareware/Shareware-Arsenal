package me.kev.sharewarearsenal.Tiers;

import me.kev.sharewarearsenal.Items.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class BrassTier implements Tier {

    @Override
    public int getUses() {
        return 320;
    }

    @Override
    public float getSpeed() {
        return 13;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 2;
    }

    @Override
    public int getEnchantmentValue() {
        return 44;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemLike[]{Items.BRASS_INGOT.get()});
    }

}
