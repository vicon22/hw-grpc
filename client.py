import grpc

def create_channel():
    # Адрес сервера (замените "expense:8085" на ваш фактический адрес)
    server_address = "expense:8085"

    try:
        # Создаем небезопасный канал
        channel = grpc.insecure_channel(server_address)

        # Проверяем состояние канала
        grpc.channel_ready_future(channel).result(timeout=10)
        print(f"Successfully connected to gRPC server at {server_address}")

        # Возвращаем канал для дальнейшего использования
        return channel
    except Exception as e:
        print(f"Failed to connect to gRPC server at {server_address}: {e}")

if __name__ == "__main__":
    channel = create_channel()