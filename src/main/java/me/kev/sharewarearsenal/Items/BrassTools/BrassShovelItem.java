package me.kev.sharewarearsenal.Items.BrassTools;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

import java.util.UUID;

public class BrassShovelItem extends ShovelItem {

    public BrassShovelItem(Tier p_43114_, float p_43115_, float p_43116_, Properties p_43117_) {
        super(p_43114_, p_43115_, p_43116_, p_43117_);
    }

    private static final UUID SPEED_MODIFIER_UUID = UUID.fromString("74839201-4031-4031-0091-92f384059fff");

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create(super.getAttributeModifiers(slot, stack));
        if (slot == EquipmentSlot.MAINHAND) {
            map.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(SPEED_MODIFIER_UUID, "Movement Speed", 0.4D, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

}
