# Studying Opentelemetry

## DEV-LOG
### 1 - add FastAPI simple server with Uvicorn, instrument with Opentelemetry and send to Jaeger
#### 1.1- add packages and test uvicorn config
-  ``` pip install fastapi uvicorn ```
-  ``` uvicorn myserver.app:app --host 0.0.0.0 --port 3000 ```

#### 1.2- run local instance Jaeger 
- ``` docker run -d --name jaeger   -e COLLECTOR_ZIPKIN_HOST_PORT=9411   -e COLLECTOR_OTLP_ENABLED=true   -e OTEL_METRICS_EXPORTER='none'   -p 4317:4317   -p 4318:4318   -p 5775:5775/udp   -p 6831:6831/udp   -p 6832:6832/udp   -p 5778:5778   -p 16686:16686   -p 14268:14268   -p 14269:14269   -p 14250:14250   -p 9411:9411   jaegertracing/all-in-one ```

#### 1.3- add and run opentelemetry
- ```poetry add opentelemetry-distro```
- ```opentelemetry-instrument --service_name my.api uvicorn myserver.app:app```

### 2 - Containerization 
#### 2.1- add poetry
- ``` pip install poetry```
- ``` poetry init ```

#### 2.2 - add containers config
- add files **docker** and **docker-compose**
  
#### 2.3 - add nginx
- add file **etc\nginx.conf**
- add config to **docker-compose.yml**


