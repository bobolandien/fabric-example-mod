package programmiercamp.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import programmiercamp.vorlagen.goals.Ziel;
import net.minecraft.block.Material;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.sound.BlockSoundGroup;
import programmiercamp.ausruestung.*;

public class Mod {
    public static ItemGroup GruppeErstellen(String name, String modid) {
        return FabricItemGroupBuilder.create(new Identifier(modid, name))
            .icon(() -> new ItemStack(ModBlocks.GetBlockItems().isEmpty() ? ModItems.GetItems().isEmpty() ? Items.DIAMOND : ModItems.GetItems().get(0) : ModBlocks.GetBlockItems().get(0)))
            .build();
    }

    public static void ItemHinzufuegen(String name, ItemGroup group, String modid) {
        Item item = new Item(new Item.Settings().group(group));
        ModItems.ItemHinzufuegen(name, item, modid);
    }

    public static Item HoleItem(String name) {
        return ModItems.GetItem(name);
    }

    public static void BlockHinzufuegen(String name, Material material, int level, float haerte, BlockSoundGroup sound, ModBlocks.WerkzeugArt werkzeug, ItemGroup itemGruppe, String modid) {
        ModBlocks.BlockHinzufuegen(name, material, level, haerte, sound, werkzeug, itemGruppe, modid);
    }

    public static void BlockHinzufuegen(String name, Material material, int level, float haerte, BlockSoundGroup sound, ModBlocks.WerkzeugArt werkzeug, int leuchtlevel, int resistenz,  ItemGroup itemGruppe, String modid) {
        ModBlocks.BlockHinzufuegen(name, material, level, haerte, sound, werkzeug, leuchtlevel, resistenz, itemGruppe, modid);
    }

    public static void SpitzhackeHinzufuegen(String name, AusruestungsMaterial material, int angriffsSchaden, float angriffsGeschwindigkeit, ItemGroup itemGruppe, String modid) {
        ToolItem spitzhacke = new CustomPickaxe(material, angriffsSchaden, angriffsGeschwindigkeit, new Item.Settings().group(itemGruppe));
        ModItems.ItemHinzufuegen(name, spitzhacke, modid);
    }

    public static void AxtHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem axt = new CustomAxe(material, AngriffsSchaden, AngriffsGeschwindigkeit, new Item.Settings().group(group));
        ModItems.ItemHinzufuegen(name, axt, modid);
    }

    public static void SchaufelHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem schaufel = new CustomShovel(material, AngriffsSchaden, AngriffsGeschwindigkeit, new Item.Settings().group(group));
        ModItems.ItemHinzufuegen(name, schaufel, modid);
    }

    public static void FeldhackeHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem feldhacke = new CustomHoe(material, AngriffsSchaden, AngriffsGeschwindigkeit, new Item.Settings().group(group));
        ModItems.ItemHinzufuegen(name, feldhacke, modid);
    }

    public static void SchwertHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem schwert = new CustomSword(material, AngriffsSchaden, AngriffsGeschwindigkeit, new Item.Settings().group(group));
        ModItems.ItemHinzufuegen(name, schwert, modid);
    }

    public static void TierHinzufuegen(String name, EntityType.EntityFactory<AnimalEntity> tier, EntityModel<? extends PathAwareEntity> model, float schattenradius, float breite, float hoehe, String modid) {
        ModEntities.TierHinzufuegen(name, tier, model, schattenradius, breite, hoehe, modid);
    }

    public static void MonsterHinzufuegen(String name, EntityType.EntityFactory<HostileEntity> monster, EntityModel<? extends PathAwareEntity> model, float schattenradius, float breite, float hoehe,String modid) {
        ModEntities.MonsterHinzufuegen(name, monster, model, schattenradius, breite, hoehe, modid);
    }

    public static void AttributHinzufuegen(String name, ModEntities.KreaturAttribute attribut, double wert) {
        ModEntities.AttributHinzufuegen(name, attribut, wert);
    }

    public static void ZielHinzufuegen(String name, Ziel ziel) {
        ModEntities.ZielHinzufuegen(name, ziel);
    }

    public static void AttributeRegistrieren() {
        ModEntities.AttributeRegistrieren();
    }
}
