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
public class LOAITHUCUONG_DTO {

    String _MALOAI, _TENLOAI;

    public LOAITHUCUONG_DTO(String _MALOAI, String _TENLOAI) {
        this._MALOAI = _MALOAI;
        this._TENLOAI = _TENLOAI;
    }
    
    public LOAITHUCUONG_DTO() {
    }

    public String getMALOAI() {
        return _MALOAI;
    }

    public void setMALOAI(String _MALOAI) {
        this._MALOAI = _MALOAI;
    }

    public String getTENLOAI() {
        return _TENLOAI;
    }

    public void setTENLOAI(String _TENLOAI) {
        this._TENLOAI = _TENLOAI;
    }

}
