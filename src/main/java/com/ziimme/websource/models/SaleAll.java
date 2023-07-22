package com.ziimme.websource.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Table(name = "views_zim_sale_list")

public class SaleAll {
     @Id
     private int saleProductId;
     private int saleId;
     private int cusId;
     private int saleCount;
     private String courseId;
     private String courseNameTh;
     private String courseCode;
     private String empFullname;
     private int saleNumber;
     private int salePayBalance;
     private int salePay;
     private int saleOverdue;
}
