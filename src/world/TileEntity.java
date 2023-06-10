package world;

public enum TileEntity {

    DIRT('D', "/dirt.png"),
    GRASS('G', "/grass.png"),
    SAND('S',  "/sand.png");

    private final char code;
    private final String res;

    TileEntity(char c, String r) {
        this.code = c;
        this.res = r;
    }

    public char getCode() { return this.code; }

    public String getRes() { return this.res; }

    public static TileEntity fromCode(char c) {
        for (TileEntity entity : values()) {
            if (entity.getCode() == c)
                return entity;
        }
        return null;
    }
}
