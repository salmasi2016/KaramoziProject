package com.example.sh.karamoziproject1.retrofit;

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

public class PostFragment extends Fragment {
    private RecyclerView rvPost;
    private AdapterPosts adapterPosts;
    private User user;

    public static PostFragment newSlide(User user) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putParcelable(Tool.POST_FRAGMENT_USER_ID, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args == null) return;
        user = args.getParcelable(Tool.POST_FRAGMENT_USER_ID);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPost=view.findViewById(R.id.fragment_post_rv_posts);
        postRequest();
    }

    private void postRequest() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<ArrayList<Post>> call = apiInterface.getPost(user.getId());
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    adapterPosts = new AdapterPosts();
                    adapterPosts.setPosts(response.body());
                    rvPost.setLayoutManager(new LinearLayoutManager(getContext()));
                    rvPost.setItemAnimator(new DefaultItemAnimator());
                    rvPost.setAdapter(adapterPosts);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}