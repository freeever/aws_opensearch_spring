package com.aws.opensearch.spring.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.opensearch.client.RestClient;
import org.opensearch.client.RestClientBuilder;
import org.opensearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class OpenSearchConfig {

    @Value("${opensearch.hostname}")
    private String hostname;

    @Value("${opensearch.scheme}")
    private String scheme;

    @Value("${opensearch.port}")
    private int port;

    @Value("${opensearch.username}")
    private String username;

    @Value("${opensearch.password}")
    private String password;

    @Autowired
    private Environment _env;

    @Bean
    public CredentialsProvider credentialsProvider() {
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(getUsername(), getPassword()));

        return credentialsProvider;
    }

    @Bean
    public RestHighLevelClient client() {
        RestClientBuilder builder = RestClient.builder(new HttpHost(getHostname(), getPort(), getScheme()))
                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
                    @Override
                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider());
                    }
                });
        return new RestHighLevelClient(builder);
    }

    public String getHostname() {
        String envHost = _env.getProperty("OPENSEARCH_HOST");
        return StringUtils.isBlank(envHost) ? hostname : envHost;
    }

    public String getScheme() {
        String envScheme = _env.getProperty("OPENSEARCH_SCHEME");
        return StringUtils.isBlank(envScheme) ? scheme : envScheme;
    }

    public int getPort() {
        String envPort = _env.getProperty("OPENSEARCH_PORT");
        return StringUtils.isBlank(envPort) ? port : Integer.valueOf(envPort);
    }

    public String getUsername() {
        String envUser = _env.getProperty("OPENSEARCH_USER");
        return StringUtils.isBlank(envUser) ? username : envUser;
    }

    public String getPassword() {
        String envPass = _env.getProperty("OPENSEARCH_PASSWORD");
        return StringUtils.isBlank(envPass) ? password : envPass;
    }
}
