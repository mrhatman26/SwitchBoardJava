package com.mygdx.switchboard;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Plug {
    private Rectangle plugRect;
    private Texture plugNormal;
    private Texture plugInserted;
    private boolean draggable;
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
        this.startX = startX;
        this.startY = startY;
    }

    public void update(Batch batch){
        batch.draw(plugNormal, plugRect.x, plugRect.y);
    }

    public void dispose(){
        plugNormal.dispose();
        plugInserted.dispose();
    }
}