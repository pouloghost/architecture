package org.gt.architecture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import org.gt.architecture.biz.BizLogic;
import org.gt.architecture.biz.CountDataSource;
import org.gt.architecture.view.CountView;
import org.gt.architecture.view.ViewLogic;

/**
 * all an activity do is binding everything
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BizLogic biz = new BizLogic();
        //view and biz
        final ViewLogic logic = new ViewLogic(
                new CountView((TextView) findViewById(R.id.text_real)),
                new CountView((TextView) findViewById(R.id.text_mod)),
                biz
        );
        //biz and data
        CountDataSource.getInstance().register(biz);
        //view and view event
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic.onAddClick();
            }
        });
        ((Switch) findViewById(R.id.switcher)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                logic.onSwitchChange(isChecked);
            }
        });
    }
}
