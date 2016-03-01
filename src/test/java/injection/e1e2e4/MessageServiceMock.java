package injection.e1e2e4;

public class MessageServiceMock {
	private String key;

    private String message;

    
    public void add(String key, String message) {
        this.key = key;
        this.message = message;
    }

   
    public String message(String key) {
        return message;
    }

    
    public String key(String message) {
        return key;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
