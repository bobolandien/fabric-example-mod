package programmiercamp;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import programmiercamp.vorlagen.MonsterVorlage;

public class MaxMonsterKreatur extends MonsterVorlage {
    public MaxMonsterKreatur(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void gebeName() {
        name = "max_monster";
    }
}
