package programmiercamp.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.item.BlockItem;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.minecraft.item.Item;

import java.util.List;
import java.util.Stack;

public class ModBlocks {

    private static Stack<BlockItem> BlockItems = new Stack<BlockItem>();
    private static Stack<Block> Blocks = new Stack<Block>();

    public enum WerkzeugArt
    {
        SPITZHACKE (FabricToolTags.PICKAXES),
        SCHAUFEL (FabricToolTags.SHOVELS),
        FELDHACKE (FabricToolTags.HOES),
        AXT (FabricToolTags.AXES),
        SCHWERT (FabricToolTags.SWORDS);

        private Tag<Item> m_tag;
        WerkzeugArt(Tag<Item> tag)
        {
            this.m_tag = tag;
        }

        public Tag<Item> GetTag() { return m_tag;}
    }

    public static List<Block> GetBlocks() {return Blocks;}
    public static List<BlockItem> GetBlockItems() {return BlockItems;}


    public static void BlockHinzufuegen(String name, Material material, int level, float hearte, BlockSoundGroup sound, WerkzeugArt werkzeug, ItemGroup group, String modid) {
        BlockHinzufuegen(name, material, level, hearte, sound, werkzeug, 0, 20.f, group, modid);
    }

    public static void BlockHinzufuegen(String name, Material material, int level, float haerte, BlockSoundGroup sound, WerkzeugArt werkzeug, int leuchtlevel, float resistenz, ItemGroup group, String modid)
    {
        Block BLOCK = new Block(FabricBlockSettings
        .of(material)
        .breakByTool(werkzeug.GetTag(), level)
        .luminance(leuchtlevel)
        .requiresTool()
        .strength(haerte, resistenz)
        .sounds(sound));

        Blocks.push(BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(modid, name), BLOCK);

        BlockItem BLOCK_ITEM = new BlockItem(BLOCK, new Item.Settings().group(group));
        BlockItems.push(BLOCK_ITEM);
        Registry.register(Registry.ITEM, new Identifier(modid, name), BLOCK_ITEM);

    }
}
