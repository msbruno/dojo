FROM python:3.12.2-slim

ENV POETRY_VIRTUALENVS_CREATE=false

WORKDIR /

RUN pip install poetry

COPY . .

RUN poetry install


CMD uvicorn myserver.app:app \
    --port 8001 \
    --host 0.0.0.0