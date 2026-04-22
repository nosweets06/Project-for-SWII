import components.musicPlaylist.MusicPlaylist;
import components.musicPlaylist.MusicPlaylist1L;
import components.musicPlaylist.Song;

/**
 * Testing some methods.
 */
public class MusicPlaylistMethodTest {
    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist1L();

        Song s = new Song("ScheiBe", 225);

        playlist.addSong(s);
        System.out.println(playlist.getSong(0));

        Song s2 = new Song("Rosemary", 413);
        playlist.addSong(s2);

        //  playlist.playAll();

    }
}
