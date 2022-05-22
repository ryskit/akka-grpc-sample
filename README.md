# akka-grpc-sample

## How to request

```sh
grpcurl -d '{"name": "FOO"}' -plaintext \
-import-path ./src/main/protobuf \
-proto ticker.proto \
localhost:9090 ticker.TickerService/MonitorSymbol
```

