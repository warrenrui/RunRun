package thread.threadPool3;

public abstract class Task {
    public enum State {
        NEW, RUNNING, FINISHED
    }

    // 任务状态
    private State state = State.NEW;

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public abstract void deal();
}
