package world;

import java.util.Objects;

public enum TileEntity {
    //toutes les images du dossier tiles
    WATER0("W0", "/tiles/water0.png", true),
    WATER1("W1", "/tiles/water1.png", true),
    WATER2("W2", "/tiles/water2.png", true),
    WATER3("W3", "/tiles/water3.png", true),
    WATER4("W4", "/tiles/water4.png", true),
    WATER5("W5", "/tiles/water5.png", true),
    WATER6("W6", "/tiles/water6.png", true),
    WATER7("W7", "/tiles/water7.png", true),
    WATER8("W8", "/tiles/water8.png", true),
    WATER9("W9", "/tiles/water9.png", true),
    WATER10("W10", "/tiles/water10.png", true),
    WATER11("W11", "/tiles/water11.png", true),
    WATER12("W12", "/tiles/water12.png", true),
    WATER13("W13", "/tiles/water13.png", true),
    WATER14("W14", "/tiles/water14.png", true),
    WATER15("W15", "/tiles/water15.png", true),
    WATER16("W16", "/tiles/water16.png", true),
    WATER17("W17", "/tiles/water17.png", true),
    WATER18("W18", "/tiles/water18.png", true),
    WATER19("W19", "/tiles/water19.png", true),
    WATER20("W20", "/tiles/water20.png", true),
    WATER21("W21", "/tiles/water21.png", true),
    WATER22("W22", "/tiles/water22.png", true),
    WATER23("W23", "/tiles/water23.png", true),
    WATER24("W24", "/tiles/water24.png", true),
    WATER25("W25", "/tiles/water25.png", true),
    WATER26("W26", "/tiles/water26.png", true),

    GRASS0("G0", "/tiles/grass.png"),

    PLAINS0("P0", "/tiles/plains.png"),
    PLAINS1("P1", "/tiles/plains1.png"),
    PLAINS2("P2", "/tiles/plains2.png"),
    PLAINS3("P3", "/tiles/plains3.png"),
    PLAINS4("P4", "/tiles/plains4.png"),
    PLAINS5("P5", "/tiles/plains5.png"),
    PLAINS6("P6", "/tiles/plains6.png"),
    PLAINS7("P7", "/tiles/plains7.png"),
    PLAINS8("P8", "/tiles/plains8.png"),
    PLAINS9("P9", "/tiles/plains9.png"),
    PLAINS10("P10", "/tiles/plains10.png"),
    PLAINS11("P11", "/tiles/plains11.png"),
    PLAINS12("P12", "/tiles/plains12.png"),
    PLAINS13("P13", "/tiles/plains13.png"),
    PLAINS14("P14", "/tiles/plains14.png"),
    PLAINS15("P15", "/tiles/plains15.png"),
    PLAINS16("P16", "/tiles/plains16.png"),
    PLAINS17("P17", "/tiles/plains17.png"),
    PLAINS18("P18", "/tiles/plains18.png"),
    PLAINS19("P19", "/tiles/plains19.png"),
    PLAINS20("P20", "/tiles/plains20.png"),
    PLAINS21("P21", "/tiles/plains21.png"),

    WATERDIRT1("WD1", "/tiles/waterdirt1.png", true),
    WATERDIRT2("WD2", "/tiles/waterdirt2.png", true),
    WATERDIRT3("WD3", "/tiles/waterdirt3.png", true),
    WATERDIRT4("WD4", "/tiles/waterdirt4.png", true),
    WATERDIRT5("WD5", "/tiles/waterdirt5.png", true),
    WATERDIRT6("WD6", "/tiles/waterdirt6.png", true),
    WATERDIRT7("WD7", "/tiles/waterdirt7.png", true),
    WATERDIRT8("WD8", "/tiles/waterdirt8.png", true),
    WATERDIRT9("WD9", "/tiles/waterdirt9.png", true),
    WATERDIRT10("WD10", "/tiles/waterdirt10.png", true),
    WATERDIRT11("WD11", "/tiles/waterdirt11.png", true),
    WATERDIRT12("WD12", "/tiles/waterdirt12.png", true),
    WATERDIRT13("WD13", "/tiles/waterdirt13.png", true),
    WATERDIRT14("WD14", "/tiles/waterdirt14.png", true),
    WATERDIRT15("WD15", "/tiles/waterdirt15.png", true),
    WATERDIRT16("WD16", "/tiles/waterdirt16.png", true),
    WATERDIRT17("WD17", "/tiles/waterdirt17.png", true),
    WATERDIRT18("WD18", "/tiles/waterdirt18.png", true),
    WATERDIRT19("WD19", "/tiles/waterdirt19.png", true),
    WATERDIRT20("WD20", "/tiles/waterdirt20.png", true),
    WATERDIRT21("WD21", "/tiles/waterdirt21.png", true),
    WATERDIRT22("WD22", "/tiles/waterdirt22.png", true),
    WATERDIRT23("WD23", "/tiles/waterdirt23.png", true),
    WATERDIRT24("WD24", "/tiles/waterdirt24.png", true),

    WAY0("WY0", "/tiles/way0.png"),
    WAY1("WY1", "/tiles/way1.png"),
    WAY2("WY2", "/tiles/way2.png"),
    WAY3("WY3", "/tiles/way3.png"),
    WAY4("WY4", "/tiles/way4.png"),
    WAY5("WY5", "/tiles/way5.png"),
    WAY6("WY6", "/tiles/way6.png"),
    WAY7("WY7", "/tiles/way7.png"),
    WAY8("WY8", "/tiles/way8.png"),
    WAY9("WY9", "/tiles/way9.png"),
    WAY10("WY10", "/tiles/way10.png"),
    WAY11("WY11", "/tiles/way11.png"),
    WAY12("WY12", "/tiles/way12.png"),

    BLACKTREE("BT", "/tiles/blacktree.png", true),
    DEADTREE("DT", "/tiles/deadtree.png"),
    REDTREE("RT", "/tiles/redtree.png", true),
    YELLOWTREE("YT", "/tiles/yellowtree.png", true);

    private final String code;
    private final String res;
    private boolean collision = false;
    TileEntity(String c, String r) {
        this.code = c;
        this.res = r;
    }

    TileEntity(String c, String r, boolean collision) {
        this.code = c;
        this.res = r;
        this.collision = collision;
    }

    public String getCode() { return this.code; }

    public String getRes() { return this.res; }
    public boolean isCollision() { return this.collision; }

    public static TileEntity fromCode(String s) {
        for (TileEntity entity : values()) {
            if (Objects.equals(entity.getCode(), s))
                return entity;
        }
        return null;
    }
}
