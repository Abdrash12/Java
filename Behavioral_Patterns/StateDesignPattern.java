// State Interface
interface State {
    void pressPlayButton(MediaPlayer context);
}

// Context Class
class MediaPlayer {
    private State state;

    public MediaPlayer() {
        this.state = new PausedState(); // Initial state
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressButton() {
        state.pressPlayButton(this);
    }
}

// Concrete States
class PlayingState implements State {
    public void pressPlayButton(MediaPlayer context) {
        System.out.println("Pausing video...");
        context.setState(new PausedState());
    }
}

class PausedState implements State {
    public void pressPlayButton(MediaPlayer context) {
        System.out.println("Playing video...");
        context.setState(new PlayingState());
    }
}

public class StateDesignPattern {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();

        player.pressButton(); // Currently Paused -> Plays
        player.pressButton(); // Currently Playing -> Pauses
        player.pressButton(); // Currently Paused -> Plays
    }
}