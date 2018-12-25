package com.gzqf.caiyun.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gzqf.caiyun.R;
import com.gzqf.caiyun.base.BaseActivity;
import com.gzqf.caiyun.fragment.Fragment1;
import com.gzqf.caiyun.fragment.Fragment2;
import com.gzqf.caiyun.fragment.Fragment3;
import com.gzqf.caiyun.fragment.Fragment4;
import com.gzqf.caiyun.model.MainListViewMsg;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    Banner banner;
    ListView listView;
    BottomNavigationView bottomNavigationView;

    private List<MainListViewMsg> deliervyMsgList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }

    @Override
    public void findviewWithId() {

        listView=findViewById(R.id.listView);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {
        /*lunbo();
        listView();*/
        initFragment();
    }


    @Override
    public void onClick(View v) {

    }




    public void listView(){
        init();/*用于测试*/
        MainActivity.DeliervyAdapter deliervyAdapter=new MainActivity.DeliervyAdapter(this,R.layout.activity_main_listview_item,deliervyMsgList);
        ListView listView =findViewById(R.id.listView);
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
    class DeliervyAdapter extends ArrayAdapter<MainListViewMsg> {

        private int resourceId;

        public DeliervyAdapter(Context context, int resource, List<MainListViewMsg> objects) {
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
            listView_city=findViewById(R.id.listView_city);
            listView_title=findViewById(R.id.listView_title);
            listView_content=findViewById(R.id.listView_content);


            return view;
        }
    }

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;
    Fragment[] fragments;
    int lastfragment=0;
    private void initFragment(){
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();
        fragments=new Fragment[]{fragment1,fragment2,fragment3,fragment4};

        lastfragment=0;



        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,fragment1).show(fragment1).commit();
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("提示：","1");
            switch (item.getItemId())
            {
                case R.id.item_1:
                {
                    Log.d("提示：","1");
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;

                    }

                    return true;
                }
                case R.id.item_2:
                {
                    Log.d("提示：","2");
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }
                case R.id.item_3:
                {
                    Log.d("提示：","3");
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;

                    }

                    return true;
                }
                case R.id.item_4:
                {
                    Log.d("提示：","3");
                    if(lastfragment!=3)
                    {
                        switchFragment(lastfragment,3);
                        lastfragment=3;

                    }

                    return true;
                }

            }


            return false;
        }
    };

    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.activity_main,fragments[index]);

        }
        transaction.show(fragments[index]).commitAllowingStateLoss();


    }




}
