package vn.smart.web.infrastructure.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestUtils {

  private static final Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);

  public static String sendPost(List<NameValuePair> nvps, String postUrl, int timeout) throws IOException {
    String result;
    RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(timeout)
        .setConnectTimeout(timeout).setConnectionRequestTimeout(timeout).build();
    try (CloseableHttpClient httpclient =
        HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build()) {
      HttpPost httpPost = new HttpPost(postUrl);
      httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
      httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
      try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
        if (response.getStatusLine().getStatusCode() != 200) {
          throw new IOException(
              "Failed : HTTP getStatusCode: " + response.getStatusLine().getStatusCode()
                  + " HTTP getReasonPhrase: " + response.getStatusLine().getReasonPhrase());
        }
        HttpEntity entity = response.getEntity();
        try (InputStream inputStream = entity.getContent()) {
          result = IOUtils.toString(inputStream, "UTF-8");
        }
      }
    }
    return result;
  }

  public static String sendPostViaProxy(List<NameValuePair> nvps, String postUrl, String proxyHost,
      int proxyPort, int timeout) throws Exception {

    HttpHost proxy = new HttpHost(proxyHost, proxyPort);
    RequestConfig defaultRequestConfig = RequestConfig.custom().setSocketTimeout(timeout)
        .setConnectTimeout(timeout).setConnectionRequestTimeout(timeout).setProxy(proxy).build();
    try (CloseableHttpClient httpclient =
        HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build()) {
      HttpPost httpPost = new HttpPost(postUrl);
      httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
      httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
      try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
        HttpEntity entity = response.getEntity();
        InputStream inputStream = entity.getContent(); ;
        String resp = IOUtils.toString(inputStream, "UTF-8");
        return resp;
      }
    }
  }
}
