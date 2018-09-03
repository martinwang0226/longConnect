package androidworkingspacemartin.androidworkingspace.aopLog.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidworkingspacemartin.androidworkingspace.aopLog.manager.ScreenActivityManager;

/**
 * Created by martinwang on 2017/10/17.
 */

public class OnePixelActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenActivityManager.getInstance().add(this);
        Window mWindow = getWindow();
        mWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams attrParams = mWindow.getAttributes();
        attrParams.x = 0;
        attrParams.y = 0;
        attrParams.height = 1;
        attrParams.width = 1;
        mWindow.setAttributes(attrParams);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ScreenActivityManager.getInstance().clear();
    }
}
