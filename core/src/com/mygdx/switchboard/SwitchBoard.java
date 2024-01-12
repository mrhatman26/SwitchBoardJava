package com.mygdx.switchboard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class SwitchBoard extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Texture backgroundSprite;
	private PlugManager plugController;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		backgroundSprite = new Texture(Gdx.files.internal("backgrounds/bgr_main.png"));
		plugController = new PlugManager();
		plugController.createPlugs();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(backgroundSprite, 0, 0);
		plugController.updatePlugs(batch);
		batch.end();
		camera.update();
		Controls.keyboardControls();
	}

	@Override
	public void dispose () {
		batch.dispose();
		backgroundSprite.dispose();
		plugController.disposePlugs();
	}
}
