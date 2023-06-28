package main;

import object.OBJ_Chest;
import item.ITEM_Key;

public class AssetSetter {
    GPanel gp;

    public AssetSetter(GPanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.objects.add(new OBJ_Chest());
        gp.objects.get(0).xMap = 25 * gp.tiLeSize;
        gp.objects.get(0).yMap = 25 * gp.tiLeSize;

        gp.objects.add(new OBJ_Chest());
        gp.objects.get(1).xMap = 32 * gp.tiLeSize;
        gp.objects.get(1).yMap = 36 * gp.tiLeSize;

        gp.objects.add(new OBJ_Chest());
        gp.objects.get(2).xMap = 20 * gp.tiLeSize;
        gp.objects.get(2).yMap = 27 * gp.tiLeSize;

        gp.objects.add(new OBJ_Chest());
        gp.objects.get(2).xMap = 0 * gp.tiLeSize;
        gp.objects.get(2).yMap = 0 * gp.tiLeSize;
    }

    public void setItems() {
        gp.items.add(new ITEM_Key());
        gp.items.get(0).xMap = 26 * gp.tiLeSize;
        gp.items.get(0).yMap = 26 * gp.tiLeSize;

        gp.items.add(new ITEM_Key());
        gp.items.get(1).xMap = 30 * gp.tiLeSize;
        gp.items.get(1).yMap = 25 * gp.tiLeSize;

        gp.items.add(new ITEM_Key());
        gp.items.get(2).xMap = 35 * gp.tiLeSize;
        gp.items.get(2).yMap = 32 * gp.tiLeSize;
    }
}
