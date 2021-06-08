package com.sly.supos.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.URI;
import java.util.*;

@Slf4j
public class HttpClientUtil {

    // 建立连接的事件
    private static final int HTTP_CONNECTION_TIMEOUT = 5000;
    // 数据等待时间（两个连续数据包之间的最大数据间隔）
    private static final int HTTP_SOCKET_TIMEOUT = 60000;
    // 从 connect Manager 获取连接的最大时长
    // 使用 HttpClientBuilder.create().build() 获取 httpClient 时，会内置一个 HttpClientConnectionManager
    private static final int HTTP_CONNECTION_MANAGER_TIMEOUT = 5000;

    private static final RequestConfig config = RequestConfig.custom().
            setConnectTimeout(HTTP_CONNECTION_TIMEOUT).
            setConnectionRequestTimeout(HTTP_CONNECTION_MANAGER_TIMEOUT).
            setSocketTimeout(HTTP_SOCKET_TIMEOUT).build();

    /**
     * get请求
     * @return
     */
    public static Reply doGet(String url) {
        return doGet(url, null);
    }

    /**
     * get请求
     * @return
     */
    public static Reply doGet(String url, Map<String, String> headers) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Content-Type", "application/json");
            if (headers != null && headers.size() > 0) {
                headers.forEach((k, v) -> httpGet.setHeader(k, v));
            }
            CloseableHttpResponse response = httpClient.execute(httpGet);
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(EntityUtils.toString(response.getEntity()));
            return reply;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get请求
     * @return
     */
    public static Reply doGet(String url, Map<String, String> headers,Map<String,String> params) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            URIBuilder uriBuilder = new URIBuilder(url);
            if (params != null && params.size() > 0) {
                params.forEach((k, v) -> uriBuilder.addParameter(k, v));
            }
            // 根据带参数的URI对象构建GET请求对象
            HttpGet httpGet = new HttpGet(uriBuilder.build());

            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Content-Type", "application/json");
            if (headers != null && headers.size() > 0) {
                headers.forEach((k, v) -> httpGet.setHeader(k, v));
            }

            CloseableHttpResponse response = httpClient.execute(httpGet);
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(EntityUtils.toString(response.getEntity()));
            return reply;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * post请求(用于key-value格式的参数)
     * @param url
     * @param params
     * @return
     */
    public static Reply doPost(String url, Map params) {
        BufferedReader in = null;
        try (CloseableHttpClient client = HttpClients.createDefault()){
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

            }
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));

            HttpResponse response = client.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"utf-8"));
            StringBuffer sb = new StringBuffer();
            String line = "";
            String nl = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + nl);
            }
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(sb.toString());
            return reply;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static Reply doPost(String url, String params) throws Exception {
        CloseableHttpResponse response = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()){
            HttpPost httpPost = new HttpPost(url);// 创建httpPost
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            String charSet = "UTF-8";
            StringEntity entity = new StringEntity(params, charSet);
            httpPost.setEntity(entity);
            response = httpclient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String jsonString = EntityUtils.toString(responseEntity);
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(jsonString);
            return reply;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  post请求（用于请求json格式的参数），额外添加header
     * @param url
     * @param params
     * @param header
     * @return
     * @throws Exception
     */
    public static Reply doPost(String url, String params, Map<String, String> header) throws Exception {
        CloseableHttpResponse response = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()){
            HttpPost httpPost = new HttpPost(url);// 创建httpPost
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-Type", "application/json");
            if(header != null){
                for (String key : header.keySet()) {
                    httpPost.setHeader(key, header.get(key));
                }
            }
            String charSet = "UTF-8";
            StringEntity entity = new StringEntity(params, charSet);
            httpPost.setEntity(entity);
            response = httpclient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String jsonString = EntityUtils.toString(responseEntity);
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(jsonString);
            return reply;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * put请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static Reply doPut(String url, String params) throws Exception {
        CloseableHttpResponse response = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()){
            HttpPut httpPut = new HttpPut(url);//创建put请求
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-Type", "application/json");
            String charSet = "UTF-8";
            StringEntity entity = new StringEntity(params, charSet);
            httpPut.setEntity(entity);
            response = httpclient.execute(httpPut);
            HttpEntity responseEntity = response.getEntity();
            String jsonString = EntityUtils.toString(responseEntity);
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(jsonString);
            return reply;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Reply postMultipart(String url, Map params)  {
        BufferedReader in = null;
        try (CloseableHttpClient httpclient = HttpClients.createDefault()){
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200).setSocketTimeout(2000).build();
            // 实例化HTTP方法
            HttpPost request = new HttpPost(url);
            request.setConfig(requestConfig);
            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
            if (null != params) {
                for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                    String name = (String) iter.next();
                    if (null != params.get(name)) {
                        if (params.get(name) instanceof File) {
                            multipartEntityBuilder.addBinaryBody(name,(File) params.get(name));
                        } else if (params.get(name) instanceof String) {
                            multipartEntityBuilder.addTextBody(name, params.get(name).toString());
                        }
                    }
                }
                HttpEntity httpEntity = multipartEntityBuilder.build();
                request.setEntity(httpEntity);
            }
            HttpResponse response = httpclient.execute(request);

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"utf-8"));
            StringBuffer sb = new StringBuffer();
            String line = "";
            String nl = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + nl);
            }
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(sb.toString());
            return reply;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * get请求
     * @return
     */
    public static Reply doDelete(String url, Map<String, String> headers) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpDelete httpDelete = new HttpDelete(url);
            httpDelete.setHeader("Accept", "application/json");
            httpDelete.setHeader("Content-Type", "application/json");
            if (headers != null && headers.size() > 0) {
                headers.forEach((k, v) -> httpDelete.setHeader(k, v));
            }
            CloseableHttpResponse response = httpClient.execute(httpDelete);
            Reply reply = new Reply();
            reply.setCode(response.getStatusLine().getStatusCode());
            reply.setData(EntityUtils.toString(response.getEntity()));
            return reply;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 设置请求参数
     *
     * @param
     * @return
     */
    private static List<NameValuePair> setHttpParams(Map<String, String> paramMap) {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> set = paramMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return formParams;
    }

    /**
     * 获得响应HTTP实体内容
     *
     * @param response
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public static String getHttpEntityContent(HttpResponse response) throws IOException, UnsupportedEncodingException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            try (InputStream is = entity.getContent();
                 InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                 BufferedReader br = new BufferedReader(isr);) {
                String line = br.readLine();
                StringBuilder sb = new StringBuilder();
                while (line != null) {
                    sb.append(line + "\n");
                    line = br.readLine();
                }
                return sb.toString();
            } catch (Exception e) {
                log.error("GetHttpEntityContent failed", e);
            }
        }
        return "";
    }
}
