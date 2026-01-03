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

public class LaserBeamModel<T extends Entity> extends EntityModel<T> {

        private final ModelPart bb_main;

        public LaserBeamModel(ModelPart root) {
            this.bb_main = root.getChild("bb_main");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -9.0F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(0.5F, -8.6F, -5.0F, 0.25F, 0.25F, 10.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(-0.75F, -8.6F, -5.0F, 0.25F, 0.25F, 10.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(-0.15F, -9.25F, -5.0F, 0.25F, 0.25F, 10.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(-0.15F, -8.0F, -5.0F, 0.25F, 0.25F, 10.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(-0.25F, -8.75F, -5.5F, 0.5F, 0.5F, 0.5F, new CubeDeformation(0.0F))
                    .texOffs(0, 0).addBox(-0.25F, -8.75F, 5.0F, 0.5F, 0.5F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

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
