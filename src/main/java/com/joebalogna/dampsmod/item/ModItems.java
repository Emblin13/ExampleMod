package com.joebalogna.dampsmod.item;

import com.joebalogna.dampsmod.DampsMod;
import com.joebalogna.dampsmod.block.ModBlocks;
import com.joebalogna.dampsmod.item.custom.DataTabletItem;
import com.joebalogna.dampsmod.item.custom.DowsingRodItem;
import com.joebalogna.dampsmod.item.custom.ModArmorItem;
import com.joebalogna.dampsmod.item.custom.RandomPotionSwordItem;
import com.joebalogna.dampsmod.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> CITRINE_SWORD = ITEMS.register("citrine_sword",
            () -> new SwordItem(ModTiers.CITRINE, 2, 3f,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CITRINE_PICKAXE = ITEMS.register("citrine_pickaxe",
            () -> new PickaxeItem(ModTiers.CITRINE, 1, 1f,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CITRINE_SHOVEL = ITEMS.register("citrine_shovel",
            () -> new ShovelItem(ModTiers.CITRINE, 1, 1f,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CITRINE_AXE = ITEMS.register("citrine_axe",
            () -> new AxeItem(ModTiers.CITRINE, 4, 0f,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CITRINE_HOE = ITEMS.register("citrine_hoe",
            () -> new HoeItem(ModTiers.CITRINE, 1, 1f,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));


    //Because the custom armor set-bonus requires all pieces of armor to be worn, only 1 piece of armor needs to be
        //a ModArmorItem, since there's no point having all 4 armor pieces check to see if all pieces are worn.
    public static final RegistryObject<Item> CITRINE_HELMET = ITEMS.register("citrine_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CITRINE_CHESTPLATE = ITEMS.register("citrine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CITRINE_LEGGINGS = ITEMS.register("citrine_leggings",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> CITRINE_BOOTS = ITEMS.register("citrine_boots",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> RANDOM_POTION_SWORD = ITEMS.register("random_potion_sword",
            () -> new RandomPotionSwordItem(ModTiers.CITRINE, 1, 0.5f,
                    new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register("magic_dust",
            () -> new Item( new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem( new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2).stacksTo(1)));

    public static final RegistryObject<Item> KAUPENBOW = ITEMS.register("kaupenbow",
            () -> new BowItem( new Item.Properties().tab(ModCreativeModTab.DAMPS_TAB2).durability(500)));

    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_PLANT.get(), new Item.Properties().
                    tab(ModCreativeModTab.DAMPS_TAB2)));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new RecordItem(1, ModSounds.BAR_BRAWL, new Item.Properties().
                    tab(ModCreativeModTab.DAMPS_TAB2).stacksTo(1)));

    public static final RegistryObject<Item> DISCO_LIGHT_MUSIC_DISC = ITEMS.register("disco_light_music_disc",
            () -> new RecordItem(2, ModSounds.DISCO_LIGHT, new Item.Properties().
                    tab(ModCreativeModTab.DAMPS_TAB2).stacksTo(1)));

    public static final RegistryObject<Item> GASLIGHT_MUSIC_DISC = ITEMS.register("gaslight_music_disc",
            () -> new RecordItem(3, ModSounds.GASLIGHT, new Item.Properties().
                    tab(ModCreativeModTab.DAMPS_TAB2).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
