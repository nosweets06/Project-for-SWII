
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.musicPlaylist.MusicPlaylist;
import components.musicPlaylist.MusicPlaylist1L;
import components.musicPlaylist.Song;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * JUnit test cases for MusicPlaylist.
 */
public abstract class MusicPlaylistTest {

    /**
     * @return protected abstract of constructorTest.
     */
    protected abstract MusicPlaylist constructorTest();

    /**
     * @return protected abstract of constructorRef.
     */
    protected abstract Sequence<Song> constructorRef();

    /**
    *
    */
    private final int fourty = 40;

    /**
     * @param args
     *            Songs to be added.
     * @return a new musicPlaylist using constructor.
     *
     */
    private MusicPlaylist createFromArgsTest(Song... args) {
        MusicPlaylist list = this.constructorTest();
        for (Song s : args) {
            list.addSong(s);

        }
        return list;
    }

    /**
     * @param args
     *            Songs to be added.
     * @return a new Sequence using constructor.
     *
     */
    private Sequence<Song> createFromArgsRef(Song... args) {
        Sequence<Song> hold = this.constructorRef();
        for (Song s : args) {
            hold.add(hold.length(), s);

        }
        return hold;
    }

    /** Kernel Testing */

    /**
     * TrasnferFrom non empty test case.
     */
    @Test
    public void testTransferFromNonEmpty() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);

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
     * TrasnferFrom empty test case.
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
     * Clear non empty test case.
     */
    @Test
    public void testClearNonEmpty() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);

        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        test.clear();
        ref.clear();

        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     * Clear empty test case.
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
     * NewInstance non empty test case.
     */
    @Test
    public void testnewInstanceNonEmpty() {

        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);

        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        test.newInstance();

        ref.newInstance();

        assertEquals(test.numberOfSongs(), ref.length());

    }

    /**
     * NewInstance empty test case.
     */
    @Test
    public void testnewInstanceEmpty() {

        MusicPlaylist test = this.createFromArgsTest();
        Sequence<Song> ref = this.createFromArgsRef();

        test.newInstance();

        ref.newInstance();

        assertEquals(test.numberOfSongs(), ref.length());

    }

    /** 1L methods to test. */

    /**
     * AddSong non empty test case.
     */
    @Test
    public void testAddSongNonEmpty() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);
        Song c = new Song("C", this.fourty);
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
     * AddSong empty test case.
     */
    @Test
    public void testAddSongEmpty() {
        Song a = new Song("A", this.fourty);

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
     * RemoveLastSong non empty test case.
     */
    @Test
    public void testRemoveLastSongNonEmpty() {

        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);

        MusicPlaylist test = this.createFromArgsTest(a, b);
        Sequence<Song> ref = this.createFromArgsRef(a, b);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeLastSong(), ref.remove(ref.length() - 1));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     * RemoveLastSong to empty test case.
     */
    @Test
    public void testRemoveLastSongToEmpty() {

        Song a = new Song("A", this.fourty);
        MusicPlaylist test = this.createFromArgsTest(a);
        Sequence<Song> ref = this.createFromArgsRef(a);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeLastSong(), ref.remove(ref.length() - 1));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     * RemoveSong non empty test case.
     */
    @Test
    public void testRemoveSongMultiple() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);
        Song c = new Song("C", this.fourty);
        MusicPlaylist test = this.createFromArgsTest(a, b, c);
        Sequence<Song> ref = this.createFromArgsRef(a, b, c);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeSong(0), ref.remove(0));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     * RemoveSong non empty (one) test case.
     */
    @Test
    public void testRemoveSongOne() {
        Song a = new Song("A", this.fourty);

        MusicPlaylist test = this.createFromArgsTest(a);
        Sequence<Song> ref = this.createFromArgsRef(a);

        while (test.numberOfSongs() > 0 && ref.length() > 0) {
            assertEquals(test.removeSong(0), ref.remove(0));
        }
        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     * NumberOfSongs non empty test case.
     */

    @Test
    public void testNumberOfSongsNonEmpty() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);
        Song c = new Song("C", this.fourty);
        MusicPlaylist test = this.createFromArgsTest(a, b, c);
        Sequence<Song> ref = this.createFromArgsRef(a, b, c);

        assertEquals(test.numberOfSongs(), ref.length());
    }

    /**
     * NumberOfSongs empty test case.
     */
    @Test
    public void testNumberOfSongsEmpty() {

        MusicPlaylist test = this.createFromArgsTest();
        Sequence<Song> ref = this.createFromArgsRef();

        assertEquals(test.numberOfSongs(), ref.length());
    }

    //making secondary tests cases was difficult.
    /**
     * FindSongPosition non empty test case.
     */
    @Test
    public void testFindSongPositionNonEmpty() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);
        Song c = new Song("C", this.fourty);
        MusicPlaylist test = this.createFromArgsTest(a, b, c);
        Sequence<Song> ref = this.createFromArgsRef(a, b, c);

        assertEquals(test.numberOfSongs(), ref.length());
        int i = 0;

        while (ref.length() > 0) {

            Song refHold = ref.remove(0);

            if (test.findSongPosition("B") == (refHold.duration())) {
                assertEquals(test.findSongPosition("B"), i);
            }
            i++;

        }

    }

    /**
     * FindSongPosition non empty (one) test case.
     */
    @Test
    public void testFindSongPositionOne() {
        Song a = new Song("A", this.fourty);

        MusicPlaylist test = this.createFromArgsTest(a);
        Sequence<Song> ref = this.createFromArgsRef(a);

        test.findSongPosition("A");

        Song refHold = ref.remove(0);

        assertEquals(test.numberOfSongs(), ref.length());

        while (ref.length() > 0
                && test.findSongPosition("A") != (refHold.duration())) {
            refHold = ref.remove(0);
        }
        assertEquals(test.findSongPosition("A"), refHold.duration());
    }

    /**
     * Shuffle non empty test case. Not sure how ot test correctly.
     */
    @Test
    public void testShuffle() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);
        Song c = new Song("C", this.fourty);
        MusicPlaylist test = this.createFromArgsTest(a, b, c);
        MusicPlaylist test2 = test;

        test.shuffle();

        assertEquals(test, test2); //??

    }

    /**
     * Shuffle non empty test case. Not sure how ot test correctly.
     */
    @Test
    public void testGetSongnonEmpty() {
        Song a = new Song("A", this.fourty);
        Song b = new Song("B", this.fourty);
        Song c = new Song("C", this.fourty);
        MusicPlaylist test = this.createFromArgsTest(a, b, c);
        Sequence<Song> ref = this.createFromArgsRef(a, b, c);

        Song holdTest = test.getSong(1);
        Song refHold = ref.remove(0);
        assertEquals(test.numberOfSongs(), ref.length());

        while (ref.length() > 0 && holdTest.equals(refHold)) {
            refHold = ref.remove(0);

        }
        assertEquals(holdTest, refHold);
    }
}
