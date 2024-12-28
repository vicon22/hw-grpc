package com.isupov.homework;

import expense.ExpenseOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import expense.ExpenseServiceGrpc;
import user.User;
import user.UserServiceGrpc;

public class GrpcClient {

    private static final String USER_HOST = "user";
//    private static final String USER_HOST = "localhost";
    private static final int USER_PORT = 8090;
    private static final String EXPENSE_HOST = "expense";
//    private static final String EXPENSE_HOST = "localhost";
    private static final int EXPENSE_PORT = 8085;
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Client Started");

        try {

        System.out.println("Регистрация пользователя");
        registerUser();
        System.out.println("Получение данных пользователя");
        getUser();
        System.out.println("Добавление трат пользователя");
        addExpense();
        System.out.println("Получение трат пользователя");
        getExpense();
    } catch (Exception e) {
        System.out.println(e);
    }

        Thread.sleep(20000 * 1000);
    }

    private static void addExpense() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(EXPENSE_HOST, EXPENSE_PORT)
                .usePlaintext()
                .build();

        ExpenseServiceGrpc.ExpenseServiceBlockingStub stub
                = ExpenseServiceGrpc.newBlockingStub(channel);

        ExpenseOuterClass.ExpenseResponse response = stub.addExpense(ExpenseOuterClass.AddExpenseRequest.newBuilder()
                .setAmount(1000)
                .build());

        channel.shutdown();

        System.out.println(response);
    }

    private static void getExpense() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(EXPENSE_HOST, EXPENSE_PORT)
                .usePlaintext()
                .build();

        ExpenseServiceGrpc.ExpenseServiceBlockingStub stub
                = ExpenseServiceGrpc.newBlockingStub(channel);

        ExpenseOuterClass.ExpensesListResponse response = stub.getExpenses(ExpenseOuterClass.GetExpensesRequest.newBuilder()
                .build());

        channel.shutdown();

        System.out.println(response);
    }

    private static void registerUser() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(USER_HOST, USER_PORT)
                .usePlaintext()
                .build();

        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        User.UserResponse response = stub.registerUser(User.RegisterUserRequest.newBuilder()
                        .setName("Evgenii")
                .build());

        channel.shutdown();

        System.out.println(response);
    }

    private static void getUser() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(USER_HOST, USER_PORT)
                .usePlaintext()
                .build();

        UserServiceGrpc.UserServiceBlockingStub stub
                = UserServiceGrpc.newBlockingStub(channel);

        User.UserResponse response = stub.getUser(User.GetUserRequest.newBuilder()
                .setUserId("1")
                .build());

        channel.shutdown();

        System.out.println(response);
    }
}
