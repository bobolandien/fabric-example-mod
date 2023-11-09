package programmiercamp.vorlagen;

import programmiercamp.registry.ModEntities;
import programmiercamp.vorlagen.goals.VerlockungsZiel;
import programmiercamp.vorlagen.goals.Ziel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public abstract class TierVorlage extends AnimalEntity {
    protected String name;

    protected TierVorlage(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.gebeName();
    }

    @Override
    public void initGoals() {
        this.gebeName();
        int i = 0;
        for (Ziel ziel : ModEntities.TIERE.get(this.name.toLowerCase()).verhalten) {
            if (ziel instanceof VerlockungsZiel) {
                ModEntities.TIERE.get(this.name.toLowerCase()).futter = ((VerlockungsZiel) ziel).getFood();
            }

            this.goalSelector.add(i, ziel.create(this));
            i++;
        }
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.TIERE.get(this.name.toLowerCase()).tier.create(world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return ModEntities.TIERE.get(this.name.toLowerCase()).futter.test(stack);
    }

    public abstract void gebeName();
}
