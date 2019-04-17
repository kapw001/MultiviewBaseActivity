package demo.com.addonelayoutforallscreen;

import android.os.Handler;

public class MainActivity extends MultiStateViewActivity {


    @Override
    public int getLayoutByID() {
        return R.layout.activity_main;
    }


    @Override
    protected void initViews() {

        showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                showError("Internet connection error");

            }
        }, 5000);


    }

    @Override
    protected void onRetry() {

        showLoading();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                showContent();
            }
        }, 3000);

    }
}
