package cjk.design.music.activity.ui.music_list;

/**
 * 用于Adapter的歌单Bean
 */
public class PlaylistBean {

    private String playlistCoverUrl;

    private String playlistName;

    public String getPlaylistCoverUrl() {
        return playlistCoverUrl;
    }

    public void setPlaylistCoverUrl(String playlistCoverUrl) {
        this.playlistCoverUrl = playlistCoverUrl;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }
}
