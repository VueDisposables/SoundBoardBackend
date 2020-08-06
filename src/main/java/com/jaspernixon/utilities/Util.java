package main.java.com.jaspernixon.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import static main.java.com.jaspernixon.utilities.Constants.photosPath;
import static main.java.com.jaspernixon.utilities.Constants.soundsPath;

/**
 * @author John Deegan, jpdeegan97@gmail.com
 * This class has utility functions used thoughout the application. These include functions to
 * retrieve sounds and photos corresponding to a soundboard object.
 */
public class Util {

    Logger logger = LoggerFactory.getLogger(Util.class);

    /**
     * Method to retrieve a map of all sound resources. The key will be the boardName,
     * and the value is another map. The other map contains a key that contains the full path
     * to the sound, and the value is the File object containing that sound.
     * @return Map
     */
    public Map<String, Map<String, File>> retrieveAllResourceSounds() throws IOException {
        String resourcesPath = System.getProperty("user.dir") + soundsPath;
        Map<String, Map<String, File>> finMap = new HashMap<>();
        Map<String, File> sounds = new HashMap<>();
        Files.list(new File(resourcesPath).toPath())
                .limit(10)
                .forEach(path -> {
                    sounds.put(path.toString(), new File(path.toString()));
                });
        return null;

    }

    /**
     * Method to retrieve a map of all sound resources. The key will be the boardName,
     * and the value is another map. The other map contains a key that contains the full path
     * to the photos, and the value is the File object containing that photo.
     * @return Map<String, Map<String, File>>
     */
    public Map<String, Map<String, File>> retrieveAllResourcePhotos(){
        String resourcesPath = System.getProperty("user.dir") + photosPath;
        return null;
    }

    /**
     * Method to retrieve a map with key as sound path and value as File object with path loaded in.
     * @param boardName
     * @return Map<String, File>
     */
    public Map<String, File> retrieveSounds(String boardName) throws IOException {
        String resourcesPath = System.getProperty("user.dir") + photosPath + boardName;
        Files.list(new File(resourcesPath).toPath())
                .limit(10)
                .forEach(path -> {
                    System.out.println(path.toString());
                });
        return null;
    }

    /**
     * Method to retrieve a map with key as sound path and value as File object with path loaded in.
     * @param boardName
     * @return Map<String, File>
     */
    public Map<String, File> retrievePhotos(String boardName) throws IOException {
        String resourcesPath = System.getProperty("user.dir") + photosPath;
        Files.list(new File(resourcesPath).toPath())
                .limit(10)
                .forEach(path -> {
                    System.out.println(path.toString());
                });
        return null;
    }

    /**
     * Helper method to retrieve board name from path.
     * @param path - full path of input file.
     */
    private String pullBoardNameFromPath(String path){
        return path.substring(path.lastIndexOf("\\\\"));
    }


}
