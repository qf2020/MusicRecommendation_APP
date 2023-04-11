package cjk.design.music.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dirror.lyricviewx.OnPlayClickListener;
import com.dirror.lyricviewx.OnSingleClickListener;

import java.io.File;

import cjk.design.music.R;
import cjk.design.music.constants.Actions;
import cjk.design.music.databinding.ActivityMusicPlayBinding;
import cjk.design.music.enums.PlayModeEnum;
import cjk.design.music.executor.SearchLrc;
import cjk.design.music.model.Music;
import cjk.design.music.service.AudioPlayer;
import cjk.design.music.service.OnPlayerEventListener;
import cjk.design.music.storage.preference.Preferences;
import cjk.design.music.utils.CoverLoader;
import cjk.design.music.utils.FileUtils;
import cjk.design.music.utils.ScreenUtils;
import cjk.design.music.utils.SystemUtils;
import cjk.design.music.utils.ToastUtils;
import cjk.design.music.utils.binding.Bind;
import cjk.design.music.widget.AlbumCoverView;

/**
 * 正在播放界面
 *
 */
public class MusicPlayActivity extends AppCompatActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener, OnPlayerEventListener {

    private SeekBar sbVolume;
    private SeekBar sbProgress;
    private TextView tvCurrentTime;
    private TextView tvTotalTime;
    private ImageView ivMode;
    private ImageView ivPlay;
    private ImageView ivNext;
    private ImageView ivPrev;

    private AudioManager mAudioManager;
    private int mLastProgress;
    private boolean isDraggingProgress;

    private ActivityMusicPlayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sbVolume = binding.getRoot().findViewById(R.id.sb_volume);
        sbProgress = binding.getRoot().findViewById(R.id.sb_progress);
        tvCurrentTime = binding.getRoot().findViewById(R.id.tv_current_time);
        tvTotalTime = binding.getRoot().findViewById(R.id.tv_total_time);
        ivMode = binding.getRoot().findViewById(R.id.iv_mode);
        ivPlay = binding.getRoot().findViewById(R.id.iv_play);
        ivNext = binding.getRoot().findViewById(R.id.iv_next);
        ivPrev = binding.getRoot().findViewById(R.id.iv_prev);


        initSystemBar();
        //这边初始化黑胶唱片
        onChangeImpl(AudioPlayer.get().getPlayMusic());
        initCoverLrc();
        initPlayMode();
        setListener();


        //这边初始化music
        AudioPlayer.get().addOnPlayEventListener(this);
    }

    //唱片成功画制，

    //问题3，原来一直画不了bitmap可能file的读取和url的读取方式不一样，有待研究
    //总结：AlbumCoverView用于画质唱片，CoverLoader用于加载图片并且转换为bitmap
    //     playFragment直接调用AudioPlayer.get方法就完成了初始化，AudioPlayer初始化调用了Music类进行赋值。音乐播放等操作主要在AudioPlayer中进行完成的，


    //完成了url的一对一情况，主要是线程异步进行导致的结果，如今有一个问题就是，从网络上加载封面需要时间，因此线程阻塞会导致出现卡顿的现象。
    //可以考虑通过cache进行完成，不用反复加载。



    @Override
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(Actions.VOLUME_CHANGED_ACTION);
        registerReceiver(mVolumeReceiver, filter);
    }


    protected void setListener() {
        binding.ivBack.setOnClickListener(this);
        ivMode.setOnClickListener(this);
        ivPlay.setOnClickListener(this);
        ivPrev.setOnClickListener(this);
        ivNext.setOnClickListener(this);
        sbProgress.setOnSeekBarChangeListener(this);
        sbVolume.setOnSeekBarChangeListener(this);
    }


    private void initSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int top = ScreenUtils.getStatusBarHeight();
            binding.llContent.setPadding(0, top, 0, 0);
        }
    }

    private void initCoverLrc() {
        binding.albumCoverView.initNeedle(AudioPlayer.get().isPlaying());
        binding.albumCoverView.setOnClickListener(v -> switchCoverLrc(false));

        binding.lyricViewX.setLabel("聆听好音乐");
        //这个函数是设置歌词是否能够拖动
        binding.lyricViewX.setDraggable(true, new OnPlayClickListener() {
            @Override
            public boolean onPlayClick(long l) {

                if (AudioPlayer.get().isPlaying() || AudioPlayer.get().isPausing()) {
                    AudioPlayer.get().seekTo((int) l);
                    if (AudioPlayer.get().isPausing()) {
                        AudioPlayer.get().playPause();
                    }
                    return true;
                }
                return false;
            }
        });
//        binding.llLrc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switchCoverLrc(true);
//            }
//        });
        //赋予歌词之后点击是有反应的，可以看一下代码是从哪里生成的
        binding.lyricViewX.setOnSingerClickListener(new OnSingleClickListener() {
            @Override
            public void onClick() {
                System.out.println("这次应该输出吧");
                switchCoverLrc(true);
            }
        });

        //binding.lrcView.setOnClickListener(v -> switchCoverLrc(true));
        initVolume();
        switchCoverLrc(true);//用来歌词和黑胶唱片的转换
    }

    private void initVolume() {
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        sbVolume.setMax(mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        sbVolume.setProgress(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
    }

    private void initPlayMode() {
        int mode = Preferences.getPlayMode();
        ivMode.setImageLevel(mode);
    }

    private void switchCoverLrc(boolean showCover) {
        binding.albumCoverView.setVisibility(showCover ? View.VISIBLE : View.GONE);
        binding.llLrc.setVisibility(showCover ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onChange(Music music) {
        onChangeImpl(music);
    }

    @Override
    public void onPlayerStart() {
        ivPlay.setSelected(true);
        binding.albumCoverView.start();
    }

    @Override
    public void onPlayerPause() {
        ivPlay.setSelected(false);
        binding.albumCoverView.pause();
    }

    /**
     * 更新播放进度
     */
    @Override
    public void onPublish(int progress) {
        if (!isDraggingProgress) {
            sbProgress.setProgress(progress);
        }

        binding.lyricViewX.updateTime(progress);
//        if (binding.lrcView.hasLrc()) {
////            binding.lrcView.updateTime(progress);
////        }
    }

    @Override
    public void onBufferingUpdate(int percent) {
        sbProgress.setSecondaryProgress(sbProgress.getMax() * 100 / percent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:

                break;
            case R.id.iv_mode:
                switchPlayMode();
                break;
            case R.id.iv_play:
                play();
                break;
            case R.id.iv_next:
                next();
                break;
            case R.id.iv_prev:
                prev();
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == sbProgress) {
            if (Math.abs(progress - mLastProgress) >= DateUtils.SECOND_IN_MILLIS) {
                tvCurrentTime.setText(formatTime(progress));
                mLastProgress = progress;
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (seekBar == sbProgress) {
            isDraggingProgress = true;
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar == sbProgress) {
            isDraggingProgress = false;
            if (AudioPlayer.get().isPlaying() || AudioPlayer.get().isPausing()) {
                int progress = seekBar.getProgress();
                AudioPlayer.get().seekTo(progress);

//                if (binding.lrcView.hasLrc()) {
//                    binding.lrcView.updateTime(progress);
//                }
                binding.lyricViewX.updateTime(progress);
            } else {
                seekBar.setProgress(0);
            }
        } else if (seekBar == sbVolume) {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, seekBar.getProgress(),
                    AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        }
    }


    //赋值了音乐名字等信息，名字和背景是一块生成的啊
    private void onChangeImpl(Music music) {
        if (music == null) {
            return;
        }

        binding.tvTitle.setText(music.getTitle());
        binding.tvArtist.setText(music.getArtist());
        sbProgress.setProgress((int) AudioPlayer.get().getAudioPosition());
        sbProgress.setSecondaryProgress(0);
        sbProgress.setMax((int) music.getDuration());
        mLastProgress = 0;
        tvCurrentTime.setText(R.string.play_time_start);
        tvTotalTime.setText(formatTime(music.getDuration()));


        setCoverAndBg(music);

        setLrc(music);//通过这个设置歌词

        if (AudioPlayer.get().isPlaying() || AudioPlayer.get().isPreparing()) {
            ivPlay.setSelected(true);
            binding.albumCoverView.start();
        } else {
            ivPlay.setSelected(false);
            binding.albumCoverView.pause();
        }
    }

    private void play() {
        AudioPlayer.get().playPause();
    }

    private void next() {
        AudioPlayer.get().next();
    }

    private void prev() {
        AudioPlayer.get().prev();
    }

    private void switchPlayMode() {
        PlayModeEnum mode = PlayModeEnum.valueOf(Preferences.getPlayMode());
        switch (mode) {
            case LOOP:
                mode = PlayModeEnum.SHUFFLE;
                ToastUtils.show(R.string.mode_shuffle);
                break;
            case SHUFFLE:
                mode = PlayModeEnum.SINGLE;
                ToastUtils.show(R.string.mode_one);
                break;
            case SINGLE:
                mode = PlayModeEnum.LOOP;
                ToastUtils.show(R.string.mode_loop);
                break;
        }
        Preferences.savePlayMode(mode.value());
        initPlayMode();
    }

    //不是很清楚为什么返回键加一个延迟，到时候再看看



    //设置音乐背景
    private void setCoverAndBg(Music music) {
        binding.albumCoverView.setCoverBitmap(CoverLoader.get().loadRound(music));
        binding.ivPlayPageBg.setImageBitmap(CoverLoader.get().loadBlur(music));
    }

    //设置歌词
    private void setLrc(final Music music) {
        if (music.getType() == Music.Type.LOCAL) {
            String lrcPath = FileUtils.getLrcFilePath(music);
            if (!TextUtils.isEmpty(lrcPath)) {
                loadLrc(lrcPath);
            } else {
                new SearchLrc(music.getArtist(), music.getTitle()) {
                    @Override
                    public void onPrepare() {
                        // 设置tag防止歌词下载完成后已切换歌曲
                       // binding.lrcView.setTag(music);

                        loadLrc("");
                        setLrcLabel("正在搜索歌词");
                    }

                    @Override
                    public void onExecuteSuccess(@NonNull String lrcPath) {
//                        if (binding.lrcView.getTag() != music) {
//                            return;
//                        }
//
//                        // 清除tag
//                        binding.lrcView.setTag(null);

                        loadLrc(lrcPath);
                        setLrcLabel("暂无歌词");
                    }

                    @Override
                    public void onExecuteFail(Exception e) {
//                        if (binding.lrcView.getTag() != music) {
//                            return;
//                        }
//
//                        // 清除tag
//                        binding.lrcView.setTag(null);

                        setLrcLabel("暂无歌词");
                    }
                }.execute();
            }
        } else {
           // String lrcPath = this.getExternalFilesDir(null).getAbsolutePath() +"/"+ FileUtils.getLrcFileName(music.getArtist(), music.getTitle());
            loadLrc(music.getLrc());
        }
    }

    private void loadLrc(String path) {
        //这里将文件读取,改为了在线字符串读取
        binding.lyricViewX.loadLyric(path,"");
    }

    private void setLrcLabel(String label) {
       // binding.lrcView.setLabel(label);
    }

    private String formatTime(long time) {
        return SystemUtils.formatTime("mm:ss", time);
    }

    private BroadcastReceiver mVolumeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            sbVolume.setProgress(mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        }
    };

    @Override
    public void onDestroy() {
        unregisterReceiver(mVolumeReceiver);
        AudioPlayer.get().removeOnPlayEventListener(this);
        super.onDestroy();
    }
}
