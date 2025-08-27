# Log
## Textos da documentação:
- OTEL não define API de log: *OpenTelemetry does not define a bespoke API or SDK to create logs. Instead, OpenTelemetry logs are **the existing logs you already have** from a logging framework or infrastructure component.* 
- OTEL suporta todos formatos, pois apenas adiciona contexto: *OpenTelemetry’s support for logs is designed to be fully compatible with what you already have, providing capabilities **to wrap those logs with additional context** and a common toolkit to parse and manipulate logs into a common format across many different sources.*
- *A log record represents the recording of an event.* 
- Logs não possuem padrão estrutural, apenas uma ideia de estrutura, através dos atributos top-level. 
![alt text](image.png)

-Exemplos: https://github.com/open-telemetry/opentelemetry-specification/blob/v1.48.0/oteps/logs/0097-log-data-model.md#example-log-records

  - Importante: ***These are just examples to help understand the data model. Don’t treat the examples as the way to represent this data model in JSON.***
  


## Exemplo em Python:
### Usando Loguru:
```
{
  "text": "2025-08-27 11:18:24.423 | CRITICAL | __main__:<module>:32 - aaaaaaaa\n",
  "record": {
    "elapsed": { "repr": "0:00:00.056200", "seconds": 0.0562 },
    "exception": null,
    "extra": {},
    "file": {
      "name": "log2.py",
      "path": "/home/silva/dev/dojo/dojo/python/telemetry/myserver/log2.py"
    },
    "function": "<module>",
    "level": { "icon": "☠️", "name": "CRITICAL", "no": 50 },
    "line": 32,
    "message": "aaaaaaaa",
    "module": "log2",
    "name": "__main__",
    "process": { "id": 40941, "name": "MainProcess" },
    "thread": { "id": 138073536110720, "name": "MainThread" },
    "time": {
      "repr": "2025-08-27 11:18:24.423822-03:00",
      "timestamp": 1756304304.423822
    }
  }
}
```
### Encapsulando com OTEL:
Body representa o log, demais propriedades adicionam infos de contexto.
```
{
    "body": "{\"text\": \"2025-08-27 11:18:24.423 | CRITICAL | __main__:<module>:32 - aaaaaaaa\", \"record\": {\"elapsed\": {\"repr\": \"0:00:00.056200\", \"seconds\": 0.0562}, \"exception\": null, \"extra\": {}, \"file\": {\"name\": \"log2.py\", \"path\": \"/home/silva/dev/dojo/dojo/python/telemetry/myserver/log2.py\"}, \"function\": \"<module>\", \"level\": {\"icon\": \"\u2620\ufe0f\", \"name\": \"CRITICAL\", \"no\": 50}, \"line\": 32, \"message\": \"aaaaaaaa\", \"module\": \"log2\", \"name\": \"__main__\", \"process\": {\"id\": 40941, \"name\": \"MainProcess\"}, \"thread\": {\"id\": 138073536110720, \"name\": \"MainThread\"}, \"time\": {\"repr\": \"2025-08-27 11:18:24.423822-03:00\", \"timestamp\": 1756304304.423822}}}\n",
    "severity_number": 21,
    "severity_text": "CRITICAL",
    "attributes": {
        "code.filepath": "/home/silva/dev/dojo/dojo/python/telemetry/myserver/log2.py",
        "code.function": "<module>",
        "code.lineno": 32
    },
    "dropped_attributes": 0,
    "timestamp": "2025-08-27T14:18:24.424022Z",
    "observed_timestamp": "2025-08-27T14:18:24.424093Z",
    "trace_id": "0x00000000000000000000000000000000",
    "span_id": "0x0000000000000000",
    "trace_flags": 0,
    "resource": {
        "attributes": {
            "service.name": "LogAPP"
        },
        "schema_url": ""
    }
}