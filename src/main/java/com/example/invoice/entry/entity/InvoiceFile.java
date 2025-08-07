package com.example.invoice.entry.entity;  // secondaryEntityManagerFactory 에 맞춘 패키지

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice_invoicefile")  // PDF DB 쪽 실제 테이블명
public class InvoiceFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_nm", length = 255, nullable = false)
    private String fileNm;

    @Column(name = "store_nm", length = 100)
    private String storeNm;

    @Column(name = "dept_nm", length = 100)
    private String deptNm;

    @Column(name = "upload_date")
    private LocalDate uploadDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "inv_key", length = 20)
    private String invKey;


    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFileNm(){
        return  fileNm;
    }
    public void setFileNm(String fileNm){
        this.fileNm = fileNm;
    }
    public String getStoreNm() {
        return storeNm;
    }

    public void setStoreNm(String storeNm) {
        this.storeNm = storeNm;
    }

    public String getDeptNm() {
        return deptNm;
    }

    public void setDeptNm(String deptNm) {
        this.deptNm = deptNm;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getInvKey() {
        return invKey;
    }

    public void setInvKey(String invKey) {
        this.invKey = invKey;
    }
}
