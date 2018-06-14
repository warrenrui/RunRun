package designPattern.filterPattern;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    List<Filter> filters = new ArrayList<Filter>();
    Target target;

    public void setTarget(Target target) {
        this.target = target;
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void preExecute(String request) {
        for (Filter filter : filters) {
            filter.preExecute(request);
        }
        target.doSomething(request);
    }
}
