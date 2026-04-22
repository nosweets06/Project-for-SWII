import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.musicPlaylist.MusicPlaylist;
import components.musicPlaylist.MusicPlaylist1L;
import components.musicPlaylist.Song;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

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
    public void testTransferFromNonEmpty() {
        Song a = new Song("A", 40);
        Song b = new Song("B", 40);

        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        MusicPlaylist newTest = new MusicPlaylist1L();
        newTest.transferFrom(test);

        Sequence<Song> newRef = new Sequence1L<>();
        newRef.transferFrom(ref);

        while (newTest.numberOfSongs() > 0 && newRef.length() > 0) {
            assertEquals(newTest.removeSong(0), newRef.remove(0));
        }
        assertEquals(newTest.numberOfSongs(), newRef.length());
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     *
     */
    @Test
    public void testTransferFromEmpty() {

        MusicPlaylist test = this.createFromArgsTest();
        Sequence<Song> ref = this.createFromArgsRef();

        MusicPlaylist newTest = new MusicPlaylist1L();
        newTest.transferFrom(test);

        Sequence<Song> newRef = new Sequence1L<>();
        newRef.transferFrom(ref);

        assertEquals(newTest.numberOfSongs(), newRef.length());
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     *
     */
    @Test
    public void testClearNonEmpty() {
        Song a = new Song("A", 40);
        Song b = new Song("B", 40);

        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        test.clear();
        ref.clear();

        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     *
     */
    @Test
    public void testClearEmpty() {

        MusicPlaylist test = this.createFromArgsTest();
        Sequence<Song> ref = this.createFromArgsRef();

        test.clear();
        ref.clear();

        assertEquals(test.numberOfSongs(), ref.length());
    }

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
    public void testRemoveSongMultiple() {
        Song a = new Song("A", 40);
        Song b = new Song("B", 40);
        Song c = new Song("C", 40);
        MusicPlaylist test = this.createFromArgsTest(a, b, c);
        Sequence<Song> ref = this.createFromArgsRef(a, b, c);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeSong(0), ref.remove(0));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
    *
    */
    @Test
    public void testRemoveSongOne() {
        Song a = new Song("A", 40);

        MusicPlaylist test = this.createFromArgsTest(a);
        Sequence<Song> ref = this.createFromArgsRef(a);

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

        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeLastSong(), ref.remove(ref.length() - 1));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
    *
    */
    @Test
    public void testRemoveLastSongToEmpty() {

        Song a = new Song("A", 40);
        MusicPlaylist test = this.createFromArgsTest(a);
        Sequence<Song> ref = this.createFromArgsRef(a);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeLastSong(), ref.remove(ref.length() - 1));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
    *
    */
    @Test
    public void testNumberOfSongsEmpty() {

        MusicPlaylist test = this.createFromArgsTest();
        Sequence<Song> ref = this.createFromArgsRef();

        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
    *
    */
    @Test
    public void testNumberOfSongsNonEmpty() {
        Song a = new Song("A", 40);
        Song b = new Song("B", 40);
        Song c = new Song("C", 40);
        MusicPlaylist test = this.createFromArgsTest(a, b, c);
        Sequence<Song> ref = this.createFromArgsRef(a, b, c);

        assertEquals(test.numberOfSongs(), ref.length());
    }

}
