package com.example.learnjava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="m_merk")
@Entity
public class Barang {
    private int id;
    private String nama;
    private int status;

    protected Barang() {
    }

    @Id
    // generated value untuk increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setStatus(int newStatus) {
        this.status = newStatus;
    }

    public int getStatus() {
        return status;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String newNama) {
        this.nama = newNama;
    }

    // other getters and setters are hidden for brevity
}
