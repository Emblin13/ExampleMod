package com.joebalogna.dampsmod.item;

import com.joebalogna.dampsmod.DampsMod;
import com.joebalogna.dampsmod.item.custom.DowsingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class ModItems {
    //This basically tells Forge that the items I'm adding belong to my mod (I think)
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DampsMod.MOD_ID);

    public static final RegistryObject<Item> CITRINE = ITEMS.register("citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> RAW_CITRINE = ITEMS.register("raw_citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2).
                    food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> COAL_COKE = ITEMS.register("coal_coke",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)) {
                //This is an anonymous class. Allows me to override a specific method without needing a new class.
                @Override
                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {return 3200;}
            });

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register("dowsing_rod",
            () -> new DowsingRodItem(new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2).
                    durability(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
