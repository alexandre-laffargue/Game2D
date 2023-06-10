package world;

import java.util.Objects;

public enum TileEntity {
    //toutes les images du dossier tiles
    WATER0("W0", "/tiles/water0.png"),
    WATER1("W1", "/tiles/water1.png"),
    WATER2("W2", "/tiles/water2.png"),
    WATER3("W3", "/tiles/water3.png"),
    WATER4("W4", "/tiles/water4.png"),
    WATER5("W5", "/tiles/water5.png"),
    WATER6("W6", "/tiles/water6.png"),
    WATER7("W7", "/tiles/water7.png"),
    WATER8("W8", "/tiles/water8.png"),
    WATER9("W9", "/tiles/water9.png"),
    WATER10("W10", "/tiles/water10.png"),
    WATER11("W11", "/tiles/water11.png"),
    WATER12("W12", "/tiles/water12.png"),
    WATER13("W13", "/tiles/water13.png"),
    WATER14("W14", "/tiles/water14.png"),
    WATER15("W15", "/tiles/water15.png"),
    WATER16("W16", "/tiles/water16.png"),
    WATER17("W17", "/tiles/water17.png"),
    WATER18("W18", "/tiles/water18.png"),
    WATER19("W19", "/tiles/water19.png"),
    WATER20("W20", "/tiles/water20.png"),
    WATER21("W21", "/tiles/water21.png"),
    WATER22("W22", "/tiles/water22.png"),
    WATER23("W23", "/tiles/water23.png"),
    WATER24("W24", "/tiles/water24.png"),
    WATER25("W25", "/tiles/water25.png"),
    WATER26("W26", "/tiles/water26.png"),

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

    WATERDIRT1("WD1", "/tiles/waterdirt1.png"),
    WATERDIRT2("WD2", "/tiles/waterdirt2.png"),
    WATERDIRT3("WD3", "/tiles/waterdirt3.png"),
    WATERDIRT4("WD4", "/tiles/waterdirt4.png"),
    WATERDIRT5("WD5", "/tiles/waterdirt5.png"),
    WATERDIRT6("WD6", "/tiles/waterdirt6.png"),
    WATERDIRT7("WD7", "/tiles/waterdirt7.png"),
    WATERDIRT8("WD8", "/tiles/waterdirt8.png"),
    WATERDIRT9("WD9", "/tiles/waterdirt9.png"),
    WATERDIRT10("WD10", "/tiles/waterdirt10.png"),
    WATERDIRT11("WD11", "/tiles/waterdirt11.png"),
    WATERDIRT12("WD12", "/tiles/waterdirt12.png"),
    WATERDIRT13("WD13", "/tiles/waterdirt13.png"),
    WATERDIRT14("WD14", "/tiles/waterdirt14.png"),
    WATERDIRT15("WD15", "/tiles/waterdirt15.png"),
    WATERDIRT16("WD16", "/tiles/waterdirt16.png"),
    WATERDIRT17("WD17", "/tiles/waterdirt17.png"),
    WATERDIRT18("WD18", "/tiles/waterdirt18.png"),
    WATERDIRT19("WD19", "/tiles/waterdirt19.png"),
    WATERDIRT20("WD20", "/tiles/waterdirt20.png"),
    WATERDIRT21("WD21", "/tiles/waterdirt21.png"),
    WATERDIRT22("WD22", "/tiles/waterdirt22.png"),
    WATERDIRT23("WD23", "/tiles/waterdirt23.png"),
    WATERDIRT24("WD24", "/tiles/waterdirt24.png"),

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

    BLACKTREE("BT", "/tiles/blacktree.png"),
    DEADTREE("DT", "/tiles/deadtree.png"),
    REDTREE("RT", "/tiles/redtree.png"),
    YELLOWTREE("YT", "/tiles/yellowtree.png");

    private final String code;
    private final String res;

    TileEntity(String c, String r) {
        this.code = c;
        this.res = r;
    }

    public String getCode() { return this.code; }

    public String getRes() { return this.res; }

    public static TileEntity fromCode(String s) {
        for (TileEntity entity : values()) {
            if (Objects.equals(entity.getCode(), s))
                return entity;
        }
        return null;
    }
}
