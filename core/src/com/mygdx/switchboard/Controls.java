package com.mygdx.switchboard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

public class Controls {
    public static void keyboardControls(){
        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
            System.exit(0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.R) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))){
            Gdx.app.exit();
        }
    }

    public static void mouseControls(Vector3 mousePos, PlugManager plugController){
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            plugController.checkClick(mousePos);
        }
    }
}
