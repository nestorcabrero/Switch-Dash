package es.ucm.vdm.logic;

import java.util.List;

import es.ucm.vdm.engine.Game;
import es.ucm.vdm.engine.Graphics;
import es.ucm.vdm.engine.Input;
import es.ucm.vdm.engine.ScaledGraphics;
import es.ucm.vdm.engine.State;
import es.ucm.vdm.engine.utilities.PixmapManager;
import es.ucm.vdm.engine.utilities.Sprite;

public class HowToPlayState extends State {

    public final int GAME_WIDTH = 1080;
    public final int GAME_HEIGHT = 1920;

    private Background background_;
    private Arrows arrows_;
    private GameObject howToPlay_;
    private GameObject instructions_;
    private GameObject tapToPlay_;


    public HowToPlayState(Game game) {
        super(game);

        ScaledGraphics g = game_.getGraphics();
        g.setCanvasLogicSize(GAME_WIDTH, GAME_HEIGHT);

        background_ = new Background(game_);
        background_.updateColor();

        arrows_ = new Arrows(game_);

        // HowToPlay
        Sprite howToPlaySprite = new Sprite(PixmapManager.getInstance().getPixmap(Assets.images[Assets.ImageName.HOW_TO_PLAY.ordinal()]), 1, 1);
        int howToPlayX = (GAME_WIDTH - howToPlaySprite.getImage().getWidth()) / 2;
        howToPlay_ = new GameObject(game_, howToPlaySprite, howToPlayX, 290, howToPlaySprite.getImage().getWidth(), howToPlaySprite.getImage().getHeight());

        // Instructions
        Sprite instructionsSprite = new Sprite(PixmapManager.getInstance().getPixmap(Assets.images[Assets.ImageName.INSTRUCTIONS.ordinal()]), 1, 1);
        int instructionsX = (GAME_WIDTH - instructionsSprite.getImage().getWidth()) / 2;
        instructions_ = new GameObject(game_, instructionsSprite, instructionsX, 768, instructionsSprite.getImage().getWidth(), instructionsSprite.getImage().getHeight());

        // TapToPlay
        Sprite tapSprite = new Sprite(PixmapManager.getInstance().getPixmap(Assets.images[Assets.ImageName.TAP_TO_PLAY.ordinal()]), 1, 1);
        int tapX = (GAME_WIDTH - tapSprite.getImage().getWidth()) / 2;
        tapToPlay_ = new GameObject(game_, tapSprite, tapX, 1464, tapSprite.getImage().getWidth(), tapSprite.getImage().getHeight());
    }

    @Override
    public void update(double deltaTime) {
        handleInput();

        background_.update(deltaTime);
        arrows_.update(deltaTime);
    }

    private void handleInput() {

        List<Input.KeyEvent> keyEvents = game_.getInput().getKeyEvents();
        List<Input.TouchEvent> touchEvents = game_.getInput().getTouchEvents();

        for (int i = 0; i < keyEvents.size(); i++) {
            Input.KeyEvent event = keyEvents.get(i);
            if (event.type_ == Input.EventType.PRESSED) {
                game_.setState(new GameState(game_));
            }
        }

        for (int i = 0; i < touchEvents.size(); i++) {
            Input.TouchEvent event = touchEvents.get(i);
            if (event.type_ == Input.EventType.PRESSED) {
                game_.setState(new GameState(game_));
            }
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(double deltaTime) {
        Graphics g = game_.getGraphics();
        g.clear(0xff000000);

        background_.render(deltaTime);
        arrows_.render(deltaTime);
        howToPlay_.render(deltaTime);
        instructions_.render(deltaTime);
        tapToPlay_.render(deltaTime);
    }
}
