from fastapi import FastAPI
import time
from opentelemetry import trace
from opentelemetry.sdk.trace import TracerProvider
from opentelemetry.metrics import get_meter

provider = TracerProvider()
trace.set_tracer_provider(provider)
tracer = trace.get_tracer(__name__)
app = FastAPI()

meter = get_meter("example-meter")
counter = meter.create_counter("example-counter")

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
                "foo":"bar"
                }