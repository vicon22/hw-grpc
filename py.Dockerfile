FROM python:3.9-slim

RUN pip install grpcio grpcio-tools

WORKDIR /app

COPY python/. /app/.

CMD ["python", "client.py"]