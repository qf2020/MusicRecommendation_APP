package cjk.design.music.activity.ui.music_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cjk.design.music.databinding.FragmentMusicListBinding;

public class MusicListFragment extends Fragment {

    private FragmentMusicListBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MusicListViewModel musicListViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MusicListViewModel.class);

        binding = FragmentMusicListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        musicListViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}