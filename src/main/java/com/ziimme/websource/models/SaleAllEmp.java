package com.ziimme.websource.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Table(name = "views_zim_sale_list_employee")
public class SaleAllEmp {
     @Id
     private int saleId;
     private String saleNumber;
     private String cusFullName;
     private String cusMember;
     private String cusBranch;
     private String courseId;
     private String saleBalance;
     private String courseNameEng;
     private String courseNameTh;
     private String courseCode;
     private Date saleDate;
     private int empId;
}
