package main;

import entity.Entity;

public class CollisionChecker {

    GPanel gp;

    public CollisionChecker(GPanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.xMap - (entity.spriteDimX * entity.spritescale)/2 + entity.solidArea.x;
        int entityRightWorldX = entity.xMap - (entity.spriteDimX * entity.spritescale)/2 + entity.solidArea.x  + entity.solidArea.width;
        int entityTopWorldY = entity.yMap - (entity.spriteDimY * entity.spritescale)/2 + entity.solidArea.y;
        int entityBottomWorldY = entity.yMap - (entity.spriteDimY * entity.spritescale)/2 + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX/gp.tiLeSize;
        int entityRightCol = entityRightWorldX/gp.tiLeSize;
        int entityTopRow = entityTopWorldY/gp.tiLeSize;
        int entityBottomRow = entityBottomWorldY/gp.tiLeSize;


        switch (entity.direction) {
            case 0:
                entityBottomRow = (entityBottomWorldY + entity.speed)/gp.tiLeSize;
                if (gp.map.tiles[entityBottomRow][entityLeftCol].collision == true || gp.map.tiles[entityBottomRow][entityRightCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case 1:
                entityTopRow = (entityTopWorldY - entity.speed)/gp.tiLeSize;
                if (gp.map.tiles[entityTopRow][entityLeftCol].collision == true || gp.map.tiles[entityTopRow][entityRightCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case 2:
                entityLeftCol = (entityLeftWorldX - entity.speed)/gp.tiLeSize;
                if (gp.map.tiles[entityTopRow][entityLeftCol].collision == true || gp.map.tiles[entityBottomRow][entityLeftCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case 3:
                entityRightCol = (entityRightWorldX + entity.speed)/gp.tiLeSize;
                if (gp.map.tiles[entityTopRow][entityRightCol].collision == true || gp.map.tiles[entityBottomRow][entityRightCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case 4:
                entityBottomRow = (int)(entityBottomWorldY + entity.speed/Math.sqrt(2))/gp.tiLeSize;
                entityLeftCol = (int)(entityLeftWorldX - entity.speed/Math.sqrt(2))/gp.tiLeSize;
                if (gp.map.tiles[entityBottomRow][entityLeftCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case 5:
                entityBottomRow = (int)(entityBottomWorldY + entity.speed/Math.sqrt(2))/gp.tiLeSize;
                entityRightCol = (int)(entityRightWorldX + entity.speed/Math.sqrt(2))/gp.tiLeSize;
                if (gp.map.tiles[entityBottomRow][entityRightCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case 6:
                entityTopRow = (int)(entityTopWorldY - entity.speed/Math.sqrt(2))/gp.tiLeSize;
                entityLeftCol = (int)(entityLeftWorldX - entity.speed/Math.sqrt(2))/gp.tiLeSize;
                if (gp.map.tiles[entityTopRow][entityLeftCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
            case 7:
                entityTopRow = (int)(entityTopWorldY - entity.speed/Math.sqrt(2))/gp.tiLeSize;
                entityRightCol = (int)(entityRightWorldX + entity.speed/Math.sqrt(2))/gp.tiLeSize;
                if (gp.map.tiles[entityTopRow][entityRightCol].collision == true) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    public int checkObject(Entity entity, boolean player) {

        int index = -1;

        for (int i = 0; i < gp.objects.size(); i++) {

            int lastX = entity.solidArea.x, lastY = entity.solidArea.y;
            entity.solidArea.x = entity.xMap;
            entity.solidArea.y = entity.yMap;

            gp.objects.get(i).solidArea.x += gp.objects.get(i).xMap;
            gp.objects.get(i).solidArea.y += gp.objects.get(i).yMap;

            switch (entity.direction) {
                case 0:
                    System.out.println("y:" + entity.solidArea.y + " x:" + entity.solidArea.x + "  " + gp.objects.get(i).solidArea.y);
                    entity.solidArea.y += entity.speed;
                    if (entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
                        //System.out.println("down collision");
                        index = i;
                    }
                    entity.solidArea.y -= entity.speed;
                    break;
                case 1:
                    entity.solidArea.y -= entity.speed;
                    if (entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
                        System.out.println("up collision");
                        index = i;
                    }
                    entity.solidArea.y += entity.speed;
                    break;
                case 2:
                    entity.solidArea.x -= entity.speed;
                    if (entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
                        System.out.println("left collision");
                        index = i;
                    }
                    entity.solidArea.x += entity.speed;
                    break;
                case 3:
                    entity.solidArea.x += entity.speed;
                    if (entity.solidArea.intersects(gp.objects.get(i).solidArea)) {
                        System.out.println("right collision");
                        index = i;
                    }
                    entity.solidArea.x -= entity.speed;
                    break;
            }
            entity.solidArea.x = lastX;
            entity.solidArea.y = lastY;

            gp.objects.get(i).solidArea.x -= gp.objects.get(i).xMap;
            gp.objects.get(i).solidArea.y -= gp.objects.get(i).yMap;
        }
        return index;
    }
}
