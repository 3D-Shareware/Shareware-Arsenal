package me.kev.sharewarearsenal.Items.Special;

import me.kev.sharewarearsenal.Items.GauntletItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static me.kev.sharewarearsenal.Particle.AllParticles.FALCON_PARTICLE;

public class FalconGauntletItem extends GauntletItem {

    public FalconGauntletItem(Tier p_43269_, float p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);
    }

    @Override
    public void appendHoverText(ItemStack item, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.sharewarearsenal.falcon_gauntlet").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)));
        super.appendHoverText(item, level, tooltipComponents, tooltipFlag);
    }

    public UseAnim getUseAnimation(ItemStack p_43417_) {
        return UseAnim.SPEAR;
    }

    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }

    public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
        if (p_43396_ instanceof Player player) {
            int $$5 = this.getUseDuration(p_43394_) - p_43397_;
            if ($$5 >= 20) {
                    if (!p_43395_.isClientSide) {
                        p_43394_.hurtAndBreak(1, player, (p_43388_) -> p_43388_.broadcastBreakEvent(p_43396_.getUsedItemHand()));
                    }

                    p_43395_.addParticle(FALCON_PARTICLE.get(), player.getX(), player.getY() + 1, player.getZ(), 0, 0, 0);

                    player.awardStat(Stats.ITEM_USED.get(this));
                    float $$8 = player.getYRot();
                    float $$9 = player.getXRot();
                    float $$10 = -Mth.sin($$8 * ((float)Math.PI / 180F)) * Mth.cos($$9 * ((float)Math.PI / 180F));
                    float $$11 = -Mth.sin($$9 * ((float)Math.PI / 180F));
                    float $$12 = Mth.cos($$8 * ((float)Math.PI / 180F)) * Mth.cos($$9 * ((float)Math.PI / 180F));
                    float $$13 = Mth.sqrt($$10 * $$10 + $$11 * $$11 + $$12 * $$12);
                    float speed_multiplier = 3.0F;
                    $$10 *= speed_multiplier / $$13;
                    $$11 *= speed_multiplier / $$13;
                    $$12 *= speed_multiplier / $$13;
                    player.push((double)$$10, (double)$$11, (double)$$12);
                    //$$4.startAutoSpinAttack(20);
                    if (player.onGround()) {
                        float $$15 = 1.1999999F;
                        player.move(MoverType.SELF, new Vec3((double)0.0F, (double)1.1999999F, (double)0.0F));
                    }

                    SoundEvent $$16;
                    $$16 = SoundEvents.TRIDENT_RIPTIDE_3;

                    p_43395_.playSound((Player)null, player, $$16, SoundSource.PLAYERS, 1.0F, 1.0F);


            }
        }
    }

    public InteractionResultHolder<ItemStack> use(Level p_43405_, Player p_43406_, InteractionHand p_43407_) {
        ItemStack $$3 = p_43406_.getItemInHand(p_43407_);
        if ($$3.getDamageValue() >= $$3.getMaxDamage() - 1) {
            return InteractionResultHolder.fail($$3);
        } else {
            p_43406_.startUsingItem(p_43407_);
            return InteractionResultHolder.consume($$3);
        }
    }

}
