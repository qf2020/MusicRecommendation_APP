package cjk.design.music.activity;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import cjk.design.music.R;
import cjk.design.music.databinding.ActivityHomeBinding;
import cjk.design.music.executor.ControlPanel;
import cjk.design.music.service.AudioPlayer;
import cjk.design.music.service.QuitTimer;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private ControlPanel controlPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        controlPanel = new ControlPanel(binding.getRoot());
        AudioPlayer.get().addOnPlayEventListener(controlPanel);
        //主界面背景色为白色，社子和状态栏字体为黑色
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

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

    @Override
    protected void onDestroy() {
        AudioPlayer.get().removeOnPlayEventListener(controlPanel);
        super.onDestroy();
    }


}