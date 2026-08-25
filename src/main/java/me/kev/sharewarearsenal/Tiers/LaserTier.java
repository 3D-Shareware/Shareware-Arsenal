package me.kev.sharewarearsenal.Tiers;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class LaserTier implements Tier {

    @Override
    public int getUses() {
        return 1977;
    }

    @Override
    public float getSpeed() {
        return 8;
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
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.BEDROCK);
    }

}
