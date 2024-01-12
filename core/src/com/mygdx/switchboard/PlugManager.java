package com.mygdx.switchboard;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;

public class PlugManager {
    private Array<Plug> plugs;
    private int plugAmount, plugSpacingX, plugSpacingY, startX, startY, endX, endY;
    PlugManager(){
        this.plugs = new Array<Plug>();
        this.plugAmount = 24;
        this.plugSpacingX = 59;
        this.plugSpacingY = 68;
        this.startX = 54;
        this.startY = 18;
        this.endX = 349;
        this.endY = 223;
    }

    public void createPlugs(){
        int newStartX = startX;
        int newStartY = startY;
        for (int i = 0; i < plugAmount; i++){
            plugs.add(new Plug(i, newStartX, newStartY));
            newStartX += plugSpacingX;
            if (newStartX > endX){
                newStartX = startX;
                newStartY += plugSpacingY;
                if (newStartY > endY){
                    break;
                }
            }
        }
    }

    public void updatePlugs(Batch batch){
        for (Plug plug: plugs){
            plug.update(batch);
        }
    }

    public void disposePlugs(){
        for (Plug plug: plugs){
            plug.dispose();
        }
    }
}
