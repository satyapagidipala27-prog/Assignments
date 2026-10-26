/** Abstraction that connects a media type to a playback device. */
public abstract class MediaFile {
    protected final Device device;
    protected final String fileName;

    protected MediaFile(Device device, String fileName) {
        if (device == null || fileName == null || fileName.isBlank()) {
            throw new IllegalArgumentException("Device and file name are required");
        }
        this.device = device;
        this.fileName = fileName;
    }

    public abstract void play();
}
