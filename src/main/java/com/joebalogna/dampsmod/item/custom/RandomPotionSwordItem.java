package com.joebalogna.dampsmod.item.custom;

import com.joebalogna.dampsmod.util.ModEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ToolAction;

public class RandomPotionSwordItem extends SwordItem {
    public RandomPotionSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(ModEffects.getRandomEffect(), 200), pAttacker);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    //Attacks yourself and applies the effects of your sword to yourself. Currently bugged, as it gives 2 effects with
        //each use, and after the effects run out of time, they don't end properly.
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.hurt(DamageSource.playerAttack(pPlayer), 1f);
        pPlayer.addEffect(new MobEffectInstance(ModEffects.getRandomEffect(), 200));
        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
