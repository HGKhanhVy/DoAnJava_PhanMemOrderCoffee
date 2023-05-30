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
public class BAN_DTO {
    String _MABAN,_TENBAN ,_TRANGTHAI;

    public String getMABAN() {
        return _MABAN;
    }

    public void setMABAN(String _MABAN) {
        this._MABAN = _MABAN;
    }

    public String getTENBAN() {
        return _TENBAN;
    }

    public void setTENBAN(String _TENBAN) {
        this._TENBAN = _TENBAN;
    }

    public String getTRANGTHAI() {
        return _TRANGTHAI;
    }

    public void setTRANGTHAI(String _TRANGTHAI) {
        this._TRANGTHAI = _TRANGTHAI;
    }

    public BAN_DTO(String _MABAN, String _TENBAN, String _TRANGTHAI) {
        this._MABAN = _MABAN;
        this._TENBAN = _TENBAN;
        this._TRANGTHAI = _TRANGTHAI;
    }

   
    
}
