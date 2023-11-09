package programmiercamp;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import programmiercamp.ausruestung.AusruestungsMaterial;
import programmiercamp.registry.Mod;


public class RubinMaterial extends AusruestungsMaterial {

    @Override
    public int gebeHaltbarkeit() {
        return 3500;
    }

    @Override
    public float gebeAbbauGeschwindigkeitMultiplikator() {
        return 11.0f;
    }

    @Override
    public float gebeAngriffsSchaden() {
        return 0;
    }

    @Override
    public int gebeAbbauLevel() {
        return 5;
    }

    @Override
    public int gebeVerzaubarkeit() {
        return 15;
    }

    @Override
    public Item[] gebeReparaturZutat() {
        return new Item[]{
                Mod.HoleItem("rubin"),
                Items.DIAMOND
        };
    }
}
