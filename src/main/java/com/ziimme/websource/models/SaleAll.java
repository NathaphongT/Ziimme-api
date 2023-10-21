package com.ziimme.websource.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
@Table(name = "views_zim_sale_list")

public class SaleAll {
     @Id
     private int saleProductId;
     private int saleId;
     private int cusId;
     private int courseId;
     private int saleCount;
     private String saleCutCount;
     private String saleNumber;
     private String courseCode;
     private String courseNameTh;
     private String empFullname;
     private String saleBalance;
     private String salePayment;
     private String saleOverdue;
     private String saleExtraPay;
     private String salePayOver;
     private String saleDetail;
     private Date saleDate;
     private String saleCutDownDetail;
     private String saleStatus;

}
