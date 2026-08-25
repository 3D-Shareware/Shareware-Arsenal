package me.kev.sharewarearsenal.Items.BrassTools;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import java.util.UUID;

public class BrassHoeItem extends HoeItem {

    public BrassHoeItem(Tier p_41336_, int p_41337_, float p_41338_, Properties p_41339_) {
        super(p_41336_, p_41337_, p_41338_, p_41339_);
    }

    private static final UUID SPEED_MODIFIER_UUID = UUID.fromString("74839201-3214-2556-4003-92f384059fff");

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create(super.getAttributeModifiers(slot, stack));
        if (slot == EquipmentSlot.MAINHAND) {
            map.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(SPEED_MODIFIER_UUID, "Movement Speed", 0.4D, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

}
