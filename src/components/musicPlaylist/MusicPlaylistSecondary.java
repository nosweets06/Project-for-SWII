package components.musicPlaylist;

/**
 * Abstract class.
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    //do kernel methods go here?
    @Override
    public int findSongPosition(String x) {
        //new instance of this
        MusicPlaylist temp = this.newInstance();

        Song curr = this.removeLastSong(); //last song of this
        temp.addSong(curr); //add to temp

        //if not found then loop and remove form this and add to temp
        while (this.numberOfSongs() > 0 && !curr.name().equals(x)) {
            curr = this.removeLastSong();
            temp.addSong(curr);
        }

        //get number of Songs + 1 becuase song found was also removed
        int position = this.numberOfSongs() + 1;

        //Add removed songs back to this
        for (int i = 0; i < temp.numberOfSongs(); i++) {
            Song putBack = temp.removeSong(i);
            this.addSong(putBack);
        }
        return position;
    }

    @Override
    public void shuffle() {

        //Creating a new temp
        MusicPlaylist temp = this.newInstance();
    }

    @Override
    public Song getSong(int x) {
        //new instance of this
        MusicPlaylist temp = this.newInstance();

        Song curr = this.removeLastSong(); //last song of this
        temp.addSong(curr); //add to temp

        //looping and remove until hit position
        for (int i = 0; i < x; i++) {
            curr = this.removeLastSong(); //curr is what x is
            temp.addSong(curr);
        }

        //Add removed songs back to this
        for (int i = 0; i < temp.numberOfSongs(); i++) {
            Song putBack = temp.removeSong(i);
            this.addSong(putBack);
        }

        return curr;
    }

}
