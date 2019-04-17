package demo.com.addonelayoutforallscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public abstract class MultiStateViewActivity extends AppCompatActivity {


    private MultiStateView multiStateView;


    public abstract int getLayoutByID();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutByID());
        multiStateView = findViewById(R.id.multiStateView);
        initViews();

    }

    protected abstract void initViews();

    public void showLoading() {

        multiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
    }

    public void showContent() {

        multiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
    }

    public void showError() {

        multiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }

    public void showError(String errorMsg) {

        multiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);

        View view = multiStateView.getView(MultiStateView.VIEW_STATE_ERROR);

        TextView eMsgView = view.findViewById(R.id.errorMsg);
        Button retry = view.findViewById(R.id.retry);

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRetry();
            }
        });
        eMsgView.setText(errorMsg);

    }

    public void showEmpty() {

        multiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
    }

    public void showEmpty(String emptyMsg) {

        multiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
        View view = multiStateView.getView(MultiStateView.VIEW_STATE_EMPTY);

        TextView empty = view.findViewById(R.id.emptyMsg);
        empty.setText(emptyMsg);
    }

    protected abstract void onRetry();
}
