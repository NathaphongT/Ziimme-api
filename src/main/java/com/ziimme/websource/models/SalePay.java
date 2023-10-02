package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_txt_data_sale_pay")
public class SalePay {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "sale_pay_id")
     private int salePayId;

     @Column(name = "sale_extra_pay")
     private int saleExtraPay;

     @Column(name = "sale_pay_date")
     private Date salePayDate;

     @Column(name = "sale_pay_detail")
     private String salePayDetail;

     @Column(name = "sale_pay_course")
     private String salePayCourse;

     @Column(name = "sale_pay_balance")
     private int salePayBalance;

     @Column(name = "sale_last_payment")
     private String saleLastPayment;

     @Column(name = "sale_pay_over")
     private int salePayOver;

     @Column(name = "course_id")
     private int courseId;

     @Column(name = "sale_product_id")
     private int saleProductId;

     @Column(name = "sale_id")
     private int saleId;

     @Column(name = "cus_id")
     private int cusId;

     @Column(name = "record_status")
     private String recordStatus;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Asia/Bangkok")
     @Column(name = "created_time")
     private Date createdTime;

     @Column(name = "created_by")
     private String createdBy;

     @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "Asia/Bangkok")
     @Column(name = "updated_time")
     private Date updatedTime;

     @Column(name = "updated_by")
     private String updatedBy;

}
