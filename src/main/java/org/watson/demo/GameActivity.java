package org.watson.demo;

import android.content.Context;
import android.view.WindowManager;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.watson.demo.domain.Mario;
import org.watson.demo.game.Board;
import org.watson.demo.resources.ResourceLoader;
import org.watson.demo.resources.ResourceRepository;

public class GameActivity extends BaseGameActivity {
    private Board board;
    private Camera camera;
    private ResourceRepository repository;

    public Engine onLoadEngine() {
        WindowManager mWinMgr = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        board = new Board(mWinMgr.getDefaultDisplay().getWidth(), mWinMgr.getDefaultDisplay().getHeight());
        this.camera = new Camera(0, 0, board.getWidth(), board.getHeight());

        return new Engine(new EngineOptions(true, EngineOptions.ScreenOrientation.LANDSCAPE,
               new RatioResolutionPolicy(board.getWidth(), board.getHeight()), this.camera));
    }

    public void onLoadResources() {
        repository = new ResourceRepository();
        repository.setSprite(new ResourceLoader(this).loadResource(512, 512, "gfx/sheet.png", 10, 9));
    }

    public Scene onLoadScene() {
        final Mario mario = new Mario(0, board.yOffset(repository.getSprite()), repository.getSprite());
        mario.move(board.getWidth());

        Scene scene = new Scene();
        scene.attachChild(mario.asSprite());
        scene.setOnSceneTouchListener(new Scene.IOnSceneTouchListener() {
            @Override
            public boolean onSceneTouchEvent(Scene scene, TouchEvent touchEvent) {
                mario.jump(board);
                return true;
            }
        });
        return scene;
    }

    @Override
    public void onLoadComplete() {}
}