package com.highman.prometheus;

import io.prometheus.client.Counter;
import io.prometheus.client.Summary;

public class MetricsRegisters {
    public static Counter requests = Counter.build()
            .name("grpc_requests_total")
            .help("Total number of gRPC requests.")
            .register();

    public static Summary requestLatency = Summary.build()
            .name("grpc_request_latency_seconds")
            .help("Latency of gRPC requests.")
            .register();
}
