package me.kev.sharewarearsenal.Particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class FalconParticle extends TextureSheetParticle {

    protected FalconParticle(ClientLevel clientLevel, double posX, double posY, double posZ, SpriteSet spriteSet, double xSpeed, double ySpeed, double zSpeed) {
        super(clientLevel, posX, posY, posZ, xSpeed, ySpeed, zSpeed);

        this.hasPhysics = false;
        this.xd = 0;
        this.yd = 0;
        this.zd = 0;
        this.setSize(64, 64);
        this.lifetime = 20;
        this.setSpriteFromAge(spriteSet);

    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double v, double v1, double v2, double v3, double v4, double v5) {
            return new FalconParticle(clientLevel, v, v1, v2, this.spriteSet, v3, v4, v5);
        }
    }

}
