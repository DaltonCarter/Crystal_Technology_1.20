package com.CartersDev.crystechmod.entity.client.LaserBeam;


    // Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;

public class PoisonLaserBeamModel<T extends Entity> extends EntityModel<T> {

        private final ModelPart bb_main;

        public PoisonLaserBeamModel(ModelPart root) {
            this.bb_main = root.getChild("bb_main");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create()
                    .texOffs(0, 10).addBox(-13.0F, -9.0F, 7.5F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 11).addBox(-13.0F, -8.6F, 8.5F, 10.0F, 0.25F, 0.25F, new CubeDeformation(0.0F))
                    .texOffs(0, 11).addBox(-13.0F, -8.6F, 7.25F, 10.0F, 0.25F, 0.25F, new CubeDeformation(0.0F))
                    .texOffs(0, 11).addBox(-13.0F, -9.25F, 7.88F, 10.0F, 0.25F, 0.25F, new CubeDeformation(0.0F))
                    .texOffs(0, 11).addBox(-13.0F, -8.0F, 7.88F, 10.0F, 0.25F, 0.25F, new CubeDeformation(0.0F))
                    .texOffs(0, 2).addBox(-13.25F, -8.75F, 7.75F, 0.5F, 0.5F, 0.5F, new CubeDeformation(0.0F))
                    .texOffs(0, 2).addBox(-3.25F, -8.75F, 7.75F, 0.5F, 0.5F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 8.0F, -8.0F));
            return LayerDefinition.create(meshdefinition, 32, 32);
        }

        @Override
        public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
