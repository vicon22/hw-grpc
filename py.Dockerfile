# Базовый образ Python
FROM python:3.9-slim

# Устанавливаем зависимости
RUN pip install grpcio grpcio-tools

# Создаём рабочую директорию
WORKDIR /app

# Копируем скрипт клиента в контейнер
COPY client.py /app/

# Указываем команду для запуска клиента
CMD ["python", "client.py"]