package com.mygdx.switchboard;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.switchboard.SwitchBoard;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(800, 668);
		config.setTitle("Switch Board");
		config.setResizable(false);
		while (true) {
			new Lwjgl3Application(new SwitchBoard(), config);
		}
	}
}
