package components.musicPlaylist;
//pretending to use map with osu components.

import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * {@code MusicPlaylist} represented as a {@code Map}.
 */

public class MusicPlaylist1L extends MusicPlaylistSecondary
        implements MusicPlaylist {

    /*
     * Private memebers --------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Map<String, Song> rep;

    /**
     * Creator of intial representation.
     */
    private void createNewRep() {
        this.rep = new Map1L<>();
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
        this.rep.add(s.getName(), s);
    }

    @Override
    public final Song removeSong(int s) {
        Map.Pair<String, Song> p = this.rep.remove(s);

        return p.value();
    }

    @Override
    public final Song removeSong() {
        Map.Pair<String, Song> p = this.rep.removeAny();
        return p.value();
    }

    @Override
    public final Song getSong(String s) {
        Song p = this.rep.value(s);
        return p;
    }

    @Override
    public final void playSong(String s) {
        Song p = this.rep.value(s);
        System.out.println("Name :" + p.getName());
        System.out.println("Duration :" + p.getDuration());
    }

    /**
     * Methods.
     */

    @Override
    public final String findSong(int x) {
        //temp
        Sequence<Song> temp = new Sequence1L<>();

        for (Map.Pair<String, Song> p : this.rep) {
            temp.add(temp.length(), p.value());

        }
        Song s = temp.entry(x);
        return s.getName();
    }

    @Override
    public final void shuffle() {
        assert this.rep.size() > 1 : "Must be length of greater than 1.";

        Sequence<Map.Pair<String, Song>> temp = new Sequence1L<>();

        for (Map.Pair<String, Song> p : this.rep) {
            temp.add(temp.length(), p);
        }

        //randomizer here here unsure of how to implement

    }

    @Override
    public final void playAll() {
        System.out.println("Songs: ");
        for (Map.Pair<String, Song> p : this.rep) {
            Song s = p.value();

            System.out.println("Name : " + s.getName());
        }
    }

    @Override
    public final int duration(int x) {
        //temp
        Sequence<Song> temp = new Sequence1L<>();

        for (Map.Pair<String, Song> p : this.rep) {
            temp.add(temp.length(), p.value());
        }
        Song s = temp.entry(x);

        return s.getDuration();
    }

    @Override
    public final int totalDuration() {
        //temp
        Sequence<Song> temp = new Sequence1L<>();

        for (Map.Pair<String, Song> p : this.rep) {
            temp.add(temp.length(), p.value());
        }
        int result = 0;
        for (Song s : temp) {
            result += s.getDuration();
        }

        return result;
    }

}
