package com.example.zhiyuan.checkbox_checkall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.zhiyuan.checkbox_checkall.bean.Product;

import java.util.ArrayList;

/**
 * Created by zhiyuan on 17/3/22.
 */

public class ProductAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Product> productList;

    public ProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        //代码优化
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = View.inflate(context, R.layout.lv_item, null);
            //找控件
            viewHolder.tv_count = (TextView) convertView.findViewById(R.id.tv_count);
            viewHolder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
            //设置标记
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.tv_title.setText(productList.get(i).getTitle());
        viewHolder.tv_count.setText(productList.get(i).getCount() + "");//ResouceNotfoundException
        viewHolder.tv_price.setText(productList.get(i).getPrice() + "");

//        viewHolder.checkBox.setOnCheckedChangeListener();
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断一下当前是否选中
                boolean checked = viewHolder.checkBox.isChecked();
                productList.get(i).setChecked(checked);
                //重新设置价格
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.setPrice();
            }
        });
        //设置是否选中
        viewHolder.checkBox.setChecked(productList.get(i).isChecked());
        return convertView;
    }

    class ViewHolder {
        TextView tv_title, tv_price, tv_count;
        CheckBox checkBox;
    }
}
