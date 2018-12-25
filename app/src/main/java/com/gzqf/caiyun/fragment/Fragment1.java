package com.gzqf.caiyun.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gzqf.caiyun.Activity.ZhaoBiaoActivity;
import com.gzqf.caiyun.R;
import com.gzqf.caiyun.model.MainListViewMsg;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Fragment1 extends Fragment implements View.OnClickListener{
    View  view;
    Banner banner;
    ListView listView;
    Button zhaobiaoButton;
    BottomNavigationView bottomNavigationView;

    private List<MainListViewMsg> deliervyMsgList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment1,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
    }


    public void initview(){
        findviewWithId();
        initListener();
        initdata();
    }


    public void findviewWithId() {
        banner=view.findViewById(R.id.lunbotu);
        listView=view.findViewById(R.id.listView);
        bottomNavigationView=view.findViewById(R.id.bottomNavigationView);
        zhaobiaoButton=view.findViewById(R.id.zhaobiaoButton);

    }
    public void initListener() {
        zhaobiaoButton.setOnClickListener(this);
    }


    public void initdata() {
        lunbo();
        listView();
    }


    /**
     * 轮播
     */
    public void lunbo(){
        List<Integer> imags=new ArrayList<>();
        imags.add(R.drawable.apple);
        imags.add(R.drawable.banana);
        imags.add(R.drawable.grape);
        imags.add(R.drawable.mango);
        List<String> titles=new ArrayList<>();
        titles.add("apple");
        titles.add("banana");
        titles.add("grape");
        titles.add("mango");
        /*图片轮播*/
        class BannerImageLoader extends ImageLoader {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }

        }
        banner.setImages(imags)
                .setBannerTitles(titles)
                .setDelayTime(4000)
                .setImageLoader(new BannerImageLoader())
                .start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Log.d("提示：",position+"");
            }
        });
    }


    public void listView(){
        init();
        Fragment1.ListViewAdapter deliervyAdapter=new Fragment1.ListViewAdapter(getContext(),R.layout.activity_main_listview_item,deliervyMsgList);
        ListView listView =view.findViewById(R.id.listView);
        listView.setAdapter(deliervyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


    /**
     * listView用于测试
     */
    private void init(){
        MainListViewMsg msg1=new MainListViewMsg("上海","标题标题标题标题标题标题"
                ,"内容内容内容内容内容内容内容内容内容内容");
        deliervyMsgList.add(msg1);
        deliervyMsgList.add(msg1);
        deliervyMsgList.add(msg1);
        deliervyMsgList.add(msg1);
        deliervyMsgList.add(msg1);
        deliervyMsgList.add(msg1);


    }

    TextView listView_city;
    TextView listView_title;
    TextView listView_content;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zhaobiaoButton:
                Intent intent=new Intent(getContext(),ZhaoBiaoActivity.class);
                startActivity(intent);
                break;
        }

    }

    class ListViewAdapter extends ArrayAdapter<MainListViewMsg> {

        private int resourceId;

        public ListViewAdapter(Context context, int resource, List<MainListViewMsg> objects) {
            super(context, resource, objects);
            resourceId=resource;
        }

        @Override
        public View getView(int position,View convertView,ViewGroup parent) {
            MainListViewMsg deliervyMsg=getItem(position);
            View view;
            if(convertView==null){
                view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            }else{
                view=convertView;
            }
            listView_city=view.findViewById(R.id.listView_city);
            listView_title=view.findViewById(R.id.listView_title);
            listView_content=view.findViewById(R.id.listView_content);
            listView_city.setText(deliervyMsg.getCity());
            listView_title.setText(deliervyMsg.getTitle());
            listView_content.setText(deliervyMsg.getContent());


            return view;
        }
    }
}
