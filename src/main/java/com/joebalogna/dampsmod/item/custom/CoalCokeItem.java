package com.joebalogna.dampsmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class CoalCokeItem extends Item {
    //This constructor isn't being used. I'm keeping it here as an alternative way to implement coal coke
        //Currently, coal coke is given its burn properties through an anonymous class in ModItems.java.
    public CoalCokeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 3200; //2x the duration of regular coal
    }
}
