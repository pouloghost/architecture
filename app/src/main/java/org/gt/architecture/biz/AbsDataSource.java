package org.gt.architecture.biz;

import java.util.ArrayList;
import java.util.List;

/**
 * KVO
 */
public abstract class AbsDataSource<T> {
    private List<IListener<T>> mListeners = new ArrayList<>();

    public void register(IListener<T> listener) {
        mListeners.add(listener);
    }

    public void unregister(IListener<T> listener) {
        mListeners.remove(listener);
    }

    protected void notify(T data) {
        for (IListener<T> listener : mListeners) {
            listener.onChange(data);
        }
    }

    abstract public void update(T data);

    abstract public T get();

    public interface IListener<T> {
        void onChange(T data);
    }
}
