package programmiercamp;

import programmiercamp.vorlagen.ModelVorlage;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.PathAwareEntity;


public class MaxMonsterModell extends ModelVorlage {
    private final ModelPart koerper;
    private final ModelPart kopf;
    private final ModelPart linkerarm;
    private final ModelPart rechterarm;
    public MaxMonsterModell() {
        textureWidth = 64;
        textureHeight = 64;
        koerper = new ModelPart(this);
        koerper.setPivot(0.0F, 24.0F, 0.0F);
        koerper.setTextureOffset(0, 0).addCuboid(-5.0F, -13.0F, -4.0F, 9.0F, 3.0F, 9.0F, 0.0F, false);
        koerper.setTextureOffset(0, 22).addCuboid(-3.0F, -10.0F, -2.0F, 5.0F, 7.0F, 5.0F, 0.0F, false);
        koerper.setTextureOffset(0, 12).addCuboid(-4.0F, -3.0F, -3.0F, 7.0F, 3.0F, 7.0F, 0.0F, false);

        kopf = new ModelPart(this);
        kopf.setPivot(0.0F, 24.0F, 0.0F);
        kopf.setTextureOffset(20, 22).addCuboid(-3.0F, -20.0F, -2.0F, 5.0F, 6.0F, 5.0F, 0.0F, false);
        kopf.setTextureOffset(27, 0).addCuboid(-2.0F, -14.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
        kopf.setTextureOffset(21, 12).addCuboid(-2.0F, -17.0F, -6.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

        linkerarm = new ModelPart(this);
        linkerarm.setPivot(0.0F, 24.0F, 0.0F);
        linkerarm.setTextureOffset(15, 22).addCuboid(-7.0F, -9.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        linkerarm.setTextureOffset(19, 33).addCuboid(-7.0F, -8.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        linkerarm.setTextureOffset(32, 16).addCuboid(-4.0F, -10.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

        rechterarm = new ModelPart(this);
        rechterarm.setPivot(-1.0F, 24.0F, 1.0F);
        setRotationAngle(rechterarm, 0.0F, 3.1416F, 0.0F);
        rechterarm.setTextureOffset(0, 6).addCuboid(-7.0F, -9.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
        rechterarm.setTextureOffset(0, 12).addCuboid(-7.0F, -8.0F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
        rechterarm.setTextureOffset(0, 0).addCuboid(-4.0F, -10.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
    }
    @Override
    public void setAngles(PathAwareEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        //previously the render function, render code was moved to a method below
    }
    @Override
    public void render(MatrixStack matrixStack, VertexConsumer  buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

        koerper.render(matrixStack, buffer, packedLight, packedOverlay);
        kopf.render(matrixStack, buffer, packedLight, packedOverlay);
        linkerarm.render(matrixStack, buffer, packedLight, packedOverlay);
        rechterarm.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }
}