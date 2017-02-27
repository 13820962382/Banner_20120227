package com.fuicuiedu.xc.banner_20120227;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private List<ImageView> imageViews;//存放图片的集合
    //存放文字描述的集合
    private String[] titles = new String[]{
            "黄垚", "吴鑫", "叫我索大人", "德芙", "我曾经很瘦"
    };

    private List<View> dots;//存放小点点的集合
    private TextView title;//图片的标题
    //存放图片id的集合
    private int[] imageIds = new int[]{
            R.drawable.aaa,
            R.drawable.bb,
            R.drawable.cc,
            R.drawable.dd,
            R.drawable.ee
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.vp);

        //显示图片的集合
        imageViews = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            imageViews.add(imageView);
        }

        //显示小点点的集合
        dots = new ArrayList<>();
        dots.add(findViewById(R.id.dot_0));//单行复制 ctrl + d
        dots.add(findViewById(R.id.dot_1));//单行复制 ctrl + d
        dots.add(findViewById(R.id.dot_2));//单行复制 ctrl + d
        dots.add(findViewById(R.id.dot_3));//单行复制 ctrl + d
        dots.add(findViewById(R.id.dot_4));//单行复制 ctrl + d

        title = (TextView) findViewById(R.id.tv);//显示图片标题
        title.setText(titles[0]);

        mAdapter = new ViewPagerAdapter();
        mViewPager.setAdapter(mAdapter);

        //关于小点点，图片标题的改变
        //自动轮播


    }

    private class ViewPagerAdapter extends PagerAdapter {
        //获取当前窗体界面数量
        @Override
        public int getCount() {
            return imageViews.size();
        }

        //用于判断是否有对象生成的界面
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //return一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放入当前的ViewPager中
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        //从Viewgroup中移除当前的view
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }
}
