package programmiercamp.registry;

import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import programmiercamp.vorlagen.goals.Ziel;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.EntityFactory;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;

import java.util.HashMap;
import java.util.LinkedList;


public class ModEntities {
    public static class Tier {
        public EntityType<AnimalEntity> tier;
        public Builder attribute;
        public LinkedList<Ziel> verhalten;
        public Ingredient futter;

        public Tier(EntityType<AnimalEntity> kreatur, Builder attribute) {
            this.tier = kreatur;
            this.attribute = attribute;
            this.verhalten = new LinkedList<>();
            this.futter = Ingredient.EMPTY;
        }
    }

    public static class Monster {
        public EntityType<HostileEntity> monster;
        public Builder attribute;
        public LinkedList<Ziel> verhalten;

        public Monster(EntityType<HostileEntity> monster, Builder attribute) {
            this.monster = monster;
            this.attribute = attribute;
            this.verhalten = new LinkedList<>();
        }
    }

    public static HashMap<String, Tier> TIERE = new HashMap<>();
    public static HashMap<String, Monster> MONSTER = new HashMap<>();

    public static void TierHinzufuegen(String name, EntityFactory<AnimalEntity> tier, EntityModel<? extends PathAwareEntity> skelett, float schattenRadius, float breite, float hoehe, String modid) {
        EntityType<AnimalEntity> TIER = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(modid, name.toLowerCase()),
                FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, tier)
                        .dimensions(EntityDimensions.fixed(breite, hoehe))
                        .build());

        EntityRendererRegistry.INSTANCE.register(TIER, (dispatcher, context) -> {
            return new MobEntityRenderer<AnimalEntity, EntityModel<AnimalEntity>>(dispatcher, (EntityModel<AnimalEntity>) skelett, schattenRadius) {
                @Override
                public Identifier getTexture(AnimalEntity entity) {
                    return new Identifier(modid, "textures/entities/" + name + ".png");
                }
            };
        });

        TIERE.put(name.toLowerCase(), new Tier(TIER, MobEntity.createMobAttributes()));
    }

    public static void MonsterHinzufuegen(String name, EntityFactory<HostileEntity> monster, EntityModel<? extends PathAwareEntity> skelett, float schattenRadius, float breite, float hoehe, String modid) {
        EntityType<HostileEntity> MONSTER_ = Registry.register(
                Registry.ENTITY_TYPE,
                new Identifier(modid, name.toLowerCase()),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, monster)
                        .dimensions(EntityDimensions.fixed(breite, hoehe))
                        .build());

        EntityRendererRegistry.INSTANCE.register(MONSTER_, (dispatcher, context) -> {
            return new MobEntityRenderer<HostileEntity, EntityModel<HostileEntity>>(dispatcher, (EntityModel<HostileEntity>) skelett, schattenRadius) {
                @Override
                public Identifier getTexture(HostileEntity entity) {
                    return new Identifier(modid, "textures/entities/" + name + ".png");
                }
            };
        });

        MONSTER.put(name.toLowerCase(), new Monster(MONSTER_, HostileEntity.createHostileAttributes()));
    }

    public static void AttributHinzufuegen(String name, KreaturAttribute attribut, double wert) {
        if (TIERE.get(name.toLowerCase()) != null) {
            TIERE.get(name.toLowerCase()).attribute.add(attribut.getAttribut(), wert);
        } else if (MONSTER.get(name.toLowerCase()) != null) {
            MONSTER.get(name.toLowerCase()).attribute.add(attribut.getAttribut(), wert);
        }
    }

    public static void AttributeRegistrieren() {
        for (String kreaturName : TIERE.keySet()) {
            FabricDefaultAttributeRegistry.register(TIERE.get(kreaturName).tier, TIERE.get(kreaturName).attribute);
        }

        for (String kreaturName : MONSTER.keySet()) {
            FabricDefaultAttributeRegistry.register(MONSTER.get(kreaturName).monster, MONSTER.get(kreaturName).attribute);
        }
    }

    public static void ZielHinzufuegen(String name, Ziel ziel) {
        if (TIERE.get(name.toLowerCase()) != null) {
            TIERE.get(name.toLowerCase()).verhalten.add(ziel);
        } else if (MONSTER.get(name.toLowerCase()) != null){
            MONSTER.get(name.toLowerCase()).verhalten.add(ziel);
        }
    }

    public enum KreaturAttribute {
        LEBEN (EntityAttributes.GENERIC_MAX_HEALTH),
        LAUF_GESCHWINDIGKEIT (EntityAttributes.GENERIC_MOVEMENT_SPEED),
        SCHADEN (EntityAttributes.GENERIC_ATTACK_DAMAGE),
        RUECKSTOSS (EntityAttributes.GENERIC_ATTACK_KNOCKBACK),
        RUESTUNG (EntityAttributes.GENERIC_ARMOR),
        RUECKSTOSS_WIDERSTAND (EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE),
        REICHWEITE (EntityAttributes.GENERIC_FOLLOW_RANGE);

        private EntityAttribute m_attribute;
        KreaturAttribute(EntityAttribute attribute) { this.m_attribute = attribute; }

        public EntityAttribute getAttribut() { return this.m_attribute; }
    }
}
