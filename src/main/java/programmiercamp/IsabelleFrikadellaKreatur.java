package programmiercamp;

import programmiercamp.vorlagen.TierVorlage;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;


public class IsabelleFrikadellaKreatur extends TierVorlage {
    public IsabelleFrikadellaKreatur(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void gebeName() {
        name = "isabelle_frikadella";
    }
}
