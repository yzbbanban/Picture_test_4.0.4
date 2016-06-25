package com.wangban.yzbbanban.picture_test_40.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wangban.yzbbanban.picture_test_40.R;
import com.wangban.yzbbanban.picture_test_40.contast.Contast;
import com.wangban.yzbbanban.picture_test_40.fragment.FragmentPortrait;
import com.wangban.yzbbanban.picture_test_40.fragment.FragmentPu;
import com.wangban.yzbbanban.picture_test_40.fragment.FragmentLeg;
import com.wangban.yzbbanban.picture_test_40.fragment.FragmentNew;
import com.wangban.yzbbanban.picture_test_40.fragment.FragmentPaper;
import com.wangban.yzbbanban.picture_test_40.fragment.FragmentSexy;
import com.wangban.yzbbanban.picture_test_40.fragment.FragmentYoung;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Contast {
    private FragmentPagerAdapter adapter;
    private List<Fragment> fragments;
    private TextView tvTitle;
    private int position;
    private FrameLayout flContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, " I'm appreciate your support! ^ . ^ ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();

        initData();

        //setListener();
    }

    private void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        flContainer = (FrameLayout) findViewById(R.id.fl_container);


    }

    private void initData() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new FragmentNew());
        fragments.add(new FragmentSexy());
        fragments.add(new FragmentYoung());
        fragments.add(new FragmentPu());
        fragments.add(new FragmentLeg());
        fragments.add(new FragmentPortrait());
        fragments.add(new FragmentPaper());
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        selectFragment(0);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //system menu
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    //opitonitem
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_beauty_new) {
            Toast.makeText(this, "new", Toast.LENGTH_SHORT).show();
//            MainPicture pic = new MainPicture(NEW);
            position = 0;

            tvTitle.setText("最新美女");
        } else if (id == R.id.nav_beauty_sexy) {
            Toast.makeText(this, "sexy", Toast.LENGTH_SHORT).show();
//            MainPicture pic = new MainPicture(SEXY);
            position = 1;
            tvTitle.setText("性感美女");
        } else if (id == R.id.nav_beauty_young) {

            Toast.makeText(this, "young", Toast.LENGTH_SHORT).show();
//            MainPicture pic = new MainPicture(YOUNG);
            position = 2;

            tvTitle.setText("少女美女");
        } else if (id == R.id.nav_beauty_bu) {

            Toast.makeText(this, "bu", Toast.LENGTH_SHORT).show();
//            MainPicture pic = new MainPicture(PU);
            position = 3;

            tvTitle.setText("美乳香臀");
        } else if (id == R.id.nav_beauty_leg) {

            Toast.makeText(this, "leg", Toast.LENGTH_SHORT).show();
//            MainPicture pic = new MainPicture(LEG);
            position = 4;

            tvTitle.setText("丝袜美腿");
        } else if (id == R.id.nav_beauty_portrait) {

            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
//            MainPicture pic = new MainPicture(PORTRAIT);
            position = 5;
            tvTitle.setText("唯美写真");
        } else if (id == R.id.nav_beauty_paper) {

            Toast.makeText(this, "paper", Toast.LENGTH_SHORT).show();
//            MainPicture pic = new MainPicture(PAPER);
            position = 6;

            tvTitle.setText("美女壁纸");
        }
        selectFragment(position);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Object lastFragment;
    private int lastPosition;

    private void selectFragment(int position) {
        //destort another fragment,falg set null
        if (lastFragment != null) {
            adapter.destroyItem(flContainer, lastPosition, lastFragment);
            lastFragment = null;
        }

        //set local frgment
        Object fragment = adapter.instantiateItem(flContainer, position);
        //
        adapter.setPrimaryItem(flContainer, 0, fragment);
        //
        adapter.finishUpdate(flContainer);
        //
        lastFragment = fragment;
        lastPosition = position;
    }


}
