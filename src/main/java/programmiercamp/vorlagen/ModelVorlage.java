package programmiercamp.vorlagen;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.MathHelper;


public abstract class ModelVorlage extends EntityModel<PathAwareEntity> {

    public static void bewegeKoerperteil(ModelPart koerperteil, float limbSwing, float limbSwingAmount) {
        // limbAngle = [0, inf)
        // limbDistance = [0, 1]
        // limbDistance determines progress in animation
        koerperteil.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    public static void bewegeKopf(ModelPart kopf, float netHeadYaw, float headPitch) {
        kopf.pitch = headPitch * 0.017453292F;
        kopf.yaw = netHeadYaw * 0.017453292F;
    }
}
