package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.ModelUser;

import java.util.ArrayList;


public class RecycleUsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<ModelUser> users;

    public RecycleUsersAdapter(ArrayList<ModelUser> users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View converView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        return new UserViewHolder(converView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        ModelUser user = users.get(position);
        holder.fullName.setText(user.getmFirstName() + " " + user.getmLastName());
        holder.avatar.setImageDrawable(user.getmImage());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
