package com.example.sh.karamoziproject1.retrofit;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sh.karamoziproject1.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserFragment extends Fragment implements AdapterUsers.Interaction {
    private RecyclerView rvUser;
    private AdapterUsers adapterUsers;
    private Interaction interaction;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interaction = (Interaction) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUser = view.findViewById(R.id.fragment_user_rv_users);
        userRequest();
    }

    private void userRequest() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<User>> call = apiInterface.getUser();
        call.enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                if (response.isSuccessful()) {
                    adapterUsers = new AdapterUsers(UserFragment.this);
                    adapterUsers.setUsers(response.body());
                    rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
                    rvUser.setItemAnimator(new DefaultItemAnimator());
                    rvUser.setAdapter(adapterUsers);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }

    @Override
    public void setUserToUserFragment(User user) {
        interaction.goToPostFragment(user);
    }

    public interface Interaction {

        void goToPostFragment(User user);
    }
}