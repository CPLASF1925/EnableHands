package app.main.wangliwei.enablehands.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseFragment;
import app.main.wangliwei.enablehands.view.adapter.ViewPagerAdapter;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {
    private View view;
    private boolean isAdded = false;
    private String[] tabTitle = {"福利","Android","IOS","视频","资源","前端"};

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        if(!isAdded) {
            //避免重复绘制ToolBar上的图标
            toolbar.inflateMenu(R.menu.menu_toolbar);
            isAdded = true;
        }
        initToolBar();

        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("home","========save=========");
    }

    private void initToolBar() {
        toolbar.setNavigationIcon(R.mipmap.other);
        List<Fragment> list_fragment = new ArrayList<>();
        for(int i=0;i<6;i++) {
            list_fragment.add(new PictureFragment());
        }

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),
                list_fragment, Arrays.asList(tabTitle));
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("home","destroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("home","destroy view");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("home","detach");
    }
}
