package programmiercamp.vorlagen;

import programmiercamp.registry.ModEntities;
import programmiercamp.vorlagen.goals.Ziel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;


public abstract class MonsterVorlage extends HostileEntity {
    protected String name;

    protected MonsterVorlage(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void initGoals() {
        this.gebeName();
        int i = 0;
        for (Ziel ziel : ModEntities.MONSTER.get(this.name.toLowerCase()).verhalten) {
            this.goalSelector.add(i, ziel.create(this));
            i++;
        }
    }

    public abstract void gebeName();
}
