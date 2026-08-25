package me.kev.sharewarearsenal.Items.RedDiamondArmor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class RedDiamondBootsItem extends ArmorItem {

    public RedDiamondBootsItem(ArmorMaterial p_40386_, Type p_266831_, Properties p_40388_) {
        super(p_40386_, p_266831_, p_40388_);
    }

    private static final UUID HEALTH_MODIFIER_UUID = UUID.fromString("74839201-4299-99ac-938e-92f384059fff");

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create(super.getAttributeModifiers(slot, stack));
        if (slot == EquipmentSlot.FEET) {
            map.put(Attributes.MAX_HEALTH, new AttributeModifier(HEALTH_MODIFIER_UUID, "Max Health", 2.0D, AttributeModifier.Operation.ADDITION));
        }
        return map;
    }

}
