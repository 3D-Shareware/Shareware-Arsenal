package me.kev.sharewarearsenal.Items;

import me.kev.sharewarearsenal.Items.Alloys.BrassIngotItem;
import me.kev.sharewarearsenal.Items.Alloys.BronzeIngotItem;
import me.kev.sharewarearsenal.Items.BrassTools.*;
import me.kev.sharewarearsenal.Items.RedDiamondTools.*;
import me.kev.sharewarearsenal.Tiers.BrassTier;
import me.kev.sharewarearsenal.Tiers.BronzeTier;
import me.kev.sharewarearsenal.Tiers.RedDiamondTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    // 1. Create the DeferredRegister for Items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "sharewarearsenal");

    // Red Diamond
    public static final RegistryObject<Item> RED_DIAMOND =
            ITEMS.register("red_diamond", () -> new Item(new Item.Properties()));
    // Red Diamond Pickaxe
    public static final RegistryObject<Item> RED_DIAMOND_PICKAXE =
            ITEMS.register("red_diamond_pickaxe", () -> new RedDiamondPickaxeItem(new RedDiamondTier(), 4, -2.8f, new Item.Properties()));
    // Red Diamond Shovel
    public static final RegistryObject<Item> RED_DIAMOND_SHOVEL =
            ITEMS.register("red_diamond_shovel", () -> new RedDiamondShovelItem(new RedDiamondTier(), 4.5f, -3, new Item.Properties()));
    // Red Diamond Hoe
    public static final RegistryObject<Item> RED_DIAMOND_HOE =
            ITEMS.register("red_diamond_hoe", () -> new RedDiamondHoeItem(new RedDiamondTier(), 0, 0, new Item.Properties()));
    // Red Diamond Axe
    public static final RegistryObject<Item> RED_DIAMOND_AXE =
            ITEMS.register("red_diamond_axe", () -> new RedDiamondAxeItem(new RedDiamondTier(), 8, -3, new Item.Properties()));
    // Red Diamond Sword
    public static final RegistryObject<Item> RED_DIAMOND_SWORD =
            ITEMS.register("red_diamond_sword", () -> new RedDiamondSwordItem(new RedDiamondTier(), 6, -2.4f, new Item.Properties()));

    // Bronze Ingot
    public static final RegistryObject<Item> BRONZE_INGOT =
            ITEMS.register("bronze_ingot", () -> new BronzeIngotItem(new Item.Properties()));
    // Bronze Pickaxe
    public static final RegistryObject<Item> BRONZE_PICKAXE =
            ITEMS.register("bronze_pickaxe", () -> new PickaxeItem(new BronzeTier(), 3, -2.2f, new Item.Properties()));
    // Bronze Shovel
    public static final RegistryObject<Item> BRONZE_SHOVEL =
            ITEMS.register("bronze_shovel", () -> new ShovelItem(new BronzeTier(), 3.5f, -2.4f, new Item.Properties()));
    // Bronze Hoe
    public static final RegistryObject<Item> BRONZE_HOE =
            ITEMS.register("bronze_hoe", () -> new HoeItem(new BronzeTier(), 0, -0.4f, new Item.Properties()));
    // Bronze Axe
    public static final RegistryObject<Item> BRONZE_AXE =
            ITEMS.register("bronze_axe", () -> new AxeItem(new BronzeTier(), 8, -2.5f, new Item.Properties()));
    // Bronze Sword
    public static final RegistryObject<Item> BRONZE_SWORD =
            ITEMS.register("bronze_sword", () -> new SwordItem(new BronzeTier(), 5, -1.8f, new Item.Properties()));

    // Brass Ingot
    public static final RegistryObject<Item> BRASS_INGOT =
            ITEMS.register("brass_ingot", () -> new BrassIngotItem(new Item.Properties()));
    // Brass Pickaxe
    public static final RegistryObject<Item> BRASS_PICKAXE =
            ITEMS.register("brass_pickaxe", () -> new BrassPickaxeItem(new BrassTier(), 3, -2.8f, new Item.Properties()));
    // Brass Shovel
    public static final RegistryObject<Item> BRASS_SHOVEL =
            ITEMS.register("brass_shovel", () -> new BrassShovelItem(new BrassTier(), 3.5f, -3, new Item.Properties()));
    // Brass Hoe
    public static final RegistryObject<Item> BRASS_HOE =
            ITEMS.register("brass_hoe", () -> new BrassHoeItem(new BrassTier(), 0, -1, new Item.Properties()));
    // Brass Axe
    public static final RegistryObject<Item> BRASS_AXE =
            ITEMS.register("brass_axe", () -> new BrassAxeItem(new BrassTier(), 8, -3.1f, new Item.Properties()));
    // Brass Sword
    public static final RegistryObject<Item> BRASS_SWORD =
            ITEMS.register("brass_sword", () -> new BrassSwordItem(new BrassTier(), 5, -2.4f, new Item.Properties()));


    public static final TagKey<Item> RED_DIAMOND_TOOLS = ItemTags.create(new ResourceLocation("sharewarearsenal", "red_diamond_tools"));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
