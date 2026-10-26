/** Refined abstraction for audio media. */
public class AudioFile extends MediaFile {
    public AudioFile(Device device, String fileName) {
        super(device, fileName);
    }

    @Override
    public void play() {
        device.playAudio(fileName);
    }
}
