import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import salomia.streaming.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    @Test
    public void countItsLikes(){
        Genre rock = new Genre("1", "Rock");
        Genre pop = new Genre("2", "Pop");
        Genre jazz = new Genre("3", "Jazz");

        // Create some artists
        SoloArtist artist1 = new SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1970, 5, 15));
        SoloArtist artist2 = new SoloArtist("2", 2000, "Jane Smith", "UK", "Jane", "Smith", LocalDate.of(1980, 3, 20));

        GroupArtist group1 = new GroupArtist("3", 2010, "The Rockers", "USA", Arrays.asList(artist1, artist2));

        // Create some songs
        Song song1 = new Song("1", "Rock Anthem", Duration.ofMinutes(4), artist1, Arrays.asList(rock, jazz));
        Song song2 = new Song("2", "Pop Hit", Duration.ofMinutes(3), artist2, List.of(pop));
        Song song3 = new Song("3", "Jazz Vibes", Duration.ofMinutes(5), artist1, List.of(jazz));

        // Create some users
        User user1 = new User("1", "user1", new ArrayList<>());
        User user2 = new User("2", "user2", new ArrayList<>());

        // Create some playlists
        Playlist playlist1 = new Playlist("1", new ArrayList<>(Arrays.asList(song1, song2)), user1, new ArrayList<>(Arrays.asList(user2, user1)));
        Playlist playlist2 = new Playlist("2", new ArrayList<>(Arrays.asList(song2, song3)), user2, new ArrayList<>());

        // Add playlists to users
        user1.getPlaylists().add(playlist1);
        user2.getPlaylists().add(playlist2);

        Assertions.assertEquals(playlist1.getTotalLikes(),  2);

        user2.like(playlist2);
        Assertions.assertEquals(playlist2.getTotalLikes(),1, "playlist2's likes wasn't 1");

        user1.like(playlist1);
        Assertions.assertEquals(playlist1.getTotalLikes(), 1);
    }

    @Test
    public void addingSongTest(){
        Genre rock = new Genre("1", "Rock");
        Genre pop = new Genre("2", "Pop");
        Genre jazz = new Genre("3", "Jazz");

        // Create some artists
        SoloArtist artist1 = new SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1970, 5, 15));
        SoloArtist artist2 = new SoloArtist("2", 2000, "Jane Smith", "UK", "Jane", "Smith", LocalDate.of(1980, 3, 20));

        GroupArtist group1 = new GroupArtist("3", 2010, "The Rockers", "USA", Arrays.asList(artist1, artist2));

        // Create some songs
        Song song1 = new Song("1", "Rock Anthem", Duration.ofMinutes(4), artist1, Arrays.asList(rock, jazz));
        Song song2 = new Song("2", "Pop Hit", Duration.ofMinutes(3), artist2, List.of(pop));
        Song song3 = new Song("3", "Jazz Vibes", Duration.ofMinutes(5), artist1, List.of(jazz));

        // Create some users
        User user1 = new User("1", "user1", new ArrayList<>());
        User user2 = new User("2", "user2", new ArrayList<>());

        // Create some playlists
        Playlist playlist1 = new Playlist("1", new ArrayList<>(Arrays.asList(song1, song2)), user1, new ArrayList<>(Arrays.asList(user2, user1)));
        Playlist playlist2 = new Playlist("2", new ArrayList<>(Arrays.asList(song2, song3)), user2, new ArrayList<>());

        // Add playlists to users
        user1.getPlaylists().add(playlist1);
        user2.getPlaylists().add(playlist2);


        playlist1.addToPlaylist(song3);
        Assertions.assertEquals(playlist1.getSongs().size(), 3);
    }

    @Test
    public void countPlaylistsTest(){
        Genre rock = new Genre("1", "Rock");
        Genre pop = new Genre("2", "Pop");
        Genre jazz = new Genre("3", "Jazz");

        // Create some artists
        SoloArtist artist1 = new SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1970, 5, 15));
        SoloArtist artist2 = new SoloArtist("2", 2000, "Jane Smith", "UK", "Jane", "Smith", LocalDate.of(1980, 3, 20));

        GroupArtist group1 = new GroupArtist("3", 2010, "The Rockers", "USA", Arrays.asList(artist1, artist2));

        // Create some songs
        Song song1 = new Song("1", "Rock Anthem", Duration.ofMinutes(4), artist1, Arrays.asList(rock, jazz));
        Song song2 = new Song("2", "Pop Hit", Duration.ofMinutes(3), artist2, List.of(pop));
        Song song3 = new Song("3", "Jazz Vibes", Duration.ofMinutes(5), artist1, List.of(jazz));

        // Create some users
        User user1 = new User("1", "user1", new ArrayList<>());
        User user2 = new User("2", "user2", new ArrayList<>());

        // Create some playlists
        Playlist playlist1 = new Playlist("1", new ArrayList<>(Arrays.asList(song1, song2)), user1, new ArrayList<>(Arrays.asList(user2, user1)));
        Playlist playlist2 = new Playlist("2", new ArrayList<>(Arrays.asList(song2, song3)), user2, new ArrayList<>());

        // Add playlists to users
        user1.getPlaylists().add(playlist1);
        user2.getPlaylists().add(playlist2);


        playlist1.addToPlaylist(song3);
        playlist2.addToPlaylist(song3);



        Assertions.assertEquals( song3.countPlaylists(Arrays.asList(playlist1, playlist2)), 2);


    }


    @Test
    public void removingSongsTest(){
        Genre rock = new Genre("1", "Rock");
        Genre pop = new Genre("2", "Pop");
        Genre jazz = new Genre("3", "Jazz");

        // Create some artists
        SoloArtist artist1 = new SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1970, 5, 15));
        SoloArtist artist2 = new SoloArtist("2", 2000, "Jane Smith", "UK", "Jane", "Smith", LocalDate.of(1980, 3, 20));

        GroupArtist group1 = new GroupArtist("3", 2010, "The Rockers", "USA", Arrays.asList(artist1, artist2));

        // Create some songs
        Song song1 = new Song("1", "Rock Anthem", Duration.ofMinutes(4), artist1, Arrays.asList(rock, jazz));
        Song song2 = new Song("2", "Pop Hit", Duration.ofMinutes(3), artist2, List.of(pop));
        Song song3 = new Song("3", "Jazz Vibes", Duration.ofMinutes(5), artist1, List.of(jazz));

        // Create some users
        User user1 = new User("1", "user1", new ArrayList<>());
        User user2 = new User("2", "user2", new ArrayList<>());

        // Create some playlists
        Playlist playlist1 = new Playlist("1", new ArrayList<>(Arrays.asList(song1, song2)), user1, new ArrayList<>(Arrays.asList(user2, user1)));
        Playlist playlist2 = new Playlist("2", new ArrayList<>(Arrays.asList(song2, song3)), user2, new ArrayList<>());

        // Add playlists to users
        user1.getPlaylists().add(playlist1);
        user2.getPlaylists().add(playlist2);

        // removing
        playlist1.removeById("2");
        playlist1.addToPlaylist(song3);
Assertions.assertEquals(playlist1.getSongs().size(), 2);
    }


@Test
    public void excludingGenre(){
    Genre rock = new Genre("1", "Rock");
    Genre pop = new Genre("2", "Pop");
    Genre jazz = new Genre("3", "Jazz");

    // Create some artists
    SoloArtist artist1 = new SoloArtist("1", 1990, "John Doe", "USA", "John", "Doe", LocalDate.of(1970, 5, 15));
    SoloArtist artist2 = new SoloArtist("2", 2000, "Jane Smith", "UK", "Jane", "Smith", LocalDate.of(1980, 3, 20));


    // Create some songs
    Song song1 = new Song("1", "Rock Anthem", Duration.ofMinutes(4), artist1, Arrays.asList(rock, jazz));
    Song song2 = new Song("2", "Pop Hit", Duration.ofMinutes(3), artist2, List.of(pop));

    // Create some users
    User user1 = new User("1", "user1", new ArrayList<>());
    User user2 = new User("2", "user2", new ArrayList<>());

    // Create some playlists
    Playlist playlist1 = new Playlist("1", new ArrayList<>(Arrays.asList(song1, song2)), user1, new ArrayList<>(Arrays.asList(user2, user1)));


    Playlist filteredPlaylist = playlist1.exclude(List.of(rock));
        Assertions.assertEquals(filteredPlaylist.getSongs().size(), 1);
}








}
