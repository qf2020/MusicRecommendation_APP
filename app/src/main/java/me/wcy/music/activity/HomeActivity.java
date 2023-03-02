package me.wcy.music.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import me.wcy.music.R;
import me.wcy.music.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_home);

        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //该项对标题栏设置了，而style中设置了noactionbar。后续可以改进
        //报错原因：java.lang.NullPointerException: Attempt to invoke virtual method 'void androidx.appcompat.app.ActionBar.setTitle(java.lang.CharSequence)
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}