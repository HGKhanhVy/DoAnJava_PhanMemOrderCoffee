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
public class CT_HOADON_DTO {

    String _MANUOC, _MAHOADON, _TENNUOC;
    int _SL;
    float _DONGIA, _THANHTIEN;

    public String getMANUOC() {
        return _MANUOC;
    }

    public void setMANUOC(String _MANUOC) {
        this._MANUOC = _MANUOC;
    }

    public String getMAHOADON() {
        return _MAHOADON;
    }

    public void setMAHOADON(String _MAHOADON) {
        this._MAHOADON = _MAHOADON;
    }

    public String getTENNUOC() {
        return _TENNUOC;
    }

    public void setTENNUOC(String _TENNUOC) {
        this._TENNUOC = _TENNUOC;
    }

    public int getSL() {
        return _SL;
    }

    public void setSL(int _SL) {
        this._SL = _SL;
    }

    public float getDONGIA() {
        return _DONGIA;
    }

    public void setDONGIA(float _DONGIA) {
        this._DONGIA = _DONGIA;
    }

    public float getTHANHTIEN() {
        return _THANHTIEN;
    }

    public void setTHANHTIEN(float _THANHTIEN) {
        this._THANHTIEN = _THANHTIEN;
    }

    public CT_HOADON_DTO(String _MANUOC, String _MAHOADON, String _TENNUOC, int _SL, float _DONGIA, float _THANHTIEN) {
        this._MANUOC = _MANUOC;
        this._MAHOADON = _MAHOADON;
        this._TENNUOC = _TENNUOC;
        this._SL = _SL;
        this._DONGIA = _DONGIA;
        this._THANHTIEN = _THANHTIEN;
    }
     public CT_HOADON_DTO(String _MANUOC, String _MAHOADON, String _TENNUOC, int _SL, float _DONGIA) {
        this._MANUOC = _MANUOC;
        this._MAHOADON = _MAHOADON;
        this._TENNUOC = _TENNUOC;
        this._SL = _SL;
        this._DONGIA = _DONGIA;
    }
}
