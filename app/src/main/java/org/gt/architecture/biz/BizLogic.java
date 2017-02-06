package org.gt.architecture.biz;

import org.gt.architecture.intf.Contract;

/**
 * All biz logic
 * handles every atomic events for changing biz model
 */
public class BizLogic implements Contract.IBizLogic, AbsDataSource.IListener<Integer> {
    private Contract.IViewLogic mView;

    @Override
    public void onAddClick() {
        int count = CountDataSource.getInstance().get();
        count += count;
        CountDataSource.getInstance().update(count);
    }

    @Override
    public void setView(Contract.IViewLogic view) {
        mView = view;
    }

    @Override
    public void onChange(Integer data) {
        if (null == mView) {
            return;
        }
        mView.onNewData(data);
    }
}
