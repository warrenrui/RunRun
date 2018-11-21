package shortcut.http;

/**
 * 自定义异常
 */
public class InvokeXLinkException extends RuntimeException {
    private static final long serialVersionUID = 20170805L;

    public InvokeXLinkException() {
    }

    public InvokeXLinkException(String message) {
        super(message);
    }

    public InvokeXLinkException(String message, Throwable cause) {
        super(message, cause);
    }

}