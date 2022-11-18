package com.joebalogna.dampsmod.util;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class ModEffects {

    private static Random rand = new Random();

    //This method could be optimized by making a list of all potion effects on startup, and then caching it for reuse.
        //Look into caching later.
    public static MobEffect getRandomEffect() {
        //Selects a random potion effect
        MobEffect effect = MobEffect.byId(rand.nextInt(ForgeRegistries.POTIONS.getValues().size()));

        //For reasons I don't understand, the effect chosen is sometimes null, so this is for do-overs.
        while (effect == null) {
            effect = MobEffect.byId(rand.nextInt(ForgeRegistries.POTIONS.getValues().size()));
        }

        return effect;
    }

}
