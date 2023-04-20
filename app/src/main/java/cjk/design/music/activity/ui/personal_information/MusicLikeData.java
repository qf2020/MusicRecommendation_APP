package cjk.design.music.activity.ui.personal_information;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.model.Music;

public class MusicLikeData {
    public static List<Music> musicList = new ArrayList<>();
    public void addMusic(Music music){
        musicList.add(music);
    }
}
