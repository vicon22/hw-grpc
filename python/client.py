import grpc
import user_pb2
import user_pb2_grpc
import expense_pb2
import expense_pb2_grpc

USER_HOST = "user"
USER_PORT = 8090
EXPENSE_HOST = "expense"
EXPENSE_PORT = 8085


def register_user():
    channel = grpc.insecure_channel(f"{USER_HOST}:{USER_PORT}")
    stub = user_pb2_grpc.UserServiceStub(channel)

    request = user_pb2.RegisterUserRequest(name="Evgenii")
    response = stub.RegisterUser(request)

    channel.close()
    print("User registered:", response)


def get_user():
    channel = grpc.insecure_channel(f"{USER_HOST}:{USER_PORT}")
    stub = user_pb2_grpc.UserServiceStub(channel)

    request = user_pb2.GetUserRequest(user_id="1")
    response = stub.GetUser(request)

    channel.close()
    print("User details:", response)


def add_expense():
    channel = grpc.insecure_channel(f"{EXPENSE_HOST}:{EXPENSE_PORT}")
    stub = expense_pb2_grpc.ExpenseServiceStub(channel)

    request = expense_pb2.AddExpenseRequest(amount=1000)
    response = stub.AddExpense(request)

    channel.close()
    print("Expense added:", response)


def get_expenses():
    channel = grpc.insecure_channel(f"{EXPENSE_HOST}:{EXPENSE_PORT}")
    stub = expense_pb2_grpc.ExpenseServiceStub(channel)

    request = expense_pb2.GetExpensesRequest()
    response = stub.GetExpenses(request)

    channel.close()
    print("Expenses list:", response)


if __name__ == "__main__":
    try:
        print("Registering user")
        register_user()

        print("Getting user details")
        get_user()

        print("Adding expense")
        add_expense()

        print("Getting expenses")
        get_expenses()
    except grpc.RpcError as e:
        print(f"gRPC error: {e.code()} - {e.details()}")
    except Exception as e:
        print(f"Unexpected error: {e}")
