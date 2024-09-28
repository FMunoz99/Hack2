package dbp.hackathon.QR;

public class QR {
    private String data;
    private String path;

    public QR(String data, String path) {
        this.data = data;
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
