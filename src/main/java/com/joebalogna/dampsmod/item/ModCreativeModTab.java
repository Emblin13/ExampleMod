package com.joebalogna.dampsmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab DAMPS_TAB = new CreativeModeTab("dampstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CITRINE.get());
        }
    };

    public static final CreativeModeTab DAMPS_TAB2 = new CreativeModeTab("dampstab2") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RAW_CITRINE.get());
        }
    };
}
