from fastapi import FastAPI
import time
from opentelemetry import trace
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.metrics import get_meter
from opentelemetry.sdk.resources import Resource, SERVICE_NAME, SERVICE_VERSION
from opentelemetry.sdk.metrics import MeterProvider
from opentelemetry.metrics import get_meter
from opentelemetry.sdk.metrics.export import PeriodicExportingMetricReader, ConsoleMetricExporter, MetricExporter
from opentelemetry.exporter.otlp.proto.grpc.metric_exporter import OTLPMetricExporter

provider = TracerProvider()
trace.set_tracer_provider(provider)
tracer = trace.get_tracer(__name__)
app = FastAPI()

# add resource - identify a source of metric 
resource = Resource(
    attributes={
        SERVICE_NAME:'my-great-app',
        SERVICE_VERSION: '0.1.0'
})

meter = get_meter("example-meter")
counter = meter.create_counter("example-counter")

# add reader to collect metrics from provider.
# it should connect to a export, to send it to something else
exporter = ConsoleMetricExporter()
reader_console = PeriodicExportingMetricReader(exporter=exporter)
reader_otlp = PeriodicExportingMetricReader(OTLPMetricExporter())

# add provider, to aggregate metrics
provider = MeterProvider(resource=resource, metric_readers=[reader_otlp, reader_console])
meter = get_meter('my-meter', meter_provider=provider)
counter = meter.create_counter(
    name='pix.creditados',
    unit='1',
    description='Pix creditados'
)


@app.get("/")
def get_homepage():
        count = 1
        while count <= 3:
                with tracer.start_as_current_span(f"loop-count-{count}") as span:
                        print(f"Loop {count}")
                        count += 1
                        time.sleep(1)
        counter.add(1)
        return {
                "status":"ok",
                "msg":"test"
                }

@app.get("/pix/{pessoa}/{fonte}/{minutos}")
def insert_pix(pessoa:str, fonte:str, minutos:int):
        with tracer.start_as_current_span(f"cria-pix") as span:
                time.sleep(1)
        with tracer.start_as_current_span(f"gera_transacao") as span:
                time.sleep(2)
        with tracer.start_as_current_span(f"finaliza_transacao") as span:
                time.sleep(minutos)
                
        counter.add(
            amount=1, 
            attributes={
                'conta' : pessoa,
                'tipo' : fonte
            }
        )   
            
        return {
                "status":"ok",
                "msg":"pix enviado"
                }