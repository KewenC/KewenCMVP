package com.kewenc.kewencmvp.presenter;

import android.os.Handler;

import com.kewenc.kewencmvp.model.MyModel;
import com.kewenc.kewencmvp.model.MyModelImpl;
import com.kewenc.kewencmvp.view.MyViewInterface;

public class MyPresenter {
    private String result = "赵丽颖的生日是10月16日";
    private MyViewInterface myViewInterface;
    private MyModel myModel = new MyModelImpl();

    public MyPresenter(MyViewInterface myViewInterface){
        this.myViewInterface = myViewInterface;
    }
    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            myViewInterface.showArticles(result);
            myViewInterface.hideLoading();
            myModel.saveArticles(result);
        }
    };
    public void fetchArticles(){
        myViewInterface.showLoading();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        handler.postDelayed(r,10000);
    }
    public void loadArticlesFromDB(){
        myModel.loadArticlesFromCache();
        myViewInterface.showArticles(result);
    }
}
