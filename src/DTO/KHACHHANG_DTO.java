/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DELL
 */
public class KHACHHANG_DTO {
    String _MAKHACHHANG, _THOIGIANDEN, _MABAN;

    public String getMAKHACHHANG() {
        return _MAKHACHHANG;
    }

    public void setMAKHACHHANG(String _MAKHACHHANG) {
        this._MAKHACHHANG = _MAKHACHHANG;
    }

    public String getTHOIGIANDEN() {
        return _THOIGIANDEN;
    }

    public void setTHOIGIANDEN(String _THOIGIANDEN) {
        this._THOIGIANDEN = _THOIGIANDEN;
    }

    public String getMABAN() {
        return _MABAN;
    }

    public void setMABAN(String _MABAN) {
        this._MABAN = _MABAN;
    }

    public KHACHHANG_DTO(String _MAKHACHHANG, String _THOIGIANDEN, String _MABAN) {
        this._MAKHACHHANG = _MAKHACHHANG;
        this._THOIGIANDEN = _THOIGIANDEN;
        this._MABAN = _MABAN;
    }
    
    
}
