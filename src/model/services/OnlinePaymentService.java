package model.services;
//Interface para serviços de pagamento online

public interface OnlinePaymentService {

    double paymentFee(double amount);
    double interest(double amount, int months);
}
