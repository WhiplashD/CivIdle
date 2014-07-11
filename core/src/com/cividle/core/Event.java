package com.cividle.core;

/**
 *
 * @author Whiplash
 */
public abstract class Event {

    private final long closetime;
    private boolean eventactive;

    public Event(long l) {
        closetime = l;
    }

    public long getCloseTime() {
        return closetime;
    }

    public boolean IsActive() {
        return eventactive;
    }

    public void StartEvent() {
        eventactive = true;
    }

    public void EndEvent() {
   // 	System.out.println ("Event Ended");
        eventactive = false;
    }

    abstract void Create(Game game);
    
    abstract void Dispose();
}
