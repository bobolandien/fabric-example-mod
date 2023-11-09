package programmiercamp;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Material;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.BlockSoundGroup;
import programmiercamp.registry.Mod;
import programmiercamp.registry.ModBlocks;
import programmiercamp.registry.ModEntities;
import net.minecraft.item.Items;
import programmiercamp.vorlagen.goals.*;


public class TestMod implements ModInitializer {

    public static final String MOD_ID = "test_mod";

    public static final ItemGroup GRUPPE = Mod.GruppeErstellen("test_mod", MOD_ID);

    @Override
    public void onInitialize() {
    Mod.ItemHinzufuegen ("vampire_dagger", GRUPPE, MOD_ID ) ;
        Mod.ItemHinzufuegen("vampire_erz",GRUPPE, MOD_ID);
        Mod.ItemHinzufuegen("rubin",GRUPPE, MOD_ID);

        Mod.BlockHinzufuegen("rubin_block", Material.METAL, 4, 2, BlockSoundGroup.METAL,
                ModBlocks.WerkzeugArt.SPITZHACKE, 0, 20, GRUPPE, MOD_ID);

        Mod.BlockHinzufuegen("vampire_block", Material.METAL, 4, 2, BlockSoundGroup.METAL,
                ModBlocks.WerkzeugArt.SPITZHACKE, 0, 20, GRUPPE, MOD_ID);

        Mod.BlockHinzufuegen("rubin_erz", Material.STONE, 4, 10, BlockSoundGroup.STONE, ModBlocks.WerkzeugArt.SPITZHACKE,
                2, 40, GRUPPE, MOD_ID);
        {
        Mod.SpitzhackeHinzufuegen("rubin_spitzhacke", new RubinMaterial(), 8, 1.0f, GRUPPE, MOD_ID);
        Mod.FeldhackeHinzufuegen("rubin_feldhacke", new RubinMaterial(), 8, 1.0f, GRUPPE, MOD_ID);
        Mod.SchaufelHinzufuegen("rubin_schaufel", new RubinMaterial(), 8, 1.0f, GRUPPE, MOD_ID);
        Mod.AxtHinzufuegen("rubin_axt", new RubinMaterial(), 8, 1.0f, GRUPPE, MOD_ID);
        Mod.SchwertHinzufuegen("rubin_schwert", new RubinMaterial(), 8, 1.0f, GRUPPE, MOD_ID);

        // isabelle_frikadella besitzt keine Textur, das ist kein Problem. Sie bekommt eine MissingTexture Texture zugewiesen.
        Mod.TierHinzufuegen("isabelle_frikadella", IsabelleFrikadellaKreatur::new, new IsabelleFrikadellaModell(), 2.0f, 1.5f, 1.0f, MOD_ID);
        Mod.AttributHinzufuegen("isabelle_frikadella", ModEntities.KreaturAttribute.LEBEN, 20.0f);
        Mod.AttributHinzufuegen("isabelle_frikadella", ModEntities.KreaturAttribute.LAUF_GESCHWINDIGKEIT, 0.1f);
        Mod.AttributHinzufuegen("isabelle_frikadella", ModEntities.KreaturAttribute.REICHWEITE, 5.0f);
        Mod.ZielHinzufuegen("isabelle_frikadella", new SchwimmenZiel());
        Mod.ZielHinzufuegen("isabelle_frikadella", new PanikZiel(1.0d));
        Mod.ZielHinzufuegen("isabelle_frikadella", new KinderZeugenZiel(Ingredient.ofItems(Items.WHEAT, Items.CACTUS, Items.PORKCHOP)));
        Mod.ZielHinzufuegen("isabelle_frikadella", new FliehenZiel(SheepEntity.class, 80.0f, 5.0));
        Mod.ZielHinzufuegen("isabelle_frikadella", new VerlockungsZiel(0.5d, Ingredient.ofItems(Items.WHEAT_SEEDS)));
        Mod.ZielHinzufuegen("isabelle_frikadella", new HerumlaufenZiel(10));
        Mod.ZielHinzufuegen("isabelle_frikadella", new MobAnschauenZiel(IsabelleFrikadellaKreatur.class, 10.0f));
        Mod.ZielHinzufuegen("isabelle_frikadella", new ZufaelligHerumschauenZiel());

        Mod.MonsterHinzufuegen("max_monster", MaxMonsterKreatur::new, new MaxMonsterModell(), 0.7f, 1.0f, 2.0f, MOD_ID);
        Mod.AttributHinzufuegen("max_monster", ModEntities.KreaturAttribute.LEBEN, 10.0f);
        Mod.AttributHinzufuegen("max_monster", ModEntities.KreaturAttribute.SCHADEN, 5.0f);
        Mod.AttributHinzufuegen("max_monster", ModEntities.KreaturAttribute.RUECKSTOSS, 6.0f);
        Mod.AttributHinzufuegen("max_monster", ModEntities.KreaturAttribute.REICHWEITE, 16.0f);
        Mod.ZielHinzufuegen("max_monster", new NahkampfAngriffZiel(1.2d));
        Mod.ZielHinzufuegen("max_monster", new VerfolgenZiel<>(IsabelleFrikadellaKreatur.class));

        Mod.AttributeRegistrieren();}

    }
}