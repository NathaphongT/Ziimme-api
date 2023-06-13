package com.ziimme.websource.models;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "zim_txt_data_sale_muti")
public class SaleMuti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id_muti")
    private int sale_id_muti;

    @Column(name = "sale_id")
    private int sale_id;

    @Column(name = "sale_id_course")
    private int sale_id_course;

    public SaleMuti() {

    }

    public SaleMuti(int sale_id_muti, int sale_id,int sale_id_course) {
        this.sale_id_muti = sale_id_muti;
        this.sale_id = sale_id;
        this.sale_id_course = sale_id_course;
    }

    @Override
    public String toString() {
        return String.format(
                "Sale[sale_id_muti=%d,sale_id=%d, sale_id_course=%d]",
                sale_id_muti, sale_id, sale_id_course);
    }

}
