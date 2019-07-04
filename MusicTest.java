package com.lti.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Album;
import com.lti.entity.AlbumDao;
import com.lti.entity.Song;
import com.lti.service.AccountService;

public class MusicTest {

	@Test
	public void testAddAlbum() {
		Album album = new Album();
		album.setName("One Direction");
		album.setYear(2012);
		album.setCopyRight("OneDirection");
		AlbumDao dao = new AlbumDao();
		dao.databaseSave(album);
	}

	@Test
	public void testAddSong() {
		AlbumDao dao = new AlbumDao();
		 Album album = (Album) dao.databaseFetchId(Album.class, 161);
		Song song= new Song();
		song.setTitle("Girls Like You");
		song.setDuration(3.01);
		song.setSinger("Maroon");
		song.setAlbum(album);
		
		dao.databaseSave(song);
	}
	
	@Test
	public void testFetchSong() {
		AlbumDao dao = new AlbumDao();
		List<Song> song = (List<Song>) dao.fetchSong("Maroon");
		for(Song s : song)
		{
			System.out.println(s.getDuration());
			System.out.println(s.getTitle());
			System.out.println(s.getSinger());
			System.out.println("************************************");
		}
	}
	
	@Test
	public void testFetchBoth() {
		AlbumDao dao = new AlbumDao();
		List<Album> album = (List<Album>) dao.fetchSongAndAlbum();
		for(Album a : album)
		{
			System.out.println(a.getYear());
			System.out.println(a.getId());
			System.out.println("************************************");
		}
	}
	
}
