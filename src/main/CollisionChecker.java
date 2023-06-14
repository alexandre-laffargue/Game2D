package main;

import entity.Entity;

public class CollisionChecker {

    GPanel gp;

    public CollisionChecker(GPanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.x - (entity.spriteDimX * entity.spritescale)/2 + entity.solidArea.x;
        int entityRightWorldX = entity.x - (entity.spriteDimX * entity.spritescale)/2 + entity.solidArea.x  + entity.solidArea.width;
        int entityTopWorldY = entity.y - (entity.spriteDimY * entity.spritescale)/2 + entity.solidArea.y;
        int entityBottomWorldY = entity.y - (entity.spriteDimY * entity.spritescale)/2 + entity.solidArea.y + entity.solidArea.height;

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
}
