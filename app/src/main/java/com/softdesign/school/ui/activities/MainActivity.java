package com.softdesign.school.ui.activities;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;


import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingFragment;
import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamFragment;
import com.softdesign.school.utils.Lg;


public class MainActivity extends AppCompatActivity {
    Toolbar mActionBarToolbar;
    NavigationView mNavigationView;
    DrawerLayout mDrawerLayout;
    Fragment mFragment;
    private CollapsingToolbarLayout mCollapsingLayout;
    private AppBarLayout mAppBarLayout;
    public AppBarLayout.LayoutParams params = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Lg.e(this.getLocalClassName(), "onCreate");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.MyAppbar);
        mCollapsingLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        mCollapsingLayout.setExpandedTitleGravity(Gravity.BOTTOM);
        mCollapsingLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.red_navigate));
        mCollapsingLayout.setExpandedTitleColor(getResources().getColor(R.color.red_navigate));

        setupToolbar();
        setupDrawer();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ProfileFragment()).commit();
        }
    }

    /**
     * Скрывает или открывает колапсингтулбар
     */
    public void appBarLock(boolean collapse, String title) {
        mCollapsingLayout.setTitle(title);
        params = (AppBarLayout.LayoutParams) mCollapsingLayout.getLayoutParams();
        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED | AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP);
        mCollapsingLayout.setLayoutParams(params);
        if (collapse) {
            mAppBarLayout.setExpanded(false);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    params.setScrollFlags(0);
                    mCollapsingLayout.setLayoutParams(params);
                }
            }, 0);
        } else mAppBarLayout.setExpanded(true);
    }

    /**
     * Инициализирует тулбар
     */
    private void setupToolbar() {
        setSupportActionBar(mActionBarToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Создаем обработчик выбора пунктов меню
     */
    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        break;
                    case R.id.drawer_team:
                        mFragment = new TeamFragment();
                        break;
                    case R.id.drawer_setting:
                        mFragment = new SettingFragment();
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, mFragment).addToBackStack(null).commit();
                }
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    /**
     * Метод вызываемый в фрагментах для выделения пункта меню
     */
    public void setCheck(int id) {
        mNavigationView.setCheckedItem(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
