package com.ziimme.websource.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Table(name = "views_zim_sale_list")
@Immutable
public class SaleAll {
     @Id
     private Long saleId;
     private String empFullname;
     private int cusId;
     private int saleNumber;
     private int saleProduct;
     private int saleCount;
     private int salePayBalance;
     private int salePay;
     private int saleOverdue;
}
