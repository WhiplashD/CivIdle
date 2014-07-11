package com.cividle.core;

/**
 *
 * @author Whiplash
 * @param <E>
 */
public interface EventCatcher<E> {
    
    void CatchEvent(E ev);
}
