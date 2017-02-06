package org.gt.architecture.biz;

/**
 * Mock a store
 */
public class CountDataSource extends AbsDataSource<Integer> {

    private static CountDataSource sInstance = new CountDataSource();

    public static CountDataSource getInstance() {
        return sInstance;
    }

    private CountDataSource() {

    }

    private int mCount = 0;

    @Override
    public void update(Integer data) {
        mCount = data;
        notify(data);
    }

    @Override
    public Integer get() {
        return mCount;
    }
}
