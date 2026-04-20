package components.musicPlaylist;

/**
 * {@code Music} Playlist with secondary methods.
 *
 * P.S skipping recommended method for now.
 */
public interface MusicPlaylist extends MusicPlaylistKernel {

    /**
     * Searches for song in {@code this} using {@code x} finding and returning
     * name.
     *
     * @param x
     *            the given index to search
     *
     * @return name
     * @requires x in {@code this}
     * @ensures x is string, |x| > 0
     */
    int findSongPosition(String x);

    /**
     * Randomizes order of songs in {@code this}.
     *
     * @replaces #this = this
     *
     * @requires |this| > 1
     * @ensures |#this| = |this|
     */
    void shuffle();

    /**
     * Returns infomation about song in {@code this}.
     *
     * @param x
     *            given index to search
     * @return time
     * @requires x in {@code this} and {@code this} > 0
     * @ensures (returns song)
     */
    Song getSong(int x);

}
