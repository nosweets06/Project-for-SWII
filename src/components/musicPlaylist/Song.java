package components.musicPlaylist;

/**
 * Type {@code Song} used for storing and retreiving name and duration.
 */
public class Song {

    /**
     * Private.
     */
    private String name;

    /**
     * Private.
     */
    private int duration;

    /**
     * Constructor for Song.
     *
     * @param name
     * @param duration
     */
    public Song(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    /**
     * Get name of {@code Song}.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get duration of {@code duration}.
     *
     * @return duration
     */
    public int getDuration() {
        return this.duration;
    }

}
