package test.bawei.com.fragmentviewpager;

import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager= (ViewPager)findViewById(R.id.pager);
        layout= (TabLayout) findViewById(R.id.tablayout);
        final String name[]={"请同学们赏析一下清风洒脱用意何在?","请问这道题有多骚中可能"};
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
//                    那么如何实现具体的传值？这里我们可以用bundle传值（由于格式相似所可以来简单的判断）
                One_one_Fragment fragment = new One_one_Fragment();
                Bundle bundle = new Bundle();
                bundle.putString("name","postion"+position);
                fragment.setArguments(bundle);
                return fragment;
            }

            @Override
            public int getCount() {
                return name.length;
            }
//                当滑动时设置标题也就是把Fragmnet和tablayout关联

            @Override
            public CharSequence getPageTitle(int position) {
                return  name[position];
            }

        });
//        给tablayout写监听
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
//        具体的绑定了
//        这里可以设置它的模式
//        有四个属性
//        layout.setTabMode(TabLayout.MODE_FIXED);
        layout.setupWithViewPager(pager);
    }
}
