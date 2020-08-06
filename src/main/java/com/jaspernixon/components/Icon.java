package main.java.com.jaspernixon.components;

import io.vertx.core.json.JsonObject;
import kotlin.Triple;
import main.java.com.jaspernixon.utilities.BorderStyle;
import main.java.com.jaspernixon.utilities.Util;
import main.java.com.jaspernixon.utilities.IconSize;
import org.slf4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author John Deegan, jdeegan, jpdeegan97@gmail.com
 *
 * This class contains backend POJO implementation of a Icon object. These objects have the
 * ability to hold a list of sounds, a list of pictures, and display settings that will
 */
public class Icon {

    // Member Variables
    Logger logger;
    String boardName;
    JsonObject displaySettings;
    Map<String, File> sounds;
    Map<String, File> photos;
    Util util;

    // Getters and Setters
    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public String getBoardName() {
        return boardName;
    }
    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }
    public JsonObject getDisplaySettings() {
        return displaySettings;
    }
    public void setDisplaySettings(JsonObject displaySettings) {
        this.displaySettings = displaySettings;
    }
    public Map<String, File> getSounds() {
        return sounds;
    }
    public void setSounds(Map<String, File> sounds) {
        this.sounds = sounds;
    }
    public Map<String, File> getPhotos() {
        return photos;
    }
    public void setPhotos(Map<String, File> photos) {
        this.photos = photos;
    }
    public Util getUtil() {
        return util;
    }
    public void setUtil(Util util) {
        this.util = util;
    }

    // CONSTRUCTORS
    /**
     * Default constructor..
     */
    public Icon(){
        setBoardName("");
        setDisplaySettings(new HashMap<String, Object>());
        setPhotos(new HashMap<String, File>());
        setSounds(new HashMap<String, File>());
        setUtil(new Util());
    }
    /**
     * Constructor to populate member variables with input.
     * @param boardName
     * @param displaySettings
     * @param sounds
     * @param photos
     * @param util
     */
    public Icon(String boardName, Map<String, Object> displaySettings,
                Map<String, File> sounds, Map<String, File> photos, Util util) {
        Objects.requireNonNull(boardName);
        Objects.requireNonNull(displaySettings);
        Objects.requireNonNull(sounds);
        Objects.requireNonNull(photos);
        Objects.requireNonNull(util);

        setBoardName(boardName);
        setDisplaySettings(displaySettings);
        setSounds(sounds);
        setPhotos(photos);
        setUtil(util);
    }

    // METHODS
    /**
     * Helper method to populate sounds with files in resources.
     * @return boolean - true if successfull populated, false otherwise.
     */
    private boolean populateSounds() throws IOException {
        Map<String, File> sounds = getUtil().retrieveSounds(getBoardName());
        if(sounds.isEmpty()){
            logger.warn("Was not able to obtain a response when populating sounds.");
            return false;
        }
        setSounds(sounds);
        return true;
    }

    /**
     * Helper method to populate photos with files in resources.
     * @return boolean - true if successfull populated, false otherwise.
     */
    private boolean populatePhotos() throws IOException {
        Map<String, File> photos = getUtil().retrievePhotos(getBoardName());
        if(photos.isEmpty()){
            logger.warn("Was not able to obtain a response when populating photos.");
            return false;
        }
        setPhotos(photos);
        return true;
    }

    private boolean populateDisplaySettings() {
        return defaultDisplaySettings();
    }

    private JsonObject defaultDisplaySettings(){
        return new JsonObject()
        .put("border", true)
        .put("boarderWeight", 6)
        .put("boarderStyle", BorderStyle.SOLID)
        .put("boarderColor", Color.DARK_GRAY)
        .put("blackAndWhitePhoto", false)
        .put("iconSize", IconSize.LARGE)
        .put("alternatingSoundsActive", true)
        .put("alternatingPhotosActive", true)
        .put("movementEffectsActive", false)
        .put("isDisplayed", true)
        .put("presentOnStartup", true);
    }

}
