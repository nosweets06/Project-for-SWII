import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.musicPlaylist.MusicPlaylist;
import components.musicPlaylist.Song;
import components.sequence.Sequence;

public abstract class MusicPlaylistTest {

    protected abstract MusicPlaylist constructorTest();

    protected abstract Sequence<Song> constructorRef();

    private MusicPlaylist createFromArgsTest(Song... args) {
        MusicPlaylist list = this.constructorTest();
        for (Song s : args) {
            list.addSong(s);

        }
        return list;
    }

    private Sequence<Song> createFromArgsRef(Song... args) {
        Sequence<Song> hold = this.constructorRef();
        for (Song s : args) {
            hold.add(hold.length(), s);

        }
        return hold;
    }

    /** Kernel Testing */

    /**
     *
     */
    @Test
    public void testAddSongNonEmpty() {
        Song a = new Song("A", 40);
        Song b = new Song("B", 40);
        Song c = new Song("C", 40);
        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        test.addSong(c);
        ref.add(2, c);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeSong(0), ref.remove(0));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
    *
    */
    @Test
    public void testAddSongEmpty() {
        Song a = new Song("A", 40);

        MusicPlaylist test = this.createFromArgsTest();
        Sequence<Song> ref = this.createFromArgsRef();

        test.addSong(a);
        ref.add(0, a);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeSong(0), ref.remove(0));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
    *
    */
    @Test
    public void testRemoveLastSongNonEmpty() {

        Song a = new Song("A", 40);
        Song b = new Song("B", 40);
        Song c = new Song("C", 40);
        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        test.addSong(c);
        ref.add(2, c);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeLastSong(), ref.remove(ref.length() - 1));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

}
