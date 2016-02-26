package com.softdesign.school.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;


public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);
        getActivity().setTitle(getResources().getString(R.string.drawer_profile));
        ((MainActivity) getActivity()).appBarLock(false, getResources().getString(R.string.drawer_profile));
        Activity activity = getActivity();
        ((MainActivity) activity).setCheck(R.id.drawer_profile);

        return v;
    }

    /**
     * Инициализирует FloatingActionButton и указывает ее место расположения на экране
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton mFloationgActionButton = (FloatingActionButton) getActivity().findViewById(R.id.float_action_button);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mFloationgActionButton.getLayoutParams();
        params.setAnchorId(R.id.collapse_toolbar);
        params.anchorGravity = Gravity.BOTTOM | Gravity.END;
        mFloationgActionButton.setLayoutParams(params);
        mFloationgActionButton.setImageResource(R.drawable.ic_mode_edit_24dp);
    }
}
