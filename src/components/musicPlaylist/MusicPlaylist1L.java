package components.musicPlaylist;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code MusicPlaylist} represented as a {@code Seqeuence}.
 */

public class MusicPlaylist1L extends MusicPlaylistSecondary {

    /** */
    /*
     * Private memebers --------------------------------
     */

    /**
     * Representation of {@code this}.
     *
     * @convention this.rep != null
     * @correspondence playlist = this.rep
     */
    private Sequence<Song> rep;

    /**
     * Creator of intial representation.
     */
    private void createNewRep() {
        this.rep = new Sequence1L<>();
    }

    /**
     * No-Agrument Constructors.
     */
    public MusicPlaylist1L() {
        this.createNewRep();
    }

    /**
     * Kernel Methods.
     */

    @Override
    public final void addSong(Song s) {
        this.rep.add(this.rep.length(), s); //fixed
    }

    //unsure if it should still return a song or string
    @Override
    public final Song removeSong(int s) {
        Song p = this.rep.remove(s);

        return p;
    }

    @Override
    public final Song removeLastSong() {
        Song p = this.rep.remove(this.rep.length() - 1);
        return p;
    }

    @Override
    public final int numberOfSongs() {
        return this.rep.length();
    }

    //are all 3 common methods
    // supposed to go here-- transferFrom, clear and newInstance?
    //Or what are the common methods needed in the secondary class?

    @Override
    public final void transferFrom(MusicPlaylist x) {
        assert x != null : "Violation of: source is not null";
        assert x != this : "Violation of: source is not this";

        MusicPlaylist1L xHold = (MusicPlaylist1L) x;
        this.rep = xHold.rep;
        xHold.rep = new Sequence1L<>();
    }

    //no longer in kernel

    // @Override
    // public final void shuffle() {
    //     assert this.rep.length() > 1 : "Must be length of greater than 1.";

    //     Sequence<Map.Pair<String, Song>> temp = new Sequence1L<>();

    //     for (Map.Pair<String, Song> p : this.rep) {
    //         temp.add(temp.length(), p);
    //     }

    //     //randomizer here here unsure of how to implement

    // }

    // @Override
    // public final void playSong(int n) {//change so gives position in seq
    //     Song p = this.rep.entry(n);
    //     System.out.println("Name :" + p.name());
    //     System.out.println("Duration :" + p.duration());
    // }

    /**
     * Methods.
     */

    // @Override
    // public final String findSong(int x) {
    //     //temp
    //     Sequence<Song> temp = new Sequence1L<>();

    //     for (Map.Pair<String, Song> p : this.rep) {
    //         temp.add(temp.length(), p.value());

    //     }
    //     Song s = temp.entry(x);
    //     return s.getName();
    // }

    // @Override
    // public final void playAll() {
    //     System.out.println("Songs: ");
    //     for (Map.Pair<String, Song> p : this.rep) {
    //         Song s = p.value();

    //         System.out.println("Name : " + s.getName());
    //     }
    // }

    // @Override
    // public final int duration(int x) {
    //     //temp
    //     Sequence<Song> temp = new Sequence1L<>();

    //     for (Map.Pair<String, Song> p : this.rep) {
    //         temp.add(temp.length(), p.value());
    //     }
    //     Song s = temp.entry(x);

    //     return s.getDuration();
    // }

    // @Override
    // public final int totalDuration() {
    //     //temp
    //     Sequence<Song> temp = new Sequence1L<>();

    //     for (Map.Pair<String, Song> p : this.rep) {
    //         temp.add(temp.length(), p.value());
    //     }
    //     int result = 0;
    //     for (Song s : temp) {
    //         result += s.getDuration();
    //     }

    //     return result;
    // }

}
