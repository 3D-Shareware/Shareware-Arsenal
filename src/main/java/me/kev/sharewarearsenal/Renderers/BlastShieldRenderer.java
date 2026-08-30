package me.kev.sharewarearsenal.Renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

public class BlastShieldRenderer extends BlockEntityWithoutLevelRenderer {
    public static final BlastShieldRenderer INSTANCE = new BlastShieldRenderer();

    // Define your texture mapping location
    public static final Material SHIELD_MATERIAL = new Material(
            net.minecraft.client.renderer.texture.TextureAtlas.LOCATION_BLOCKS,
            new ResourceLocation("sharewarearsenal", "entity/blast_shield")
    );

    private final ShieldModel shieldModel;

    public BlastShieldRenderer() {
        super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
        // Grabs the vanilla shield shape structure
        this.shieldModel = new ShieldModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.SHIELD));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        poseStack.pushPose();
        poseStack.scale(1.0F, -1.0F, -1.0F);

        // Check if the shield has banner patterns applied, or default to custom flat texture
        boolean hasBanner = stack.getTagElement("BlockEntityTag") != null;

        VertexConsumer vertexConsumer = SHIELD_MATERIAL.sprite().wrap(
                ItemRenderer.getFoilBufferDirect(buffer, this.shieldModel.renderType(SHIELD_MATERIAL.atlasLocation()), true, stack.isEnchanted())
        );

        // Render the plate and the handle components
        this.shieldModel.plate().render(poseStack, vertexConsumer, packedLight, packedOverlay);
        this.shieldModel.handle().render(poseStack, vertexConsumer, packedLight, packedOverlay);

        poseStack.popPose();
    }
}