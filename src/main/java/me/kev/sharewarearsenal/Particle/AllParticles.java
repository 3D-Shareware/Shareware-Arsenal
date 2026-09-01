package me.kev.sharewarearsenal.Particle;

import me.kev.sharewarearsenal.Sharewarearsenal;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AllParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Sharewarearsenal.MODID);

    // should set to false for more ambient particles, but this particle is pretty important
    public static final RegistryObject<SimpleParticleType> FALCON_PARTICLE =
            PARTICLE_TYPES.register("falcon_particle", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }

}
