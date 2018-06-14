package designPattern.filterPattern;

public class FilterManager {
    FilterChain filterChain;

    FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void addFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void preExecute(String request) {
        filterChain.preExecute(request);
    }
}
