package designPattern.filterPattern.impl;

import designPattern.filterPattern.Filter;

public class AuthenticationFilter implements Filter {

    @Override
    public void preExecute(String request) {
        System.out.println("AuthenticationFilter " + request);
    }

}
