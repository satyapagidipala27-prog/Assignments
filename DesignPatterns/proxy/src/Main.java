
interface FileDownloader {
    void downloadFile(String fileName);
}

class RealFileDownloader implements FileDownloader {

    public RealFileDownloader() {
        System.out.println("RealFileDownloader created.");
    }

    @Override
    public void downloadFile(String fileName) {
        System.out.println("Downloading large file: " + fileName);
        System.out.println("File downloaded successfully.");
    }
}

class FileDownloadProxy implements FileDownloader {

    private RealFileDownloader realDownloader;
    private String user;
    private boolean authorized;

    public FileDownloadProxy(String user, boolean authorized) {
        this.user = user;
        this.authorized = authorized;
    }

    @Override
    public void downloadFile(String fileName) {

        System.out.println("Log: " + user
                + " requested " + fileName);

        if (!authorized) {
            System.out.println(
                    "Access denied. User is not authorized.");
            return;
        }

        System.out.println("Access granted to " + user);

        if (realDownloader == null) {
            realDownloader = new RealFileDownloader();
        }

        realDownloader.downloadFile(fileName);

        System.out.println("Log: Download completed for "
                + user);
    }
}

public class Main {

    public static void main(String[] args) {

        FileDownloader authorizedUser =
                new FileDownloadProxy("Kaushik", true);

        FileDownloader unauthorizedUser =
                new FileDownloadProxy("Guest", false);

        System.out.println("=== Authorized Request ===");
        authorizedUser.downloadFile("report.pdf");

        System.out.println();

        System.out.println("=== Unauthorized Request ===");
        unauthorizedUser.downloadFile("confidential.zip");
    }
}
