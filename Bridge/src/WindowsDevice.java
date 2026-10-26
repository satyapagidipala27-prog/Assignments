/** Concrete implementor for Windows. */
public class WindowsDevice implements Device {
    @Override
    public void playAudio(String fileName) {
        System.out.println("Windows playing audio: " + fileName);
    }

    @Override
    public void playVideo(String fileName) {
        System.out.println("Windows playing video: " + fileName);
    }
}
