/** Refined abstraction for video media. */
public class VideoFile extends MediaFile {
    public VideoFile(Device device, String fileName) {
        super(device, fileName);
    }

    @Override
    public void play() {
        device.playVideo(fileName);
    }
}
