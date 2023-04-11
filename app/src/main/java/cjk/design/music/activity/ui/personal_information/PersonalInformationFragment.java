package cjk.design.music.activity.ui.personal_information;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cjk.design.music.Data.MusicData;
import cjk.design.music.R;
import cjk.design.music.adapter.MusicListRecycleAdapter;
import cjk.design.music.databinding.FragmentPersonalInformationBinding;

public class PersonalInformationFragment extends Fragment {

    private FragmentPersonalInformationBinding binding;
    private RecyclerView recyclerView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PersonalInformationViewModel notificationsViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(PersonalInformationViewModel.class);

        binding = FragmentPersonalInformationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //其中喜欢的歌单里面的recycleview就是调用了list中的组件。
        initView();

        return root;
    }

    private void initView(){
        recyclerView = binding.getRoot().findViewById(R.id.personal_information_playlist);
        LinearLayoutManager  manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        MusicListRecycleAdapter adapter = new MusicListRecycleAdapter(getContext(),null,1);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}