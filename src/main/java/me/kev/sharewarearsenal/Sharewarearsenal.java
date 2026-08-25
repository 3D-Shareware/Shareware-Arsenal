package me.kev.sharewarearsenal;

import com.mojang.logging.LogUtils;
import me.kev.sharewarearsenal.Items.*;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import static me.kev.sharewarearsenal.Items.Items.*;
import static me.kev.sharewarearsenal.Items.Items.BRASS_SWORD;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Sharewarearsenal.MODID)
public class Sharewarearsenal {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "sharewarearsenal";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "sharewarearsenal" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "sharewarearsenal" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creative tab
    public static final RegistryObject<CreativeModeTab> SHAREWARE_ARSENAL_TAB = CREATIVE_MODE_TABS.register("shareware_arsenal", () -> CreativeModeTab.builder().title(Component.translatable("creativetab.sharewarearsenal.arsenal")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> RED_DIAMOND.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(RED_DIAMOND.get());
        output.accept(RED_DIAMOND_SWORD.get());
        output.accept(RED_DIAMOND_AXE.get());
        output.accept(RED_DIAMOND_PICKAXE.get());
        output.accept(RED_DIAMOND_SHOVEL.get());
        output.accept(RED_DIAMOND_HOE.get());

        output.accept(BRONZE_INGOT.get());
        output.accept(BRONZE_SWORD.get());
        output.accept(BRONZE_AXE.get());
        output.accept(BRONZE_PICKAXE.get());
        output.accept(BRONZE_SHOVEL.get());
        output.accept(BRONZE_HOE.get());

        output.accept(BRASS_INGOT.get());
        output.accept(BRASS_SWORD.get());
        output.accept(BRASS_AXE.get());
        output.accept(BRASS_PICKAXE.get());
        output.accept(BRASS_SHOVEL.get());
        output.accept(BRASS_HOE.get());
    }).build());

    public Sharewarearsenal() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) event.accept(RED_DIAMOND);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(RED_DIAMOND_SHOVEL);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(RED_DIAMOND_PICKAXE);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(RED_DIAMOND_AXE);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(RED_DIAMOND_HOE);
        if (event.getTabKey() == CreativeModeTabs.COMBAT) event.accept(RED_DIAMOND_SWORD);
        if (event.getTabKey() == CreativeModeTabs.COMBAT) event.accept(RED_DIAMOND_AXE);

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) event.accept(BRONZE_INGOT);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRONZE_SHOVEL);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRONZE_PICKAXE);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRONZE_AXE);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRONZE_HOE);
        if (event.getTabKey() == CreativeModeTabs.COMBAT) event.accept(BRONZE_SWORD);
        if (event.getTabKey() == CreativeModeTabs.COMBAT) event.accept(BRONZE_AXE);

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) event.accept(BRASS_INGOT);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRASS_SHOVEL);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRASS_PICKAXE);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRASS_AXE);
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) event.accept(BRASS_HOE);
        if (event.getTabKey() == CreativeModeTabs.COMBAT) event.accept(BRASS_SWORD);
        if (event.getTabKey() == CreativeModeTabs.COMBAT) event.accept(BRASS_AXE);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }


    @Mod.EventBusSubscriber(modid = "sharewarearsenal", bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class RedDiamondHealer {
        @SubscribeEvent
        public static void redDiamondHealOnHit(LivingDamageEvent event) {
            if (event.getEntity().level().isClientSide) return;
            var attacker = event.getSource().getEntity();
            if (attacker == null) return;
            if (attacker instanceof Player player) {
                ItemStack heldItem = player.getMainHandItem();
                if (heldItem.is(RED_DIAMOND_TOOLS)) {
                    float heal_amount = event.getAmount() / 4f;
                    player.heal(heal_amount);
                    if (player.level() instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.HEART, player.getX(), player.getY() + 0.5, player.getZ(), Math.max((int)(heal_amount), 1), 0.5, 0.5, 0.5, 0.5);
                    }
                }
            }
        }

        @SubscribeEvent
        public static void redDiamondHealOnMine(BlockEvent.BreakEvent event) {
            var player = event.getPlayer();
            if (player.level().isClientSide) return;
            ItemStack heldItem = player.getMainHandItem();
            if (heldItem.is(RED_DIAMOND_TOOLS) && (event.getState().getDestroySpeed(player.level(), event.getPos()) > 0f )) {
                player.heal(1f);
                if (player.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.HEART, player.getX(), player.getY() + 0.5, player.getZ(), 1, 0.5, 0.5, 0.5, 0.5);
                }
            }
        }

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

}
