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
public class THUCUONG_DTO {

    String _MANUOC, _MALOAI, _TENNUOC, _SIZE, _TRANGTHAI;
    float _GIA;

    public THUCUONG_DTO(String _MANUOC, String _MALOAI, String _TENNUOC, String _SIZE, String _TRANGTHAI, float _GIA) {
        this._MANUOC = _MANUOC;
        this._MALOAI = _MALOAI;
        this._TENNUOC = _TENNUOC;
        this._SIZE = _SIZE;
        this._TRANGTHAI = _TRANGTHAI;
        this._GIA = _GIA;
    }
    public THUCUONG_DTO() {
    }
    
    public String getMANUOC() {
        return _MANUOC;
    }

    public void setMANUOC(String _MANUOC) {
        this._MANUOC = _MANUOC;
    }

    public String getMALOAI() {
        return _MALOAI;
    }

    public void setMALOAI(String _MALOAI) {
        this._MALOAI = _MALOAI;
    }

    public String getTENNUOC() {
        return _TENNUOC;
    }

    public void setTENNUOC(String _TENNUOC) {
        this._TENNUOC = _TENNUOC;
    }

    public String getSIZE() {
        return _SIZE;
    }

    public void setSIZE(String _SIZE) {
        this._SIZE = _SIZE;
    }

    public String getTRANGTHAI() {
        return _TRANGTHAI;
    }

    public void setTRANGTHAI(String _TRANGTHAI) {
        this._TRANGTHAI = _TRANGTHAI;
    }

    public float getGIA() {
        return _GIA;
    }

    public void setGIA(float _GIA) {
        this._GIA = _GIA;
    }
    
}
