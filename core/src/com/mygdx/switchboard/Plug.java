package com.mygdx.switchboard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Plug {
    private Rectangle plugRect;
    private Texture plugNormal;
    private Texture plugInserted;
    private ShapeRenderer shapeRenderer;
    private boolean draggable;
    private boolean dragging;
    private int startX;
    private int startY;
    public Plug (int plugNumber, int startX, int startY){
        this.plugRect = new Rectangle();
        this.plugRect.x = startX;
        this.plugRect.y = startY;
        this.plugRect.width = 15;
        this.plugRect.height = 68;
        this.plugNormal = new Texture("sprites/plugs/spr_plug.png");
        this.plugInserted = new Texture("sprites/plugs/spr_plug_inserted.png");
        this.draggable = true;
        this.dragging = false;
        this.startX = startX;
        this.startY = startY;
        this.shapeRenderer = new ShapeRenderer();
    }

    public boolean getDragging(){
        return this.dragging;
    }

    public Rectangle getPlugRect(){
        return this.plugRect;
    }

    public void setDragging(boolean newDragging){
        this.dragging = newDragging;
    }

    public void drawLine(){
        if (plugRect.x != startX || plugRect.y != startY) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(0, 0, 0, 1);
            shapeRenderer.rectLine(new Vector2(startX + plugRect.width / 2, startY + 4), new Vector2(plugRect.x + plugRect.width / 2, plugRect.y), 5);
            shapeRenderer.end();
        }
    }

    public void update(Batch batch, Vector3 mousePos){
        batch.draw(plugNormal, plugRect.x, plugRect.y);
        if (dragging){
            plugRect.x = mousePos.x - plugRect.width / 2;
            plugRect.y = mousePos.y - plugRect.height / 2;
        }
    }

    public void dispose(){
        plugNormal.dispose();
        plugInserted.dispose();
        shapeRenderer.dispose();
    }
}