package com.example.android102;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

  private Context context;
  private TabLayout mTabLayout;
  private ViewPager mViewPager;
  private ContentsPagerAdapter mContentPagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    context = getApplicationContext();

    mTabLayout = findViewById(R.id.layout_tab);
    mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("홈")));
    mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("게임")));
    mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("영화")));
    mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("도서")));
    mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("뉴스스탠드")));

    mViewPager = (ViewPager) findViewById(R.id.pager_content);
    mContentPagerAdapter = new ContentsPagerAdapter(
        getSupportFragmentManager(), mTabLayout.getTabCount());
    mViewPager.setAdapter(mContentPagerAdapter);

    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    });
  }


  private View createTabView(String tabName) {
    View tabView = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
    TextView txt_name = (TextView) ((View) tabView).findViewById(R.id.txt_name);
    txt_name.setText(tabName);
    return tabView;
  }
}
