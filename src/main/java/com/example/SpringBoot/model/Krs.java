package com.example.SpringBoot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "krs")
public class Krs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_krs")
    private Long idKrs;


    @Column(nullable = false)
    private String nim;

    @Column(nullable = false, name = "kode matakuliah")
    private String kodeMatakuliah;

    @Column(nullable = false)
    private String matakuliah;

    @Column(nullable = false)
    private String semester;

    @Column(nullable = false)
    private String tahunakademik;

    public Krs() {
    }

    public Krs(String nim, String kodeMatakuliah, String matakuliah, String semester, String tahunakademik) {
        this.nim = nim;
        this.kodeMatakuliah = kodeMatakuliah;
        this.matakuliah = matakuliah;
        this.semester = semester;
        this.tahunakademik = tahunakademik;
    }

    public Long getIdKrs() {
        return idKrs;
    }

    public void setIdKrs(Long idKrs) {
        this.idKrs = idKrs;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKodeMatakuliah() {
        return kodeMatakuliah;
    }

    public void setKodeMatakuliah(String kodeMatakuliah) {
        this.kodeMatakuliah = kodeMatakuliah;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTahunakademik() {
        return tahunakademik;
    }

    public void setTahunakademik(String tahunakademik) {
        this.tahunakademik = tahunakademik;
    }
}
