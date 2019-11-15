package es.ucm.vdm.logic.states;

import java.util.List;

import es.ucm.vdm.engine.Game;
import es.ucm.vdm.engine.Graphics;
import es.ucm.vdm.engine.Input;
import es.ucm.vdm.engine.ScaledGraphics;
import es.ucm.vdm.engine.utilities.PixmapManager;
import es.ucm.vdm.engine.utilities.Sprite;
import es.ucm.vdm.logic.Arrows;
import es.ucm.vdm.logic.Assets;
import es.ucm.vdm.logic.Background;
import es.ucm.vdm.logic.GameObject;
import es.ucm.vdm.logic.GameState;
import es.ucm.vdm.logic.Player;

public class MainGameState extends GameState {

    public final int GAME_WIDTH = 1080;
    public final int GAME_HEIGHT = 1920;

    private Background background_;
    private Arrows arrows_;
    private Player player_;

    public MainGameState(Game game) {
        super(game);
        ScaledGraphics g = game_.getGraphics();
        g.setCanvasLogicSize(GAME_WIDTH, GAME_HEIGHT);

        // Background
        background_ = new Background(game_);
        background_.updateColor();
        gameObjects_.add(background_);

        // Moving Arrows
        arrows_ = new Arrows(game_);
        gameObjects_.add(arrows_);

        Sprite playerSprite = new Sprite(PixmapManager.getInstance().getPixmap(Assets.images[Assets.ImageName.PLAYERS.ordinal()]), 2, 1);
        int playerX = (GAME_WIDTH - playerSprite.getWidth()) / 2;
        player_ = new Player(game_, playerSprite, playerX, 1200, playerSprite.getWidth(), playerSprite.getHeight());
        gameObjects_.add(player_);
    }

    @Override
    public void update(double deltaTime) {
        handleInput();
        super.update(deltaTime);
    }

    private void handleInput() {

        List<Input.KeyEvent> keyEvents = game_.getInput().getKeyEvents();
        List<Input.TouchEvent> touchEvents = game_.getInput().getTouchEvents();

        for (int i = 0; i < keyEvents.size(); i++) {
            Input.KeyEvent event = keyEvents.get(i);
            if (event.type_ == Input.EventType.PRESSED) {
                // Accion
            }
        }

        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if(player_.handleTouchEvent(event)){}
//            else if (event.type_ == Input.EventType.PRESSED) {
//                // Accion
//            }
        }
    }

    @Override
    public void render(double deltaTime) {
        Graphics g = game_.getGraphics();
        g.clear(0xff000000);
        super.render(deltaTime);
    }
}