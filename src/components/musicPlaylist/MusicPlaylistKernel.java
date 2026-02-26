package components.musicPlaylist;

/**
 * Primary methods.
 */
public interface MusicPlaylistKernel {

    /**
     * Add song {@code s} to {@code this}.
     *
     * @param s
     *            the song to be added
     * @requires s > 0
     * @ensures s in {@code this}
     */
    void addSong(Song s);

    /**
     * Removes last song added to {@code this}.
     *
     * @return name of Song.
     * @requires {@code this} > 0
     * @ensures |#this| = |this| - 1
     */
    Song removeSong();

    /**
     * Removes speecfic Song in {@code this}.
     *
     * @param s
     *            key to find Song to be removed.
     *
     * @return name of Song.
     * @requires {@code this} > 0
     * @ensures |#this| = |this| - 1
     */
    Song removeSong(String s);

    /**
     * Get specific Song in {@code this}.
     *
     * @param s
     *            key to find Song.
     *
     * @return the song.
     * @requires {@code this} > 0
     * @ensures (returns song)
     */
    Song getSong(String s);

    /**
     * Play specific Song in {@code this}.
     *
     * @param s
     *            key to find Song.
     *
     *
     */
    void playSong(String s);

}
