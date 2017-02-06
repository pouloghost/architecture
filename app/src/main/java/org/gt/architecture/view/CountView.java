package org.gt.architecture.view;

import android.widget.TextView;

import org.gt.architecture.intf.IView;

/**
 * Concrete view
 */
public class CountView implements IView<String> {
    private TextView mView;

    public CountView(TextView view) {
        mView = view;
    }

    @Override
    public void onNewData(String data) {
        if (null == mView) {
            return;
        }
        mView.setText(data);
    }
}
