package com.CartersDev.crystechmod.entity.client.vitricCow;

import com.CartersDev.crystechmod.entity.custom.VitricCowEntity;

import net.minecraft.client.model.CowModel;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VitricCowModel  <T extends VitricCowEntity> extends CowModel<T> {

    public VitricCowModel(ModelPart pRoot) {
        super(pRoot);

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        var head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(4.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-5.0F, -5.0F, -5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 33).addBox(-3.0F, 1.0F, -7.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, -8.0F));

        var body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 4).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(52, 0).addBox(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

        partdefinition.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, 7.0F));

       partdefinition.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, 7.0F));

        partdefinition.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 12.0F, -6.0F));

        partdefinition.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 12.0F, -6.0F));

        head.addOrReplaceChild("headGrowths", CubeListBuilder.create().texOffs(22, 0).addBox(-10.0F, -23.0F, -9.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-1.0F, -23.0F, -9.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-4.0F, -23.0F, -8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-7.0F, -23.0F, -8.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-7.0F, -24.0F, -9.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-4.0F, -24.0F, -9.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 17.0F, 8.0F));

        body.addOrReplaceChild("bodyGrowths", CubeListBuilder.create().texOffs(22, 0).addBox(-4.0F, -23.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-1.0F, -23.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-2.0F, -23.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(2.0F, -23.0F, 4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(4.0F, -23.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(3.0F, -24.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-2.0F, -24.0F, -6.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(2.0F, -25.0F, -6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(0.0F, -25.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-5.0F, -25.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(3.0F, -25.0F, 7.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-3.0F, -24.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-1.0F, -24.0F, 8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-5.0F, -24.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -19.0F, -1.5708F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }


}
