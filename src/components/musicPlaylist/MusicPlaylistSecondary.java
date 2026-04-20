package components.musicPlaylist;

/**
 * Abstract class.
 */
public abstract class MusicPlaylistSecondary implements MusicPlaylist {

    @Override
    public final int findSongPosition(String x) {
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
    public final void shuffle() {

        //Creating a new temp
        MusicPlaylist temp = this.newInstance();
        while (this.numberOfSongs() > 0) {
            temp.addSong(this.removeLastSong());
        }
        while (temp.numberOfSongs() > 0) {
            Song s = temp.removeLastSong();
            this.addSong(s);
        }
    }

    @Override
    public final Song getSong(int x) {
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

    @Override
    public final boolean equals(Object obj) {
        boolean check = true;

        if (obj == null) {
            check = false;
        } else if (this.getClass() != obj.getClass()) {
            check = false;
        } else {
            MusicPlaylist hold = (MusicPlaylist) obj;

            if (this.numberOfSongs() != hold.numberOfSongs()) {
                check = false;
            } else {
                MusicPlaylist tempThis = this.newInstance();
                MusicPlaylist tempHold = hold.newInstance();

                while (check && this.numberOfSongs() > 0) {
                    Song thisSong = this.removeLastSong();
                    Song holdSong = this.removeLastSong();

                    tempThis.addSong(thisSong);
                    tempHold.addSong(holdSong);

                    if (!thisSong.equals(holdSong)) {
                        check = false;
                    }
                }

                while (tempThis.numberOfSongs() > 0) {
                    this.addSong(tempThis.removeLastSong());
                    hold.addSong(tempHold.removeLastSong());
                }
            }

        }
        return check;
    }

    @Override
    public final String toString() {
        StringBuilder hold = new StringBuilder();

        MusicPlaylist temp = new MusicPlaylist1L();

        while (this.numberOfSongs() > 0) {
            temp.addSong(this.removeLastSong());

        }

        while (temp.numberOfSongs() > 0) {
            Song s = temp.removeLastSong();
            hold.append(s.toString());
            hold.append(", ");

            this.addSong(s);

        }

        hold.delete(hold.length() - 2, hold.length());

        return hold.toString();

    }

    @Override
    public final int hashCode() {
        int hash = 1;
        final int total = 31;

        MusicPlaylist temp = new MusicPlaylist1L();

        while (this.numberOfSongs() > 0) {
            Song s = this.removeLastSong();
            temp.addSong(s);

            hash = total * hash + s.hashCode();
        }
        while (temp.numberOfSongs() > 0) {
            this.addSong(temp.removeLastSong());
        }
        return hash;
    }

}
