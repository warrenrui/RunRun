package designPattern.filterPattern;

import designPattern.filterPattern.impl.AuthenticationFilter;
import designPattern.filterPattern.impl.DebugFilter;

public class FilterDemo {
    // 过滤器模式
    public static void main(String[] args) {
        FilterManager filterManager = new FilterManager(new Target());
        filterManager.addFilter(new AuthenticationFilter());
        filterManager.addFilter(new DebugFilter());
        Client client = new Client();
        client.setFiterManager(filterManager);
        client.sendRequest("Home");
    }
}
