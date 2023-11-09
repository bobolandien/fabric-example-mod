package programmiercamp.vorlagen.goals;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.FollowTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;

import java.util.function.Predicate;


public class VerfolgenZiel<T extends LivingEntity> extends Ziel {
    private Class<T> target;

    public VerfolgenZiel(Class<T> mob) {
        this.target = mob;
    }

    @Override
    public Goal create(Object instance) {
        return new FollowTargetGoal<T>(
                (PathAwareEntity) instance,
                this.target,
                0,
                true,
                true,
                (Predicate)null
        );
    }
}
