package programmiercamp.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


import net.minecraft.item.Item;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    private static Map<String ,Item> Items = new HashMap<String, Item>() ;
    private static Item firstItem = null;

    public static Stack<Item> GetItems() {
        Stack<Item> stack = new Stack<Item>();
        stack.push(firstItem);
        return stack;
    }


    public static Item GetItem(String name) { return Items.get(name);}


    public static void ItemHinzufuegen(String name, Item item, String modid)
    {
        if(firstItem == null)
            firstItem = item;
        Items.put(name, item);
        Registry.register(Registry.ITEM, new Identifier(modid, name), item);
    }

}
