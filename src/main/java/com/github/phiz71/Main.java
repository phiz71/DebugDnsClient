package com.github.phiz71;

import io.vertx.core.Vertx;
import io.vertx.core.dns.DnsClient;
import io.vertx.core.dns.DnsClientOptions;

public class Main {

    public static void main(String[] args) {
        DnsClientOptions options = new DnsClientOptions();
        options.setHost("212.27.40.240");
        //options.setHost("8.8.8.8");
        options.setPort(53);

        options.setLogActivity(true);
        options.setRecursionDesired(true);

        DnsClient client = Vertx.vertx().createDnsClient(options);
        client.lookup("google.com", ar -> {
        //client.lookup4("google.com", ar -> {
        //client.lookup6("google.com", ar -> {
            if (ar.succeeded()) {
                System.out.println("IP address is " + ar.result());
            } else {
                ar.cause().printStackTrace();
                System.out.println("Could not resolve entry " + ar.cause().getMessage());
            }
        });
    }
}
