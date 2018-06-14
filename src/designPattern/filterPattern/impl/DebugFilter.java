package designPattern.filterPattern.impl;

import designPattern.filterPattern.Filter;

public class DebugFilter implements Filter {

    @Override
    public void preExecute(String request) {
        System.out.println("DebugFilter " + request);
    }

}
