package org.gt.architecture.intf;

/**
 * Humble view only handles data changes
 */
public interface IView<T> {
    void onNewData(T data);
}
