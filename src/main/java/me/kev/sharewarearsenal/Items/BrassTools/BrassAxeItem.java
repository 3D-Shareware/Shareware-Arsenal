package me.kev.sharewarearsenal.Items.BrassTools;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

import java.util.UUID;

public class BrassAxeItem extends AxeItem {

    public BrassAxeItem(Tier p_40521_, float p_40522_, float p_40523_, Properties p_40524_) {
        super(p_40521_, p_40522_, p_40523_, p_40524_);
    }

    private static final UUID SPEED_MODIFIER_UUID = UUID.fromString("74839201-2351-1920-0932-92f384059fff");

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> map = HashMultimap.create(super.getAttributeModifiers(slot, stack));
        if (slot == EquipmentSlot.MAINHAND) {
            map.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(SPEED_MODIFIER_UUID, "Movement Speed", 0.4D, AttributeModifier.Operation.MULTIPLY_BASE));
        }
        return map;
    }

}
