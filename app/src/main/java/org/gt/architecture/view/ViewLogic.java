package org.gt.architecture.view;

import org.gt.architecture.intf.Contract;
import org.gt.architecture.intf.Contract.IViewLogic;

/**
 * View Logic
 * convert biz model to view model(state of the views)
 * convert view event to biz logic or view state change
 * this maintains the overall state of an activity
 */
public class ViewLogic implements IViewLogic {
    private CountView mReal;
    private CountView mMod;
    private boolean mUseMod;
    private Contract.IBizLogic mBiz;

    public ViewLogic(CountView real, CountView mod, Contract.IBizLogic bizLogic) {
        mReal = real;
        mMod = mod;
        mBiz = bizLogic;
        mBiz.setView(this);
    }

    @Override
    public void onNewData(Integer data) {
        //convert biz model to view model
        String real = String.valueOf(data);
        String mod = real;
        if (mUseMod) {
            mod = String.valueOf(data % 10);
        }

        //present logic
        if (null != mReal) {
            mReal.onNewData(real);
        }

        if (null != mMod) {
            mMod.onNewData(mod);
        }
    }

    @Override
    public void onAddClick() {
        if (null == mBiz) {
            return;
        }
        mBiz.onAddClick();
    }

    @Override
    public void onSwitchChange(boolean on) {
        mUseMod = on;
    }
}
