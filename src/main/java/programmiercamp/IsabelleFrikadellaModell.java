package programmiercamp;

import programmiercamp.vorlagen.ModelVorlage;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.PathAwareEntity;


public class IsabelleFrikadellaModell extends ModelVorlage {
    private final ModelPart body;
    private final ModelPart rotation;
    private final ModelPart body_sub_1;
    private final ModelPart head;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;

    public IsabelleFrikadellaModell() {
        textureWidth = 64;
        textureHeight = 32;
        body = new ModelPart(this);
        body.setPivot(0.0F, 11.0F, 2.0F);


        rotation = new ModelPart(this);
        rotation.setPivot(0.0F, 0.0F, 0.0F);
        body.addChild(rotation);
        setRotationAngle(rotation, 1.5708F, 0.0F, 0.0F);


        body_sub_1 = new ModelPart(this);
        body_sub_1.setPivot(0.0F, 0.0F, 0.0F);
        rotation.addChild(body_sub_1);
        body_sub_1.setTextureOffset(28, 8).addCuboid(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F, 0.0F, false);

        head = new ModelPart(this);
        head.setPivot(0.0F, 12.0F, -6.0F);
        head.setTextureOffset(0, 0).addCuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(16, 16).addCuboid(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

        leg1 = new ModelPart(this);
        leg1.setPivot(3.0F, 18.0F, 7.0F);
        leg1.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leg2 = new ModelPart(this);
        leg2.setPivot(-3.0F, 18.0F, 7.0F);
        leg2.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leg3 = new ModelPart(this);
        leg3.setPivot(3.0F, 18.0F, -5.0F);
        leg3.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leg4 = new ModelPart(this);
        leg4.setPivot(-3.0F, 18.0F, -5.0F);
        leg4.setTextureOffset(0, 16).addCuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setAngles(PathAwareEntity entity, float limbAngle, float limbDistance, float ageInTicks, float headYaw, float headPitch) {
        ModelVorlage.bewegeKoerperteil(leg1, limbAngle, limbDistance);
        ModelVorlage.bewegeKoerperteil(leg2, limbAngle, limbDistance);
        ModelVorlage.bewegeKoerperteil(leg3, limbAngle, limbDistance);
        ModelVorlage.bewegeKoerperteil(leg4, limbAngle, limbDistance);
        ModelVorlage.bewegeKopf(head, headYaw, headPitch);
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}
