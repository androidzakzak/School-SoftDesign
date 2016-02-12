package com.softdesign.school.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.ModelUser;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.adapters.RecycleUsersAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ContactsFragment extends Fragment {
    @Bind(R.id.contacts_recyclerview)
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ModelUser> mUsers = new ArrayList<ModelUser>();
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (v == null) {
            v = inflater.inflate(R.layout.fragment_contacts, container, false);
            ButterKnife.bind(this, v);
        }
        getActivity().setTitle(getResources().getString(R.string.drawer_contacts));
        ((MainActivity) getActivity()).appBarLock(true, getResources().getString(R.string.drawer_contacts));
        Activity activity = getActivity();
        generateData();
        v.setMinimumWidth(container.getMeasuredWidth());
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecycleUsersAdapter(mUsers);
        mRecyclerView.setAdapter(mAdapter);
        ((MainActivity) activity).setCheck(R.id.drawer_contacts);

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
        params.setAnchorId(R.id.main_content);
        params.anchorGravity = Gravity.BOTTOM | Gravity.END;
        mFloationgActionButton.setLayoutParams(params);
        mFloationgActionButton.setImageResource(R.drawable.ic_mail_24dp);
    }

    /**
     * Генерирует данные
     */
    private void generateData() {
        mUsers.add(new ModelUser(getResources().getDrawable(R.drawable.chandler), "Chandler", "Bing"));
        mUsers.add(new ModelUser(getResources().getDrawable(R.drawable.joey), "Joey", "Tribbiani"));
        mUsers.add(new ModelUser(getResources().getDrawable(R.drawable.ross), "Ross", "Geller"));
        mUsers.add(new ModelUser(getResources().getDrawable(R.drawable.monica), "Monica", "Geller"));
        mUsers.add(new ModelUser(getResources().getDrawable(R.drawable.rachel), "Rachel", "Green"));
        mUsers.add(new ModelUser(getResources().getDrawable(R.drawable.phoebe), "Phoebe", "Buffay"));
    }
}