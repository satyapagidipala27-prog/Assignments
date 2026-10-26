public class Main {
    public static void main(String[] args) {
        Device windows = new WindowsDevice();
        Device mac = new MacDevice();

        // The media type and device can be combined independently.
        MediaFile windowsAudio = new AudioFile(windows, "song.mp3");
        MediaFile macVideo = new VideoFile(mac, "movie.mp4");
        MediaFile macAudio = new AudioFile(mac, "podcast.mp3");
        MediaFile windowsVideo = new VideoFile(windows, "tutorial.mp4");

        windowsAudio.play();
        macVideo.play();
        macAudio.play();
        windowsVideo.play();
    }
}
