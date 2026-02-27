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
    String findSong(int x);

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
     * Plays all songs in {@code this}.
     *
     * @requires |this| > 0
     * @ensures (I want to say all songs are looped through but im not sure how
     *          to write in contract formal way oops)
     */
    void playAll();

    /**
     * Returns time duration of {@code x} in {@code this}.
     *
     * @param x
     *            given index to search
     * @return time
     * @requires x in {@code this}
     * @ensures ?
     */
    int duration(int x);

    /**
     * Returns time duration of {@code this}.
     *
     * @return time
     * @requires x in {@code this}
     * @ensures ?
     */
    int totalDuration();

    /**
     * Returns infomation about song in {@code this}.
     *
     * @param x
     *            given index to search
     * @return time
     * @requires x in {@code this}
     * @ensures ?
     */
    Song getSong(int x);

}
