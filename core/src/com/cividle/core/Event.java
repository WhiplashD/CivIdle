package com.cividle.core;

/**
 *
 * @author Whiplash
 */
public abstract class Event {

    private final long closetime;
    private boolean eventactive;

    /**
     * Creates a new event.
     * 
     * @param l duration to wait before auto-closing the event.
     */
    public Event(long l) {
        closetime = l;
    }

    /**
     *
     * @return the close time.
     */
    public long getCloseTime() {
        return closetime;
    }

    /**
     *
     * @return whether or not the event is currently active.
     */
    public boolean IsActive() {
        return eventactive;
    }

    /**
     * Sets the event as active.
     */
    public void StartEvent() {
        eventactive = true;
    }

    /**
     * Sets the event as inactive.
     */
    public void EndEvent() {
        eventactive = false;
    }

    abstract void Create(Game game);
    
    abstract void Dispose();
}
