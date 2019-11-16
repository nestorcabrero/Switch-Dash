package es.ucm.vdm.engine.desktop;

import es.ucm.vdm.engine.Audio;
import es.ucm.vdm.engine.Game;
import es.ucm.vdm.engine.Input;
import es.ucm.vdm.engine.State;

public class DesktopGame implements Game {

    public static final String assetsPath_ = "assets/";

    private DesktopRenderView window_;
    private DesktopGraphics graphics_;
    private DesktopAudio audio_;
    private Input input_;
    private State state_;

    public DesktopGame(String windowName, int width, int height) {
        window_ = new DesktopRenderView(this, windowName, width, height);
        window_.setIgnoreRepaint(true);
        window_.setVisible(true);

        graphics_ = new DesktopGraphics(window_);
        audio_ = new DesktopAudio();
        input_ = new DesktopInput(window_);
        state_ = getStartState();

        window_.run();
    }

    public Input getInput() {
        return input_;
    }

    public Audio getAudio() {
        return audio_;
    }

    public DesktopGraphics getGraphics() {
        return graphics_;
    }

    public void setState(State state) {
        if (state == null) {
            throw new IllegalArgumentException("State must not be null");
        }
        this.state_.pause();
        this.state_.dispose();
        state.resume();
        state.update(0);
        this.state_ = state;
    }

    public State getCurrentState() {
        return state_;
    }

    public State getStartState() {
        return null;
    }
}
