package com.ziimme.websource.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;

@Data
@Entity
@Table(name = "views_zim_sale_list_employee")
@Immutable
public class SaleAllEmp {
     @Id
     private Long saleNumber;
     private String cusFullName;
     private String courseCode;
     private int salePayBalance;
     private int empId;
     private String empFullname;
}
