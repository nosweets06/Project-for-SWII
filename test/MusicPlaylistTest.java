import components.musicPlaylist.MusicPlaylist;
import components.musicPlaylist.MusicPlaylist1L;
import components.musicPlaylist.Song;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Customized JUnit test fixture for {@code MusicPlaylist}.
 */
public final class MusicPlaylistTest extends MusicPlaylist1LTest {

    @Override
    protected MusicPlaylist constructorTest() {
        return new MusicPlaylist1L();
    }

    @Override
    protected Sequence<Song> constructorRef() {
        return new Sequence1L<Song>() {

        };
    }
}
