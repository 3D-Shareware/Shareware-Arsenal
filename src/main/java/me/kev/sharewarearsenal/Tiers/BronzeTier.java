package me.kev.sharewarearsenal.Tiers;

import me.kev.sharewarearsenal.Items.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class BronzeTier implements Tier {

    @Override
    public int getUses() {
        return 627;
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
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(new ItemLike[]{Items.BRONZE_INGOT.get()});
    }

}
