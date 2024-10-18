package com.ankur.bms.bookmyshowjune.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{

    private String referenceId;

    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;

}
