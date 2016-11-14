package com.lin.mymusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//实现图片右滑的界面
public class FirstActivity extends Activity {

    //private int[] imageId={R.mipmap.img_1,R.mipmap.img_2,R.mipmap.img_4};
    //private int[] imageId={R.drawable.x123,R.drawable.x124,R.drawable.x125};
   // private List<ImageView> mImages=new ArrayList<ImageView>();
    private ViewPager mViewPager;
    private List<View> views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        views=new ArrayList<View>();
        mViewPager= (ViewPager) findViewById(R.id.Viewpager);

        //给View添加资源
        LayoutInflater inflater=LayoutInflater.from(this);
        View v1=inflater.inflate(R.layout.item_one,null);
        View v2=inflater.inflate(R.layout.item_two,null);
        View v3=inflater.inflate(R.layout.item_three,null);
        views.add(v1);
        views.add(v2);
        views.add(v3);

        //该动画效果andtoid3.0以上有效
        mViewPager.setPageTransformer(true,new DepthPageTransformer());  //设置切换效果1
       // mViewPager.setPageTransformer(true,new ZoomOutPageTransformer());  //设置切换效果2
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                /*
                ImageView imageVie=new ImageView(FirstActivity.this);
                imageVie.setImageResource(imageId[position]);  //用图片时
                imageVie.setScaleType(ImageView.ScaleType.CENTER); //设置这是为了不让图片变形
                container.addView(imageVie); //加载View
                mImages.add(imageVie);
                return imageVie;
                */

                //加载视图
                container.addView(views.get(position));
                return views.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
               // container.removeView(mImages.get(position));
                container.removeView(views.get(position));
            }

            @Override
            public int getCount() {
                //return imageId.length;
                return views.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }
        });
    }

    public void starMyMusic(View view){
        Intent intent=new Intent(this,Animation_img.class);
        startActivity(intent);
    }
}
