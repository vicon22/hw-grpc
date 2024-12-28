package com.isupov.homework.impl;

import expense.ExpenseOuterClass;
import expense.ExpenseServiceGrpc;
import io.grpc.stub.StreamObserver;

public class ExpenseServiceImpl extends ExpenseServiceGrpc.ExpenseServiceImplBase {
    @Override
    public void addExpense(ExpenseOuterClass.AddExpenseRequest request, StreamObserver<ExpenseOuterClass.ExpenseResponse> responseObserver) {

        System.out.println("addExpense rq:" + request.toString());
        ExpenseOuterClass.ExpenseResponse response = ExpenseOuterClass.ExpenseResponse.newBuilder()
                .setExpenseId(1)
                .setStatus("OK" + request)
                .build();

        System.out.println("Send response: " + response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getExpenses(ExpenseOuterClass.GetExpensesRequest request, StreamObserver<ExpenseOuterClass.ExpensesListResponse> responseObserver) {
        System.out.println("getExpenses rq:" + request.toString());
        ExpenseOuterClass.ExpensesListResponse response = ExpenseOuterClass.ExpensesListResponse.newBuilder()
                .addExpenses(ExpenseOuterClass.Expense.newBuilder()
                        .setExpenseId("1")
                        .setAmount(1000)
                        .build())
                .build();

        System.out.println("Send response: " + response);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
