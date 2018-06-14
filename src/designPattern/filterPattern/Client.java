package designPattern.filterPattern;

public class Client {
    FilterManager filterManager;

    public void setFiterManager(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public void sendRequest(String request) {
        filterManager.preExecute(request);
    }
}
