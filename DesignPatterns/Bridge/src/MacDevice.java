/** Concrete implementor for macOS. */
public class MacDevice implements Device {
    @Override
    public void playAudio(String fileName) {
        System.out.println("Mac playing audio: " + fileName);
    }

    @Override
    public void playVideo(String fileName) {
        System.out.println("Mac playing video: " + fileName);
    }
}
