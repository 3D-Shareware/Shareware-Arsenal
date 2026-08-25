package me.kev.sharewarearsenal.Tiers;

import me.kev.sharewarearsenal.Items.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class RedDiamondTier implements Tier {

    @Override
    public int getUses() {
        return 520;
    }

    @Override
    public float getSpeed() {
        return 7;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemLike[]{Items.RED_DIAMOND.get()});
    }

}
