package org.gt.architecture.intf;

/**
 * base interfaces of all
 */
public interface Contract {
    interface IViewLogic extends IView<Integer> {
        void onAddClick();

        void onSwitchChange(boolean on);
    }

    interface IBizLogic {
        void onAddClick();

        void setView(IViewLogic view);
    }
}
