package com.kewenc.kewencmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kewenc.kewencmvp.R;
import com.kewenc.kewencmvp.presenter.MVPBaseActivity;
import com.kewenc.kewencmvp.presenter.MyPresenter;

import org.w3c.dom.Text;

public class MainActivity extends MVPBaseActivity<MyViewInterface,MyPresenter> implements MyViewInterface{

    private MyPresenter myPresenter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        myPresenter = new MyPresenter(this);

    }

    private void initViews() {
        tv = findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPresenter.fetchArticles();
            }
        });
    }

    @Override
    public void showArticles(String text) {
        tv.setText(text);
    }

    @Override
    public void showLoading() {
        Toast.makeText(this,"加载中。。。",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this,"加载完成！",Toast.LENGTH_SHORT).show();
    }
}
