package components.musicPlaylist;

import components.standard.Standard;

/**
 * Primary methods.
 */
public interface MusicPlaylistKernel extends Standard<MusicPlaylist> {

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
    Song removeLastSong();

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
    Song removeSong(int s);

    /**
     * Returns number of songs in {@code this}.
     *
     * @return number of songs.
     * @requires {@code this} > 0
     */
    int numberOfSongs();

}
