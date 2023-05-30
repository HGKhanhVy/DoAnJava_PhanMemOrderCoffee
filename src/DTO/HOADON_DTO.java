/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author DELL
 */
public class HOADON_DTO {
    String _MAHOADON,_MANHANVIEN, _TENHOADON,_TRANGTHAI,_MABAN;
    String _NGAYXUAT;
    String _GIORA,_GIOVAO;

    public String getMAHOADON() {
        return _MAHOADON;
    }

    public void setMAHOADON(String _MAHOADON) {
        this._MAHOADON = _MAHOADON;
    }

    public String getMANHANVIEN() {
        return _MANHANVIEN;
    }

    public void setMANHANVIEN(String _MANHANVIEN) {
        this._MANHANVIEN = _MANHANVIEN;
    }

    public String getTENHOADON() {
        return _TENHOADON;
    }

    public void setTENHOADON(String _TENHOADON) {
        this._TENHOADON = _TENHOADON;
    }

    public String getTRANGTHAI() {
        return _TRANGTHAI;
    }

    public void setTRANGTHAI(String _TRANGTHAI) {
        this._TRANGTHAI = _TRANGTHAI;
    }

    public String getMABAN() {
        return _MABAN;
    }

    public void setMABAN(String _MABAN) {
        this._MABAN = _MABAN;
    }

    public String getNGAYXUAT() {
        return _NGAYXUAT;
    }

    public void setNGAYXUAT(String _NGAYXUAT) {
        this._NGAYXUAT = _NGAYXUAT;
    }

    public String getGIORA() {
        return _GIORA;
    }

    public void setGIORA(String _GIORA) {
        this._GIORA = _GIORA;
    }

    public String getGIOVAO() {
        return _GIOVAO;
    }

    public void setGIOVAO(String _GIOVAO) {
        this._GIOVAO = _GIOVAO;
    }

    public HOADON_DTO(String _MAHOADON, String _MANHANVIEN, String _TENHOADON, String _TRANGTHAI, String _MABAN, String _NGAYXUAT, String _GIOVAO) {
        this._MAHOADON = _MAHOADON;
        this._MANHANVIEN = _MANHANVIEN;
        this._TENHOADON = _TENHOADON;
        this._TRANGTHAI = _TRANGTHAI;
        this._MABAN = _MABAN;
        this._NGAYXUAT = _NGAYXUAT;
        this._GIOVAO = _GIOVAO;
    }
    public HOADON_DTO(String _MAHOADON, String _MANHANVIEN, String _NGAYXUAT, String _TRANGTHAI, String _MABAN) {
        this._MAHOADON = _MAHOADON;
        this._MANHANVIEN = _MANHANVIEN;
        this._TRANGTHAI = _TRANGTHAI;
        this._MABAN = _MABAN;
        this._NGAYXUAT = _NGAYXUAT;
    }
    public HOADON_DTO() {
    }
}
