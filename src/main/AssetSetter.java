package main;

import object.OBJ_Key;

public class AssetSetter {
    GPanel gp;

    public AssetSetter(GPanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.objects.add(new OBJ_Key());
        gp.objects.get(0).xMap = 25 * gp.tiLeSize;
        gp.objects.get(0).yMap = 25 * gp.tiLeSize;

        gp.objects.add(new OBJ_Key());
        gp.objects.get(1).xMap = 32 * gp.tiLeSize;
        gp.objects.get(1).yMap = 36 * gp.tiLeSize;
    }
}
