package org.watson.demo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.WindowManager;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.ColorBackground;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.opengl.font.Font;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.watson.demo.game.Board;
import org.watson.demo.resources.ResourceLoader;

public class HelloAndroidActivity extends BaseGameActivity {
    private Board board;
    private Camera camera;
    private Font font;

    public Engine onLoadEngine() {
        WindowManager mWinMgr = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        board = new Board(mWinMgr.getDefaultDisplay().getWidth(), mWinMgr.getDefaultDisplay().getHeight());
        this.camera = new Camera(0, 0, board.getWidth(), board.getHeight());
        return new Engine(new EngineOptions(true, EngineOptions.ScreenOrientation.LANDSCAPE,
                new RatioResolutionPolicy(board.getWidth(), board.getHeight()), this.camera));
    }

    public void onLoadResources() {
        ResourceLoader resourceLoader = new ResourceLoader(this);
        font = resourceLoader.loadFontResource(48, Color.WHITE, Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
    }

    public Scene onLoadScene() {
        String greeting = "Hello World!";
        float x = (board.getWidth() / 2) - (font.getStringWidth(greeting) / 2);
        float y = board.getHeight() / 2 - (font.getLineHeight() / 2);

        Scene scene = new Scene();
        scene.attachChild(new Text(x, y, font, greeting));
        scene.setBackground(new ColorBackground(0, 0, 0));
        return scene;
    }

    public void onLoadComplete() {

    }
}

