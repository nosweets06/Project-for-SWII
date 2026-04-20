import org.junit.Test;

import components.musicPlaylist.MusicPlaylist;
import components.musicPlaylist.Song;
import components.sequence.Sequence;

public abstract class MusicPlaylist1LTest {

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

    /**
     *
     */
    @Test
    public void testAddSong() {
        Song a = new Song("A", 40);
        Song b = new Song("B", 40);

    }
}
