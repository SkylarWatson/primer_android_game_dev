package org.watson.demo;

import android.content.Context;
import android.view.WindowManager;
import org.anddev.andengine.audio.sound.Sound;
import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.EntityBackground;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.opengl.util.GLHelper;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.watson.demo.domain.Mario;
import org.watson.demo.game.Board;
import org.watson.demo.resources.ResourceLoader;
import org.watson.demo.resources.ResourceRepository;

import javax.microedition.khronos.opengles.GL10;

public class GameActivity extends BaseGameActivity {
    private Board board;
    private Camera camera;
    private ResourceRepository repository;

    public Engine onLoadEngine() {
        WindowManager mWinMgr = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        board = new Board(mWinMgr.getDefaultDisplay().getWidth(), mWinMgr.getDefaultDisplay().getHeight());
        this.camera = new Camera(0, 0, board.getWidth(), board.getHeight());

        return new Engine(new EngineOptions(true, EngineOptions.ScreenOrientation.LANDSCAPE,
                new RatioResolutionPolicy(board.getWidth(), board.getHeight()), this.camera).setNeedsSound(true).setNeedsMusic(true));
    }

    public void onLoadResources() {
        repository = new ResourceRepository();
        final ResourceLoader resourceLoader = new ResourceLoader(this);

        repository.setSprite(resourceLoader.loadTiledResource(512, 512, "gfx/sheet.png", 10, 9));
        repository.setBackgroundTextureRegion(resourceLoader.loadResource(1024, 1024, "gfx/background.jpg"));
        repository.setBackgroundMusic(resourceLoader.loadMusicResource("sounds/background.ogg"));
        repository.setJumpSound(resourceLoader.loadSoundResource("sounds/jump.ogg"));
    }

    public Scene onLoadScene() {
        final Mario mario = new Mario(0, board.yOffset(repository.getSprite()), repository.getSprite());
        mario.move(board.getWidth());


        Scene scene = new Scene();
        scene.setBackground(loadBackground());
        scene.attachChild(mario.asSprite());
        scene.setOnSceneTouchListener(new Scene.IOnSceneTouchListener() {
            @Override
            public boolean onSceneTouchEvent(Scene scene, TouchEvent touchEvent) {
                mario.jump(board);
                Sound jumpSound = repository.getJumpSound();
                jumpSound.play();
                jumpSound.setVolume(repository.getBackgroundMusic().getVolume() + 2);

                return true;
            }
        });

        this.runOnUpdateThread(new Runnable() {
            @Override
            public void run() {
                repository.getBackgroundMusic().play();
            }
        });

        return scene;
    }

    public EntityBackground loadBackground() {
        Sprite backgroundSprite = new Sprite(0, 0, board.getWidth(), board.getHeight(), repository.getBackgroundTextureRegion()) {
            @Override
            protected void onInitDraw(final GL10 pGL) {
                super.onInitDraw(pGL);
                GLHelper.enableTextures(pGL);
                GLHelper.enableTexCoordArray(pGL);
                GLHelper.enableDither(pGL);
            }
        };
        return new EntityBackground(backgroundSprite);
    }

    @Override
    public void onLoadComplete() {

    }
}