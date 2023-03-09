package com.example.tictactoe;




import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PopUpFragment extends DialogFragment {

    List<Friends> friends;
    public PopUpFragment(List<Friends> friends){
        this.friends = friends;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.friends, null);

        RecyclerView recycler2 = view.findViewById(R.id.friends_recycler);

        RecyclerF adapter2 = new RecyclerF(friends);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        recycler2.setLayoutManager(linearLayoutManager2);

        recycler2.setAdapter(adapter2);
        view.findViewById(R.id.close_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        view.findViewById(R.id.filter_by_online).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

                List<Friends> friendsFilter = new ArrayList<>();

                for(Friends friend: friends){
                    if(friend.isStatus()) friendsFilter.add(friend);
                }
                PopUpFragment fragment = new PopUpFragment(friendsFilter);
                fragment.show(getFragmentManager(), "dialog");
            }
        });

        view.findViewById(R.id.filter_by_offline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();

                List<Friends> friendsFilter = new ArrayList<>();

                for(Friends friend: friends){
                    if(!friend.isStatus()) friendsFilter.add(friend);
                }
                PopUpFragment fragment = new PopUpFragment(friendsFilter);
                fragment.show(getFragmentManager(), "dialog");

            }
        });

        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setView(view);

        return dialog;

    }
}