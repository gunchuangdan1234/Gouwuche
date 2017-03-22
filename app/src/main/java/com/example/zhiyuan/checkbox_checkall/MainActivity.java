package com.example.zhiyuan.checkbox_checkall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.zhiyuan.checkbox_checkall.bean.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {


    private ArrayList<Product> productList = new ArrayList<>();;
    private ProductAdapter productAdapter;
    private TextView tv_sum;
    //滑动到底部的时候，添加30条


    private int  currentIndex=0;
    private  int each_count=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        tv_sum = (TextView) findViewById(R.id.tv_sum);
        //初始化数据
        initData();
        //设置数据适配器
        productAdapter = new ProductAdapter(this, productList);
        listView.setAdapter(productAdapter);

        //设置滑动的监听
        listView.setOnScrollListener(this);
    }

    private void initData() {
        for (int i = currentIndex; i < currentIndex+each_count; i++) {
            productList.add(new Product("商品" + i, 10 + i, i));
        }
    }

    /**
     * 全选按钮
     * @param view
     */
    public void checkAll(View view) {
        //只需要对象
        for (int i = 0; i < productList.size(); i++) {
            //全选
            productList.get(i).setChecked(true);
        }
        //刷新
        productAdapter.notifyDataSetChanged();
        setPrice();
    }

    /**
     * 反选
     * @param view
     */
    public void checkNone(View view) {
        //只需要对象
        for (int i = 0; i < productList.size(); i++) {
            //全选
//            productList.get(i).setChecked(false);
            productList.get(i).setChecked(!productList.get(i).isChecked());
        }
        //刷新
        productAdapter.notifyDataSetChanged();
        setPrice();
    }

    /**
     * 修改价格
     */
    public void setPrice() {
        int price = 0;
        //只需要对象
        for (int i = 0; i < productList.size(); i++) {
            //全选
//            productList.get(i).setChecked(false);
            boolean checked = productList.get(i).isChecked();
            if (checked) {
                price = price + productList.get(i).getPrice() * productList.get(i).getCount();
            }
        }
        tv_sum.setText("总价格:"+price);
    }

    /**
     * 滑动状态改变
     * @param absListView
     * @param
     */
    @Override
    public void onScrollStateChanged(AbsListView absListView, int state) {
        //静止状态
        if(state== AbsListView.OnScrollListener.SCROLL_STATE_IDLE){
            //并且当前可以看到的条目的最后一个是集合的最后一个
            int lastVisiblePosition = absListView.getLastVisiblePosition();
            if(lastVisiblePosition==productList.size()-1){
                //加载数据
                currentIndex=currentIndex+each_count;
                //加载数据
                initData();
                //刷新适配器
                productAdapter.notifyDataSetChanged();
            }
        }
    }

    /**
     * 滑动的过程
     * @param absListView
     * @param i
     * @param i1
     * @param i2
     */
    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }
}
