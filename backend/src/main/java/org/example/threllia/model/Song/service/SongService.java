package org.example.threllia.model.Song.service;

import org.example.threllia.dto.SongDTO;
import org.example.threllia.dto.SongsOrderedDTO;
import org.example.threllia.model.Song.entities.Song;

import java.util.List;

public interface SongService {

    SongsOrderedDTO getAllSongsAlphabeticallyOrdered();
    SongDTO getSongById(long id) throws Exception;
    Song addSong(Song song);
    Song getSongByTitle(String title) throws Exception;
    void deleteAllSongs();
    List<Song> findAllSongs();
}
