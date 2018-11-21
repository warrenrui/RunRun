package shortcut.http;

import com.alibaba.fastjson.JSON;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

/**
 * 通过XLink发送
 */
public class AbstractSendToOuterSystemViaXLink {
    private static final Logger logger = LoggerFactory.getLogger(AbstractSendToOuterSystemViaXLink.class);
    protected static final String PREFIX = "WMS.LOCATE.ORDER";
    protected static final String SEPARATOR = ".";
    protected static final String RESULT_CODE_SUCCESS = "1";
    private String url = "http://xwms.jd.test/link/outbound/bill/billReceive";

    public static void main(String[] args) {
        final AbstractSendToOuterSystemViaXLink abstractSendToOuterSystemViaXLink = new AbstractSendToOuterSystemViaXLink();
        abstractSendToOuterSystemViaXLink.sendViaXLink("", "");
    }

    public String sendViaXLink(String routeRule, Object content) {
        final PostMethod postMethod;
        final HttpClient httpClient = new HttpClient();
        postMethod = new PostMethod(url);
        postMethod.setRequestHeader("Content-Type", "application/json");
        postMethod.setRequestHeader("routerule", routeRule);
        postMethod.setRequestHeader("source", "1");
        String param;
        param = JSON.toJSONString(content);
        try {
            postMethod.setRequestEntity(new StringRequestEntity(param, "application/json", "UTF-8"));
            logger.error("invoke XLink post:" + JSON.toJSONString(postMethod.getRequestEntity()));
        } catch (UnsupportedEncodingException e) {
            throw new InvokeXLinkException("发送请求编码格式异常：" + e.getMessage(), e);
        }

        int resultCode;
        try {
            resultCode = httpClient.executeMethod(postMethod);
        } catch (IOException e) {
            throw new InvokeXLinkException("调用XLink异常：" + e.getMessage(), e);
        }

        String invokeResult;
        try {
            invokeResult = postMethod.getResponseBodyAsString();
        } catch (IOException e) {
            throw new InvokeXLinkException("解析XLink返回结果异常：" + e.getMessage(), e);
        }
        if (resultCode != HttpStatus.SC_OK) {
            throw new InvokeXLinkException(MessageFormat.format("调用XLink返回码：{0}，结果：{1}， routeRule：{2}", resultCode, invokeResult, routeRule));
        }
        return invokeResult;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
