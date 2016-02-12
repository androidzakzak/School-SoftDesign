package com.softdesign.school.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

public class TasksFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tasks, null);
        getActivity().setTitle(getResources().getString(R.string.drawer_tasks));
        Activity activity = getActivity();
        ((MainActivity) activity).setCheck(R.id.drawer_tasks);
        ((MainActivity) getActivity()).appBarLock(true, getResources().getString(R.string.drawer_tasks));

        return v;
    }
}